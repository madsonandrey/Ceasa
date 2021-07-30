package com.ceasa.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceasa.desafio.dto.FaturaDTO;
import com.ceasa.desafio.entities.Fatura;
import com.ceasa.desafio.entities.Loja;
import com.ceasa.desafio.repositories.FaturaRepository;
import com.ceasa.desafio.repositories.LojaRepository;

@Service
public class FaturaService {

	@Autowired
	private FaturaRepository repository;
	@Autowired
	private LojaRepository lojaRepository;


	@Transactional
	public FaturaDTO gerarFatura(Long id) {
		Loja loja = lojaRepository.findById(id).get();
		Double totalFatura = loja.getMetragem() * loja.getGalpao().getValor_metro_quadrado();
		Fatura fatura = new Fatura(totalFatura, loja);
		fatura = repository.save(fatura);
		return new FaturaDTO(fatura);
	}

	
	

}
