package br.ucsal;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CertificateGenerator {

    private Generator generator;
    private String outputPath;

    public CertificateGenerator(String outputPath) {
        this.outputPath = outputPath;
        generator = new Generator();
    }

    public void generateCertificatesFromList(List<Participante> participants) {
        for (Participante participant : participants) {
            generator.createDocument(participant, outputPath);
        }
    }

    public void generateCertificatesFromFile(File file) {
        try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                String name = row.getCell(0).getStringCellValue();
                String email = row.getCell(1).getStringCellValue();
                Participante participant = new Participante(name, email, "Event", 10);
                generator.createDocument(participant, outputPath);
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
