package com.ceasa.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceasa.desafio.entities.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {

}
