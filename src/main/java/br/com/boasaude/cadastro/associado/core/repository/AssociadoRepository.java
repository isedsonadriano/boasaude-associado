package br.com.boasaude.cadastro.associado.core.repository;

import java.util.List;

import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;
import br.com.boasaude.cadastro.associado.core.util.Paginador;

public interface AssociadoRepository {

	void salvar(Associado associado);

	Associado capturarPorId(Long id);

	List<Associado> capturarTodos(Paginador paginador);

	void atualizar(Associado associado);

	void deletar(Long id);

	Associado findByCpf(String cpf);

}
