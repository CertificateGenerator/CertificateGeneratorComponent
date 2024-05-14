package br.ucsal;

import java.io.File;

public class Participante {

	private String nome;
	private String email;
	private String nomeEvento;
	private File certificado;
	private int cargaHorariaEvento;
	
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
		return String.format(
				"Participante [nome=%s, cpf=%s, email=%s, nomeEvento=%s, certificado=%s, cargaHorariaEvento=%s]", nome
				, email, nomeEvento, certificado, cargaHorariaEvento);
	}
	
}
