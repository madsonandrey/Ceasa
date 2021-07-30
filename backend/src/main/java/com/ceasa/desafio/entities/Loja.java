package com.ceasa.desafio.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tb_loja")
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double metragem;

	@ManyToOne
	@JoinColumn(name = "galpao_id")
	private Galpao galpao;

	@OneToMany(mappedBy = "loja")
	private Set<Fatura> faturas = new HashSet<>();
	
	public Loja() {
		
	}

	public Loja(Long id, String nome, Double metragem) {
		this.id = id;
		this.nome = nome;
		this.metragem = metragem;
		
	}
	
	public Double metragemGalpao() {
		return galpao.getMetragem();
	}

	public Double metragemGalpaoRestante() {
		Double metragemRestante = galpao.getMetragem() - getMetragem();
		return metragemRestante;
	}
	
	public Galpao getGalpao() {
		return galpao;
	}

	public void setGalpao(Galpao galpao) {
		this.galpao = galpao;
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
	
	public Set<Fatura> getFaturas() {
		return faturas;
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
		Loja other = (Loja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
