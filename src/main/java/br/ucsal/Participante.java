package br.ucsal;

import java.io.File;

/**
 * This class represents a participant in an event.
 */
public class Participante {

    private String nome;
    private String email;
    private String nomeEvento;
    private File certificado;
    private int cargaHorariaEvento;

    /**
     * Constructs a Participante with the specified details.
     *
     * @param nome the name of the participant
     * @param email the email of the participant
     * @param nomeEvento the name of the event
     * @param cargaHorariaEvento the hours of participation in the event
     */
    public Participante(String nome, String email, String nomeEvento, int cargaHorariaEvento) {
        this.nome = nome;
        this.email = email;
        this.nomeEvento = nomeEvento;
        this.cargaHorariaEvento = cargaHorariaEvento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public File getCertificado() {
        return certificado;
    }

    public int getCargaHorariaEvento() {
        return cargaHorariaEvento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public void setCertificado(File certificado) {
        this.certificado = certificado;
    }

    public void setCargaHorariaEvento(int cargaHorariaEvento) {
        this.cargaHorariaEvento = cargaHorariaEvento;
    }

    @Override
    public String toString() {
        return String.format("Participante [nome=%s, email=%s, nomeEvento=%s, certificado=%s, cargaHorariaEvento=%s]", nome, email, nomeEvento, certificado, cargaHorariaEvento);
    }
}
