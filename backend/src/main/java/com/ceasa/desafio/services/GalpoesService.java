package com.ceasa.desafio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceasa.desafio.dto.GalpaoDTO;
import com.ceasa.desafio.entities.Galpao;
import com.ceasa.desafio.repositories.GalpaoRepository;
import com.ceasa.desafio.services.exceptions.DatabaseException;
import com.ceasa.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class GalpoesService {

	@Autowired
	private GalpaoRepository repository;

	@Transactional(readOnly = true)
	public List<GalpaoDTO> findAll() {
		List<Galpao> list = repository.findAll();

		return list.stream().map(x -> new GalpaoDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public GalpaoDTO findById(Long id) {
		Optional<Galpao> obj = repository.findById(id);
		Galpao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new GalpaoDTO(entity);
	}
	

	@Transactional
	public GalpaoDTO insert(GalpaoDTO dto) {

		Galpao entity = new Galpao();
		entity.setSigla(dto.getSigla());
		entity = repository.save(entity);
		return new GalpaoDTO(entity);
	}

	@Transactional
	public GalpaoDTO update(Long id, GalpaoDTO dto) {
		try {
			Galpao entity = repository.getOne(id);
			entity.setSigla(dto.getSigla());
			entity = repository.save(entity);
			return new GalpaoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);

		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);

		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Você não pode deletar um galpão. Violação de integridade");
		}

	}

}
