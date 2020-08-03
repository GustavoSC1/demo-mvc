package com.gustavo.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.gustavo.curso.boot.domain.Cargo;

//Outra característica da implementação do padrão DAO é criar uma interface para cada classe concreta de 
//DAO. Assim, poderemos injetar via Spring, as interfaces e não as classes concretas, respeitando os 
//princípios da injeção de dependências.
@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}
