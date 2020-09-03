package com.gustavo.curso.boot.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
//Classe criada para impedir lebras sejam passadas no campo número
public class StringToInteger implements Converter<String, Integer> {

	@Override
	public Integer convert(String text) {
		
		//Remove espaços em branco no final na string
		text = text.trim();
		
		//Utiliza expressões regulares para verificar se a string contem apenas números
		if(text.matches("[0-9]+")) {
			return Integer.valueOf(text);
		}
				
		return null;
	}

}
