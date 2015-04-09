/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import model.Aluno;
import model.Beneficio;
import model.DadosEspecificos;
import model.Pagamento;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ana Paula
 */
public class GeradorPDF {

    public void createPdf(String filename, Pagamento pagamento, DadosEspecificos dados)
            throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(0, 0, 50, 50);
        document.open();
        document.add(createTable(pagamento, dados));
        document.close();
    }

    private PdfPTable createTable(Pagamento pagamento, DadosEspecificos dados) {
        PdfPTable table = new PdfPTable(9);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Câmpus: "+ pagamento.getTurma().getCampusOfertante() 
                +" Mês: "+ pagamento.getMes() +" Planilha: "+ dados.getNroPanilha()));
        cell.setColspan(9);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Nome do curso: "+ pagamento.getTurma().getCurso().getNome() +
                " Código SISTEC: "+ dados.getSistec() +" LC: " + dados.getLc()));
        cell.setColspan(9);
        table.addCell(cell);
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        cell = new PdfPCell(new Phrase("Data de inicio do curso: "+ df.format(pagamento.getTurma().
                getDataInicioAulas()).replace("00:00:00", "")+
                " Fim previsto do curso: " + df.format(pagamento.getTurma().getDataTerminoAulas())
                        .replace("00:00:00", "")));
        cell.setColspan(9);
        table.addCell(cell);

        table.addCell("Nome");
        table.addCell("CPF");
        table.addCell("Banco");
        table.addCell("Agência");
        table.addCell("Conta");
        table.addCell("Vale Transporte R$");
        table.addCell("Vale Alimentação R$");
        table.addCell("Faltas R$");
        table.addCell("Valor Total R$");
        for(Aluno aluno : pagamento.getAlunos()){
            table.addCell(aluno.getNome());
            table.addCell(aluno.getCpf());
            table.addCell(aluno.getContaBancaria().getNomeBanco());
            table.addCell(aluno.getContaBancaria().getAgencia()+"");
            table.addCell(aluno.getContaBancaria().getNumeroConta()+"");
            for(Beneficio beneficio : pagamento.getBenefios()){
                table.addCell("R$"+ (pagamento.getDiasLetivos() - aluno.getFaltas()) * beneficio.getValor());
            }
            table.addCell("R$" + aluno.getValorDescontado());
            table.addCell("R$" + aluno.getValorRecebido());
        }
        return table;
    }
}
