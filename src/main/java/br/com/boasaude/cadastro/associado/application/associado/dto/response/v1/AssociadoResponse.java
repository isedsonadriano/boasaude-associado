package br.com.boasaude.cadastro.associado.application.associado.dto.response.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssociadoResponse {

	@ApiModelProperty(notes = "Id do associado", name = "id", required = true, value = "Teste Id")
	private Long id;
	
	@ApiModelProperty(notes = "Nome do associado",name="nome",required=true,value="Teste nome")
	private String nome;
	
	@ApiModelProperty(notes = "Cpf do associado",name="cpf",required=true,value="Teste Cpf")
	private String cpf;
	
	@ApiModelProperty(notes = "data de nascimento do associado",name="dataNascimento",required=true,value="Teste dataNascimento")
	private String dataNascimento;
	
	@ApiModelProperty(notes = "Rg do associado",name="rg",required=true,value="Teste Rg")
	private String rg;
	
	@ApiModelProperty(notes = "Nome da mãe do associado",name="rg",required=true,value="Teste nome da mãe")
	private String nomeDaMae;
	
	@ApiModelProperty(notes = "Telefone do associado",name="telefone",required=true,value="Teste telefone")
	private String telefone;
	
	@ApiModelProperty(notes = "Tipo do plano do associado",name="tipoPlano",required=true,value="Teste Tipo plano")
	private String tipoPlano;
	
	@ApiModelProperty(notes = "Número carteira do associado",name="numeroCarteira",required=true,value="Teste número carteira")
	private String numeroCarteira;
	
	@ApiModelProperty(notes = "boolean se associado é o titular",name="titular",required=true,value="Teste titular")
	private Boolean titular;

}
