package com.gustavo.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.gustavo.curso.boot.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}
