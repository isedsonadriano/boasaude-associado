package br.com.boasaude.cadastro.associado.core.domain.entity;

import br.com.boasaude.cadastro.associado.core.domain.vo.TipoPlano;

public class Associado {

	private Long id;
	private String nome;
	private String cpf;
	private TipoPlano tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPlano getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlano tipo) {
		this.tipo = tipo;
	}

}
