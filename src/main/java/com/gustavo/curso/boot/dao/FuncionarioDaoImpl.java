package com.gustavo.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.gustavo.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
