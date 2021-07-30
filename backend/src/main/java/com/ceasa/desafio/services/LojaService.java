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

import com.ceasa.desafio.dto.LojaDTO;
import com.ceasa.desafio.entities.Loja;
import com.ceasa.desafio.repositories.LojaRepository;
import com.ceasa.desafio.services.exceptions.DatabaseException;
import com.ceasa.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class LojaService {

	@Autowired
	private LojaRepository repository;
	
	@Autowired
	private GalpoesService galpaoService;

	@Transactional(readOnly = true)
	public List<LojaDTO> findAll() {
		List<Loja> list = repository.findAll();

		return list.stream().map(x -> new LojaDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public LojaDTO findById(Long id) {
		Optional<Loja> obj = repository.findById(id);
		Loja entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new LojaDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public LojaDTO findByGalpaoId(Long galpaoId) {
		Optional<Loja> obj = repository.findById(galpaoId);
		Loja entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new LojaDTO(entity);
	}
	
	private void validateInsert(Long idGalpao, Loja entity) {
		if(entity.getMetragem() > galpaoService.getMetragemRestanteGalpao(idGalpao)) {
			throw new ResourceNotFoundException("Não é possivel cadastrar uma loja maior que a metragem restante do galpão");
		}
	}

	@Transactional
	public LojaDTO insert(LojaDTO dto) {
		Loja entity = new Loja();
		copyDtoToEntity(dto, entity);
		validateInsert(dto.getGalpao().getId(), entity);
		entity = repository.save(entity);
		return new LojaDTO(entity);
	}

	@Transactional
	public LojaDTO update(Long id, LojaDTO dto) {
		try {
			Loja entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new LojaDTO(entity);
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
			throw new DatabaseException("Violation of integrity");
		}

	}
	
	private void copyDtoToEntity(LojaDTO dto, Loja entity) {
		
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setMetragem(dto.getMetragem());
		entity.setGalpao(dto.getGalpao());
		
		}

}
