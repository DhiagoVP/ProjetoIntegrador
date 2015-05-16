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
import dao.AlunoDAO;
import dao.PagamentoDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import model.Aluno;
import model.Beneficio;
import model.DadosEspecificos;
import model.Pagamento;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Collections.sort(pagamento.getBeneficios(), new Comparator());
        document.open();
        document.add(createTable(pagamento, dados));
        document.close();
    }

    private PdfPTable createTable(Pagamento pagamento, DadosEspecificos dados) throws DocumentException {
        int colunas = 7 + pagamento.getBeneficios().size();
        PdfPTable table = new PdfPTable(colunas);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Câmpus: " + pagamento.getTurma().getCampusOfertante()
                + " Mês: " + pagamento.getMes() + " Planilha: " + dados.getNroPanilha()));
        cell.setColspan(colunas);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Nome do curso: " + pagamento.getTurma().getCurso().getNome()
                + " Código SISTEC: " + dados.getSistec() + " LC: " + dados.getLc()));
        cell.setColspan(colunas);
        table.addCell(cell);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        cell = new PdfPCell(new Phrase("Data de inicio do curso: " + df.format(pagamento.getTurma().
                getDataInicioAulas()).replace("00:00:00", "")
                + " Fim previsto do curso: " + df.format(pagamento.getTurma().getDataTerminoAulas())
                .replace("00:00:00", "")));
        cell.setColspan(colunas);
        table.addCell(cell);

        table.addCell("Nome");
        table.addCell("CPF");
        table.addCell("Banco");
        table.addCell("Agência");
        table.addCell("Conta");
        for (Beneficio b : pagamento.getBeneficios()) {
            table.addCell(b.getTipo() + " R$");
        }
        table.addCell("Faltas R$");
        table.addCell("Valor Total R$");
        double totalFaltas = 0.0, totalBeneficio = 0.0,
                valorBeneficio;
        for (Aluno aluno : pagamento.getAlunos()) {
            if (aluno.isRecece()) {
                table.addCell(aluno.getNome());
                table.addCell(aluno.getCpf());
                table.addCell(aluno.getContaBancaria().getNomeBanco());
                table.addCell(aluno.getContaBancaria().getAgencia() + "");
                table.addCell(aluno.getContaBancaria().getNumeroConta() + "");
                for (Beneficio beneficio : pagamento.getBeneficios()) {
                    valorBeneficio = (pagamento.getDiasLetivos() - aluno.getFaltas()) * beneficio.getValor();
                    table.addCell("R$ " + valorBeneficio);
                }
                table.addCell("R$ " + aluno.getValorDescontado());
                totalFaltas += aluno.getValorDescontado();
                table.addCell("R$ " + aluno.getValorRecebido());
            }
        }
        table.addCell("Total");
        table.addCell("");
        table.addCell("");
        table.addCell("");
        table.addCell("");
            for (Beneficio b : pagamento.getBeneficios()) {
                try {
                    totalBeneficio = new PagamentoDAO().recuperarTotalPagoPorBeneficio(b.getId(), pagamento.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.addCell("R$ "+ totalBeneficio);
        }
        table.addCell("R$ " + totalFaltas);
        table.addCell("R$ " + pagamento.getValorAPagarPorTurma());
        float[] columnWidths = new float[0];
        if (colunas == 9) {
            columnWidths = new float[]{27f, 18f, 8f, 10f, 13f, 15f, 15f, 13f, 15f};
        } else if (colunas == 8) {
            columnWidths = new float[]{27f, 18f, 9f, 12f, 13f, 15f, 13f, 17f};
        }
        table.setWidths(columnWidths);
        return table;
    }

    class Comparator implements java.util.Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Beneficio b1 = (Beneficio) o1;
            Beneficio b2 = (Beneficio) o2;

            return b1.getTipo().compareTo(b2.getTipo());
        }

    }
}
