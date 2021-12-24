package br.com.boasaude.cadastro.associado.core.service.implementation;

import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;
import br.com.boasaude.cadastro.associado.core.exception.DomainException;
import br.com.boasaude.cadastro.associado.core.repository.AssociadoRepository;
import br.com.boasaude.cadastro.associado.core.service.AssociadoService;
import br.com.boasaude.cadastro.associado.core.util.Paginador;

import java.util.List;
import java.util.Objects;

public class AssociadoServiceImpl implements AssociadoService {

	final private AssociadoRepository clientRepository;

	public AssociadoServiceImpl(AssociadoRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Associado> capturarTodos(Paginador paginador) {
		return clientRepository.capturarTodos(paginador);
	}

	@Override
	public Associado capturarPorId(Long id) {
		return clientRepository.capturarPorId(id);
	}

	@Override
	public void salvar(Associado associado) {
		DomainException.throwIf(Objects.nonNull(this.clientRepository.findByCpf(associado.getCpf().getNumero())), "Associado já cadastrado");
		this.clientRepository.salvar(associado);
	}

	@Override
	public void atualizar(Associado associado) {
		this.clientRepository.atualizar(associado);
	}

	@Override
	public void deletar(Long id) {
		this.clientRepository.deletar(id);
	}
}
