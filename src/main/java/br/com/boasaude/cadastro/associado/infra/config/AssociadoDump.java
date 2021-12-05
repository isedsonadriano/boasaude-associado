package br.com.boasaude.cadastro.associado.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;

import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;
import br.com.boasaude.cadastro.associado.core.domain.vo.TipoPlano;
import br.com.boasaude.cadastro.associado.core.service.AssociadoService;
import br.com.boasaude.cadastro.associado.core.util.Paginador;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AssociadoDump {
	
	private static final int QUANTIDADE_ASSOCIADOS_DUMP = 50;

	@Autowired
	private Faker faker;
	
	@Autowired
	private AssociadoService associadoService;
	
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
		for (int i = 0; i < QUANTIDADE_ASSOCIADOS_DUMP; i++) {
			Associado associado = new Associado();
			associado.setId(faker.random().nextLong());
			associado.setNome(faker.company().name());
			associado.setTipo(TipoPlano.getRandomTipoAssociado());
			associado.setCpf(String.valueOf(faker.random().nextLong()));
			
			this.associadoService.salvar(associado);
		}
	}

}
