package br.ucsal;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class is responsible for generating certificates for participants.
 */
public class CertificateGenerator {

    private Generator generator;
    private String outputPath;

    /**
     * Constructs a CertificateGenerator with a specified output path.
     *
     * @param outputPath the path where certificates will be saved
     */
    public CertificateGenerator(String outputPath) {
        this.outputPath = outputPath;
        generator = new Generator();
    }

    /**
     * Generates certificates for a list of participants.
     *
     * @param participants the list of participants
     */
    public void generateCertificatesFromList(List<Participante> participants) {
        for (Participante participant : participants) {
            generator.createDocument(participant, outputPath);
        }
    }

    /**
     * Generates certificates for participants from an Excel file.
     *
     * @param file the Excel file containing participant data
     */
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
