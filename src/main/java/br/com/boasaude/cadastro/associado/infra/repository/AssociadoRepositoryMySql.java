package br.com.boasaude.cadastro.associado.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.boasaude.cadastro.associado.infra.repository.orm.AssociadoJpa;

@Repository
public interface AssociadoRepositoryMySql extends JpaRepository<AssociadoJpa, Long> {

	AssociadoJpa findByCpfNumeroCpf(String cpf);


}
