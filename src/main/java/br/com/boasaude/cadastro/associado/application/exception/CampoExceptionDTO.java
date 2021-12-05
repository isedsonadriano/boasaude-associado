package br.com.boasaude.cadastro.associado.application.exception;

import lombok.Data;

@Data
public class CampoExceptionDTO {

	private String campo;
	private String erro;
	
	public CampoExceptionDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
}
