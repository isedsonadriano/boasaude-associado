package br.com.boasaude.cadastro.associado.core.repository.implementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;
import br.com.boasaude.cadastro.associado.core.domain.vo.Cpf;
import br.com.boasaude.cadastro.associado.core.domain.vo.TipoPlano;
import br.com.boasaude.cadastro.associado.core.repository.AssociadoRepository;
import br.com.boasaude.cadastro.associado.core.util.Paginador;
import br.com.boasaude.cadastro.associado.infra.repository.AssociadoRepositoryMySql;
import br.com.boasaude.cadastro.associado.infra.repository.orm.AssociadoJpa;

public class AssociadoRepositoryImpl implements AssociadoRepository {

	private final AssociadoRepositoryMySql repository;

	public AssociadoRepositoryImpl(AssociadoRepositoryMySql repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public void salvar(Associado associado) {
		AssociadoJpa associadoSalvo = repository.saveAndFlush(buildAssociadoJpa(associado));
		associado.setId(associadoSalvo.getId());
	}

	@Override
	public Associado capturarPorId(Long id) {
		AssociadoJpa associadoJpa = repository.findById(id).get();
		Associado associado = new Associado();
		associado.setNome(associadoJpa.getNome());
		associado.setNomeDaMae(associadoJpa.getNomeDaMae());
		associado.setCpf(associadoJpa.getCpf());
		associado.setRg(associadoJpa.getRg());
		associado.setTipoPlano(associadoJpa.getTipo());
		associado.setDataNascimento(associadoJpa.getDataNascimento());
		associado.setStatus(associado.getStatus());
		associado.setNumeroCarteira(associadoJpa.getNumeroCarteira());
		associado.setTelefone(associadoJpa.getTelefone());
		return associado;
	}

	@Override
	public List<Associado> capturarTodos(Paginador paginador) {
		return capturarAssociadosBD(paginador);
	}

	private List<Associado> capturarAssociadosBD(Paginador paginador) {
		PageRequest paginaRetorno =   PageRequest.of(paginador.getPageNumber(), paginador.getPageSize(), Sort.by("id").descending());
		return repository.findAll(paginaRetorno).get().map(this::buildAssociado).collect(Collectors.toList());
	}

	@Override
	public void atualizar(Associado associado) {
		Optional<AssociadoJpa> associadoJpa = this.repository.findById(associado.getId());
		if (associadoJpa.isPresent()) {
			associadoJpa.get().setCpf(new Cpf(associado.getCpf().getNumeroCpf()));
		}
		this.repository.save(associadoJpa.get());
	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

	private Associado buildAssociado(AssociadoJpa associadoJpa) {
		if(Objects.isNull(associadoJpa)) {
			return null;
		}
		Associado associado = new Associado();
		associado.setId(associadoJpa.getId());
		associado.setNome(associadoJpa.getNome());
		associado.setCpf(associadoJpa.getCpf());
		associado.setNumeroCarteira(associadoJpa.getNumeroCarteira());
		associado.setTipoPlano(TipoPlano.getRandomTipoAssociado());
		return associado;
	}

	private AssociadoJpa buildAssociadoJpa(Associado associado) {
		AssociadoJpa associadoJpa = new AssociadoJpa();
		associadoJpa.setNome(associado.getNome());
		associadoJpa.setNomeDaMae(associado.getNomeDaMae());
		associadoJpa.setTelefone(associado.getTelefone());
		associadoJpa.setCpf(associado.getCpf());
		associadoJpa.setRg(associado.getRg());
		associadoJpa.setTipo(associado.getTipoPlano());
		associadoJpa.setDataNascimento(associado.getDataNascimento());
		associadoJpa.setTitular(associado.getTitular());
		associadoJpa.setStatus(associado.getStatus());
		associadoJpa.setNumeroCarteira(associado.getNumeroCarteira());
		associadoJpa.setTipo(TipoPlano.EMPRESARIAL);
		associadoJpa.setTitular(associado.getTitular());
		return associadoJpa;
	}

	@Override
	public Associado findByCpf(String cpf) {
		AssociadoJpa associadoJpa = this.repository.findByCpfNumeroCpf(cpf);
		return buildAssociado(associadoJpa);
	}
}
