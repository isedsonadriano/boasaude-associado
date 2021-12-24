package br.com.boasaude.cadastro.associado.infra.repository.orm;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.boasaude.cadastro.associado.core.domain.vo.Cpf;
import br.com.boasaude.cadastro.associado.core.domain.vo.TipoPlano;


@Entity
@Table(name = "boasaude_associado")
public class AssociadoJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	@Embedded
	private Cpf cpf;
	
	@NotNull
	private String numeroCarteira;

	@NotNull
	@Enumerated(EnumType.STRING)
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

	public void setNome(String name) {
		this.nome = name;
	}

	public TipoPlano getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlano gender) {
		this.tipo = gender;
	}

	public String getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(String numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

}
