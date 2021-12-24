package br.com.boasaude.cadastro.associado.core.domain.vo;

public class Cpf {

	private String numero;

	public Cpf(String cpf) {
		this.numero = cpf;
	}
	
	public Cpf() {
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
