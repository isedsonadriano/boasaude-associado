package br.com.boasaude.cadastro.associado.infra.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.module.jdk8.Jdk8Module;
import org.modelmapper.module.jsr310.Jsr310Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.boasaude.cadastro.associado.application.associado.dto.request.v1.AssociadoRequest;
import br.com.boasaude.cadastro.associado.core.domain.entity.Associado;

@Configuration
public class ModelMapperConfiguration {

	@Bean
    public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		buildAssociadoDtoToAssociado(modelMapper);
		buildAssociadotoAssociadoDTO(modelMapper);
		//buildDatas(modelMapper);
        return modelMapper;
    }

	private void buildAssociadotoAssociadoDTO(ModelMapper modelMapper) {
		modelMapper.addMappings(new PropertyMap<Associado, AssociadoRequest>() {
		    protected void configure() {
		        map().setCpf(source.getCpf().getNumeroCpf());
		        //map().setRg(new Rg(source.getRg()));
		        //map().setTelefone(new TelefoneVO(source.getTelefone()));
		       // LocalDateTime dataNascimento = UtilData.converterStringParaLocalDateTime(source.getDataNascimento());
		        //if(Objects.nonNull(dataNascimento)) {
		        ///	map().setDataNascimento(dataNascimento);
		       // }
		       // map().setTipoPlano(TipoPlano.fromValue(source.getTipoPlano()));
		    }
		});	
	}

	private void buildAssociadoDtoToAssociado(ModelMapper modelMapper) {
		modelMapper.addMappings(new PropertyMap<AssociadoRequest, Associado>() {
		    protected void configure() {
		        //map().setCpf(new Cpf(source.getCpf()));
		        //map().setRg(new Rg(source.getRg()));
		        //map().setTelefone(new TelefoneVO(source.getTelefone()));
		       // LocalDateTime dataNascimento = UtilData.converterStringParaLocalDateTime(source.getDataNascimento());
		        //if(Objects.nonNull(dataNascimento)) {
		        ///	map().setDataNascimento(dataNascimento);
		       // }
		       // map().setTipoPlano(TipoPlano.fromValue(source.getTipoPlano()));
		    }
		});			
	}

	private void buildDatas(ModelMapper modelMapper) {
		modelMapper.registerModule(new Jsr310Module());
		modelMapper.registerModule(new Jdk8Module());
	}

}
