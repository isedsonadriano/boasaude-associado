package br.com.boasaude.cadastro.associado.application.associado.controller.v1;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.boasaude.cadastro.associado.application.associado.dto.request.v1.AssociadoRequest;
import br.com.boasaude.cadastro.associado.application.associado.dto.response.v1.AssociadoResponse;
import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;
import br.com.boasaude.cadastro.associado.core.service.AssociadoService;
import br.com.boasaude.cadastro.associado.core.util.Paginador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("v1/associados")
@Api(tags = "/v1/associados", value = "API's para manipular associados", authorizations = {@Authorization(value="jwtToken")})
@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Retorno para a inclusão de associado"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Erro de autorização"),
		@ApiResponse(code = 404, message = "Recurso não encontrado")}
)
@CrossOrigin(origins = "*", maxAge = 3600L)
public class AssociadoController  {

	@Autowired
	private AssociadoService service;
	
	@Autowired
	protected ModelMapper modelMapper;

	
	@ApiOperation(value = "API para salvar um associado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AssociadoResponse> salvar(@RequestBody @Valid AssociadoRequest associadoRequest, UriComponentsBuilder uriBuilder) {
		Associado associado = buildAssociado(associadoRequest);
		associado.setDataNascimento(LocalDateTime.now());
		this.service.salvar(associado);
		URI uri = uriBuilder.path("{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(buildAssociadoResponse(associado));
	}
	
	@ApiOperation(value = "API para listar associados", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping
	@ResponseBody
	public List<AssociadoResponse> listar(@PageableDefault(sort="id", direction = Direction.DESC) Pageable pageable) {
		 List<Associado> associados = service.capturarTodos(new Paginador(pageable.getOffset(), pageable.getPageNumber(), pageable.getPageSize(), false, false));
		return associados.stream().map(this::buildAssociadoResponse).collect(Collectors.toList());
	}

	@ApiOperation(value = "API para capturar associado por id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<AssociadoResponse> catpurar(@PathVariable Long id) {
		Associado associado = service.capturarPorId(id);
		if (Objects.nonNull(associado)) {
			AssociadoResponse response = buildAssociadoResponse(associado);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "API para atualizar o associado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<AssociadoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AssociadoRequest associadoRequest, UriComponentsBuilder uriBuilder) {
		Associado associado = buildAssociado(associadoRequest);
		associado.setId(id);
		this.service.atualizar(associado);
		return ResponseEntity.ok(buildAssociadoResponse(associado));
	}

	@ApiOperation(value = "API para deletar um associado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<AssociadoResponse> deletar(@PathVariable Long id) {
		this.service.deletar(id);
		return ResponseEntity.ok().build();
	}

	private AssociadoResponse buildAssociadoResponse(Associado associado) {
		return modelMapper.map(associado, AssociadoResponse.class);
	}
	
	private Associado buildAssociado(AssociadoRequest associadoRequest) {
		return modelMapper.map(associadoRequest, Associado.class);
	}

}
