package br.com.boasaude.cadastro.associado.core.domain.entity;

import java.time.LocalDateTime;

import br.com.boasaude.cadastro.associado.core.domain.enums.Status;
import br.com.boasaude.cadastro.associado.core.domain.vo.Cpf;
import br.com.boasaude.cadastro.associado.core.domain.vo.Rg;
import br.com.boasaude.cadastro.associado.core.domain.vo.TelefoneVO;
import br.com.boasaude.cadastro.associado.core.domain.vo.TipoPlano;

public class Associado {

	private Long id;
	private String nome;
	private Cpf cpf;
	private String numeroCarteira;
	private TipoPlano tipoPlano;
	private TelefoneVO telefone;
	private Status status;
	private LocalDateTime dataNascimento;
	private String nomeDaMae;
	private Rg rg;
	private Boolean titular;
	

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

	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(TipoPlano tipo) {
		this.tipoPlano = tipo;
	}

	public String getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(String numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public TelefoneVO getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneVO telefone) {
		this.telefone = telefone;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public Rg getRg() {
		return rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

	public Boolean getTitular() {
		return titular;
	}

	public void setTitular(Boolean titular) {
		this.titular = titular;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

}
