package br.ucsal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class handles reading participants from an Excel file.
 */
public class ParticipanteService {

    /**
     * Reads the participants from an Excel file.
     *
     * @param selectedFile the Excel file
     * @param nomeEvento the name of the event
     * @param cargaHorariaEvento the hours of participation in the event
     * @return the list of participants
     */
    public List<Participante> lerPlanilhaDeParticipantes(File selectedFile, String nomeEvento, int cargaHorariaEvento) {
        List<Participante> listaParticipantes = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(selectedFile);
             XSSFWorkbook planilha = new XSSFWorkbook(fis)) {
            XSSFSheet participantes = planilha.getSheetAt(0);
            int numThreads = Runtime.getRuntime().availableProcessors();
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

            for (Row linha : participantes) {
                Runnable rowProcessingTask = () -> processRow(linha, listaParticipantes, nomeEvento, cargaHorariaEvento);
                executor.submit(rowProcessingTask);
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return listaParticipantes;
    }

    /**
     * Processes a row in the Excel file.
     *
     * @param linha the row to process
     * @param listaParticipantes the list of participants
     * @param nomeEvento the name of the event
     * @param cargaHorariaEvento the hours of participation in the event
     */
    private void processRow(Row linha, List<Participante> listaParticipantes, String nomeEvento, int cargaHorariaEvento) {
        String nome = "";
        String cpf = "";
        String email = "";

        for (Cell celula : linha) {
            switch (celula.getColumnIndex()) {
                case 0:
                    nome = celula.getStringCellValue();
                    break;
                case 1:
                    cpf = String.valueOf((long) celula.getNumericCellValue());
                    break;
                case 2:
                    email = celula.getStringCellValue();
                    break;
            }
        }
        System.out.println("[PARTICIPANTE SERVICE] Informacoes lidas com sucesso da planilha para o participante: " + nome);
        synchronized (listaParticipantes) {
            listaParticipantes.add(new Participante(nome, email, nomeEvento, cargaHorariaEvento));
        }
    }
}
