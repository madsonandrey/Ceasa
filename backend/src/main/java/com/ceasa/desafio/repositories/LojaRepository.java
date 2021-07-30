package com.ceasa.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceasa.desafio.entities.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

	
}
