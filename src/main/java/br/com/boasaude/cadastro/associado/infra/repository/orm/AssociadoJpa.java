package br.com.boasaude.cadastro.associado.infra.repository.orm;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.boasaude.cadastro.associado.core.domain.enums.Status;
import br.com.boasaude.cadastro.associado.core.domain.vo.Cpf;
import br.com.boasaude.cadastro.associado.core.domain.vo.Rg;
import br.com.boasaude.cadastro.associado.core.domain.vo.TelefoneVO;
import br.com.boasaude.cadastro.associado.core.domain.vo.TipoPlano;


@Entity
@Table(name = "boasaude_associado")
public class AssociadoJpa {

	@Id 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	@Embedded
	private Cpf cpf;
	
	@NotNull
	@Embedded
	private Rg rg;
	
	@NotNull
	@Embedded
	private TelefoneVO telefone;
	
	@NotNull
	private String numeroCarteira;
	
	@NotNull
	private String nomeDaMae;
	
	@NotNull
	private Boolean titular;
	
	@NotNull
	private LocalDateTime dataNascimento;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPlano tipo;
	
	@NotNull
	private Status status;

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

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public Rg getRg() {
		return rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

	public TelefoneVO getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneVO telefone) {
		this.telefone = telefone;
	}

	public String getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(String numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public Boolean getTitular() {
		return titular;
	}

	public void setTitular(Boolean titular) {
		this.titular = titular;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoPlano getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlano tipo) {
		this.tipo = tipo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	

}
