package br.com.boasaude.cadastro.associado.infra.integration.dto;

import java.util.ArrayList;
import java.util.List;

public class AssociadosDTO {

	private List<AssociadoDTO> associados;

	public List<AssociadoDTO> getAssociados() {
		if (associados == null) {
			associados = new ArrayList<AssociadoDTO>();
		}
		return associados;
	}

	public void setAssociados(List<AssociadoDTO> associados) {
		this.associados = associados;
	}

}
