package com.ceasa.desafio.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.ceasa.desafio.entities.Galpao;
import com.ceasa.desafio.entities.Loja;

public class LojaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 5, max = 60, message = "Nome precisa ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	@Positive(message = "A metragem deve ser um valor positivo")
	private Double metragem;
	
	private Galpao galpao;
	
	private List<FaturaDTO> faturasDTO;
	
	public LojaDTO() {
		
	}

	public LojaDTO(Long id, String nome, Double metragem) {
		this.id = id;
		this.nome = nome;
		this.metragem = metragem;
		
	}
	
	public LojaDTO(Loja entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.metragem = entity.getMetragem();
		this.galpao = entity.getGalpao();
		this.faturasDTO = entity.getFaturas().stream().map(x -> new FaturaDTO(x)).collect(Collectors.toList());
				
	}

	public Galpao getGalpao() {
		return galpao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getMetragem() {
		return metragem;
	}

	public void setMetragem(Double metragem) {
		this.metragem = metragem;
	}


	public List<FaturaDTO> getFaturasDTO() {
		return faturasDTO;
	}
	
	

	
}
