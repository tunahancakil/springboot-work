package com.cakil.spring.application.service;

import com.cakil.spring.domain.exceptions.DatabaseGeneralException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<E> {

	Page<E> getAll(Pageable pageable) throws DatabaseGeneralException;

	List<E> getAllById(List<Integer> idList) throws DatabaseGeneralException;

	E getById(Class<E> clazz, Integer id) throws DatabaseGeneralException;

	E save(E entity) throws DatabaseGeneralException;

	void saveAll(List<E> entityList) throws DatabaseGeneralException;

	void delete(E entity) throws DatabaseGeneralException;

	void deleteById(Class<E> clazz, Integer id) throws DatabaseGeneralException;

	void deleteAll(List<E> entityList) throws DatabaseGeneralException;

}
