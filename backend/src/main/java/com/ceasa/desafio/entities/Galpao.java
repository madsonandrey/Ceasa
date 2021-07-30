package com.ceasa.desafio.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_galpao")
public class Galpao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sigla;
	private String descricao;
	private Double metragem;
	private Double valor_metro_quadrado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "galpao")		
	private Set<Loja> lojas = new HashSet<>();

	public Galpao() {
	}

	public Galpao(Long id, String sigla, String descricao, Double metragem, Double valor_metro_quadrado) {
		this.id = id;
		this.sigla = sigla;
		this.descricao = descricao;
		this.metragem = metragem;
		this.valor_metro_quadrado = valor_metro_quadrado;
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

	
	public Set<Loja> getLojas() {
		return lojas;
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
		Galpao other = (Galpao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
