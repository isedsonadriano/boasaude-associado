package br.com.boasaude.cadastro.associado.infra.config;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;
import br.com.boasaude.cadastro.associado.core.domain.enums.Status;
import br.com.boasaude.cadastro.associado.core.domain.vo.Cpf;
import br.com.boasaude.cadastro.associado.core.domain.vo.Rg;
import br.com.boasaude.cadastro.associado.core.domain.vo.TelefoneVO;
import br.com.boasaude.cadastro.associado.core.domain.vo.TipoPlano;
import br.com.boasaude.cadastro.associado.core.service.AssociadoService;
import br.com.boasaude.cadastro.associado.core.util.Paginador;
import br.com.boasaude.cadastro.associado.infra.integration.ConsultaAssociados;
import br.com.boasaude.cadastro.associado.infra.integration.dto.AssociadoDTO;
import br.com.boasaude.cadastro.associado.infra.integration.dto.AssociadosDTO;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AssociadoDump {
	
	@Autowired
	private AssociadoService associadoService;
	
	@Autowired
	private ConsultaAssociados consultaAssociados;
	
	@Autowired
	protected ModelMapper modelMapper;
	
	
	@EventListener(classes = ContextRefreshedEvent.class )
	public void iniciarBancoDeDados () {
		log.info("Início inserção associados");
		if(isBancoVazio()) {
			inserirAssociadosDb();
		}
		
		log.info("Fim inserção associados");
	}

	private boolean isBancoVazio() {
		return this.associadoService.capturarTodos(new Paginador()).size() == 0;
	}

	private void inserirAssociadosDb() {
		AssociadosDTO associados = consultaAssociados.consulta();
		for (AssociadoDTO dto : associados.getAssociados()) {
			Associado associado = new Associado();
			associado.setCpf(new Cpf(dto.getCpf()));
			associado.setId(dto.getId());
			associado.setNome(dto.getNome());
			associado.setCpf(associado.getCpf());
			associado.setNumeroCarteira(dto.getNumeroCarteira());
			associado.setTipoPlano(TipoPlano.EMPRESARIAL);
			associado.setStatus(Status.ATIVO);
			associado.setNomeDaMae(dto.getNomeDaMae());
			associado.setTelefone(new TelefoneVO(dto.getTelefone()));
			associado.setRg(new Rg(dto.getRg()));
			associado.setTitular(Boolean.TRUE);
			associado.setDataNascimento(LocalDateTime.now());
			this.associadoService.salvar(associado);
		}
	}

}
