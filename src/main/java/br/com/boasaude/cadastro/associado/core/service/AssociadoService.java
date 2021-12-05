package br.com.boasaude.cadastro.associado.core.service;

import java.util.List;

import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;
import br.com.boasaude.cadastro.associado.core.util.Paginador;

public interface AssociadoService {

	public List<Associado> capturarTodos(Paginador paginador);

	public Associado capturarPorId(Long id);

	public void salvar(Associado associado);

	public void atualizar(Associado associado);

	public void deletar(Long id);

}
