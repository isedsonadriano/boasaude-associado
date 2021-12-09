package br.com.boasaude.cadastro.associado.infra.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.boasaude.cadastro.associado.infra.integration.dto.AssociadosDTO;

@FeignClient(name = "ConsultaAssociados", url = "${api.external.middleware.saf.associados}")
public interface ConsultaAssociados {

	@GetMapping()
	AssociadosDTO consulta();
}
