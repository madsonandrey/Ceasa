package com.ceasa.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceasa.desafio.entities.Galpao;

@Repository
public interface GalpaoRepository extends JpaRepository<Galpao, Long> {

}
