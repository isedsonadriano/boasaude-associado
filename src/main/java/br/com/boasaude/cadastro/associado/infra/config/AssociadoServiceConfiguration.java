package br.com.boasaude.cadastro.associado.infra.config;

import br.com.boasaude.cadastro.associado.core.repository.AssociadoRepository;
import br.com.boasaude.cadastro.associado.core.service.AssociadoService;
import br.com.boasaude.cadastro.associado.core.service.implementation.AssociadoServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class AssociadoServiceConfiguration {

	@Bean
    public AssociadoService clientService(AssociadoRepository repository){
        return new AssociadoServiceImpl(repository);
    }
}
