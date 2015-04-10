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

    private PdfPTable createTable(Pagamento pagamento, DadosEspecificos dados) throws DocumentException {
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
        double totalTransporte = 0.0, totalAlimentacao = 0.0, totalFaltas = 0.0,
                 valorBeneficio = 0.0;
        for(Aluno aluno : pagamento.getAlunos()){
            table.addCell(aluno.getNome());
            table.addCell(aluno.getCpf());
            table.addCell(aluno.getContaBancaria().getNomeBanco());
            table.addCell(aluno.getContaBancaria().getAgencia()+"");
            table.addCell(aluno.getContaBancaria().getNumeroConta()+"");
            for(Beneficio beneficio : pagamento.getBenefios()){
                valorBeneficio = (pagamento.getDiasLetivos() - aluno.getFaltas()) * beneficio.getValor();
                table.addCell("R$"+ valorBeneficio);
                if(beneficio.getTipo().equals("Vale Alimentação"))
                    totalAlimentacao += valorBeneficio;
                else
                    totalTransporte += valorBeneficio;
            }
            table.addCell("R$" + aluno.getValorDescontado());
            totalFaltas += aluno.getValorDescontado();
            table.addCell("R$" + aluno.getValorRecebido());
        }
        table.addCell("Total");
        table.addCell("");
        table.addCell("");
        table.addCell("");
        table.addCell("");
        table.addCell("R$ " + totalTransporte);
        table.addCell("R$ " + totalAlimentacao);
        table.addCell("R$ " + totalFaltas);
        table.addCell("R$ " + pagamento.getValorAPagarPorTurma());
        
        float[] columnWidths = new float[] {27f, 18f, 6f, 9f, 13f, 15f, 15f, 13f, 15f};
        table.setWidths(columnWidths);
        return table;
    }
}
