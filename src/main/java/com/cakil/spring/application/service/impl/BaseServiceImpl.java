package com.cakil.spring.application.service.impl;

import com.cakil.spring.application.service.BaseService;
import com.cakil.spring.application.service.Loggable;
import com.cakil.spring.domain.AbstractBaseEntity;
import com.cakil.spring.domain.exceptions.DatabaseDataIntegrityException;
import com.cakil.spring.domain.exceptions.DatabaseEntityNotFoundException;
import com.cakil.spring.domain.exceptions.DatabaseGeneralException;
import com.cakil.spring.interfaces.repositories.BaseRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T extends BaseRepository<E>, E extends AbstractBaseEntity> implements BaseService<E>, Loggable {

	private final T repository;

	public BaseServiceImpl(T repository) {
		this.repository = repository;
	}

	public T getRepository() {
		return repository;
	}

	@Override
	public E getById(Class<E> clazz, Integer id) throws DatabaseGeneralException {
		try {
			Optional<E> optEntity = repository.findById(id);
			if (!optEntity.isPresent()) {
				throw new EntityNotFoundException("Id:" + id + " class:" + clazz + " is not found.");
			}
			E entity = optEntity.get();
			return entity;
		} catch (EntityNotFoundException dive) {
			getLogger().error(dive.getMessage());
			throw new DatabaseEntityNotFoundException(dive.getMessage());
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public Page<E> getAll(Pageable pageable) throws DatabaseGeneralException {
		try {
			return getRepository().findAll(pageable);
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public E save(E entity) throws DatabaseGeneralException {
		try {
			entity.setCreatedUpdatedDateProperties();
			entity = repository.save(entity);
			return entity;
		} catch (DataIntegrityViolationException dive) {
			getLogger().error(dive.getMessage());
			throw new DatabaseDataIntegrityException(dive.getMessage());
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public void saveAll(List<E> entityList) throws DatabaseGeneralException {
		try {
			entityList.stream().forEach(entity -> entity.setCreatedUpdatedDateProperties());
			repository.saveAll(entityList);
		} catch (DataIntegrityViolationException dive) {
			getLogger().error(dive.getMessage());
			throw new DatabaseDataIntegrityException(dive.getMessage());
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public void delete(E entity) throws DatabaseGeneralException {
		try {
			entity.setDeleted(true);
			save(entity);
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Class<E> clazz, Integer id) throws DatabaseGeneralException {
		try {
			Optional<E> optEntity = repository.findById(id);
			if (!optEntity.isPresent()) {
				throw new EntityNotFoundException("Id:" + id + " class:" + clazz + " is not found.");
			}
			E entity = optEntity.get();
			entity.setDeleted(true);
			save(entity);
		} catch (EntityNotFoundException dive) {
			getLogger().error(dive.getMessage());
			throw new DatabaseEntityNotFoundException(dive.getMessage());
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public void deleteAll(List<E> entityList) throws DatabaseGeneralException {
		try {
			entityList.stream().forEach(entity -> entity.setDeleted(true));
			saveAll(entityList);
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public List<E> getAllById(List<Integer> idList) throws DatabaseGeneralException {
		try {
			return getRepository().findAllById(idList);
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

}
