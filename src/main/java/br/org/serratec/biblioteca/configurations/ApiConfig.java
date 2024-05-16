package br.org.serratec.biblioteca.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // adiciona configuraçoes em tempo de subida
public class ApiConfig {
	
	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
}
