package br.com.boasaude.cadastro.associado.infra.config;

import br.com.boasaude.cadastro.associado.core.repository.AssociadoRepository;
import br.com.boasaude.cadastro.associado.core.repository.implementation.AssociadoRepositoryImpl;
import br.com.boasaude.cadastro.associado.infra.repository.AssociadoRepositoryMySql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssociadoRepositoryConfiguration {

    @Bean
    public AssociadoRepository clientRepository(AssociadoRepositoryMySql repository) {
        return new AssociadoRepositoryImpl(repository);
    }

}