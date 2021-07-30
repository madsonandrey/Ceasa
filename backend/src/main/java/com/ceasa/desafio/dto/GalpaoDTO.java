package com.ceasa.desafio.dto;

import java.io.Serializable;

import com.ceasa.desafio.entities.Galpao;

public class GalpaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String sigla;
	private String descricao;
	private Double metragem;
	private Double valor_metro_quadrado;
	
	public GalpaoDTO () {
		
	}

	public GalpaoDTO(Long id, String sigla, String descricao, Double metragem, Double valor_metro_quadrado) {
		this.id = id;
		this.sigla = sigla;
		this.descricao = descricao;
		this.metragem = metragem;
		this.valor_metro_quadrado = valor_metro_quadrado;
	}
	
	public GalpaoDTO (Galpao entity) {
		this.id = entity.getId();
		this.sigla = entity.getSigla();
		this.descricao = entity.getDescricao();
		this.metragem = entity.getMetragem();
		this.valor_metro_quadrado = entity.getValor_metro_quadrado();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getMetragem() {
		return metragem;
	}

	public void setMetragem(Double metragem) {
		this.metragem = metragem;
	}

	public Double getValor_metro_quadrado() {
		return valor_metro_quadrado;
	}

	public void setValor_metro_quadrado(Double valor_metro_quadrado) {
		this.valor_metro_quadrado = valor_metro_quadrado;
	}
	
	

}
