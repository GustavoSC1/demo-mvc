package com.gustavo.curso.boot.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gustavo.curso.boot.domain.Departamento;
import com.gustavo.curso.boot.service.DepartamentoService;

@Component
//O Spring Boot já está pré configurado para interceptar requisições que tenham ligação 
//com a interface Converter. 
//Veja que declaramos <String, Departamento>. Quando houver no formulário um campo referente ao
//departamento (th:field="*{departamento}") e esse campo envia uma String ele vai saber que precisa 
//converter e captura a requisição antes dela chegar no controller. Então, faz a conversão e libera a 
//conversão para que ela vá para o controller.
public class StringToDepartamentoConverter implements Converter<String, Departamento> {
	
	@Autowired
	private DepartamentoService service;

	@Override
	public Departamento convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);		
	}

}
