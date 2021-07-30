package com.ceasa.desafio.dto;

import java.io.Serializable;

import com.ceasa.desafio.entities.Fatura;


public class FaturaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private Double valor;
	private String nomeLoja;

	public FaturaDTO() {
		
	}

	public FaturaDTO(Long id, Double valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public FaturaDTO(Fatura fatura) {
		this.id = fatura.getId();
		this.valor = fatura.getValor();
		this.nomeLoja = fatura.getLoja().getNome();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaturaDTO other = (FaturaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
