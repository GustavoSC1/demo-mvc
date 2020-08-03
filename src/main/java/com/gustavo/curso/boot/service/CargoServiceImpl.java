package com.gustavo.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavo.curso.boot.dao.CargoDao;
import com.gustavo.curso.boot.domain.Cargo;

@Service 
//Esse comportamento vai fazer com que não seja aberta uma transação quando o método de consulta 
//for executado, liberando assim, o acesso a tabela em questão para outras operações.
//https://helpdevs.net/2020/01/01/spring-transactional-annotation/
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {
	
	@Autowired
	private CargoDao dao;
	
	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);		
	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override	
	//Sobrescrevendo a anotação da classe
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}
	
}
