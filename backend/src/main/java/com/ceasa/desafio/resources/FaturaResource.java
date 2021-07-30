package com.ceasa.desafio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceasa.desafio.dto.FaturaDTO;
import com.ceasa.desafio.services.FaturaService;

@RestController
@RequestMapping(value = "/faturas")
public class FaturaResource {

	@Autowired
	private FaturaService service;
	
	@GetMapping(value = "/{id}/loja")
	public ResponseEntity <FaturaDTO> gerarFatura(@PathVariable Long id) {
		FaturaDTO dto = service.gerarFatura(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
}
