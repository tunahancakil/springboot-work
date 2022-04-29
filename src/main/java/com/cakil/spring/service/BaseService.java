package com.cakil.spring.service;

import com.cakil.spring.exceptions.DatabaseGeneralException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<E> {

	public Page<E> getAll(Pageable pageable) throws DatabaseGeneralException;

	public List<E> getAllById(List<Integer> idList) throws DatabaseGeneralException;

	public E getById(Class<E> clazz, Integer id) throws DatabaseGeneralException;

	public E save(E entity) throws DatabaseGeneralException;

	public void saveAll(List<E> entityList) throws DatabaseGeneralException;

	public void delete(E entity) throws DatabaseGeneralException;

	public void deleteById(Class<E> clazz, Integer id) throws DatabaseGeneralException;

	public void deleteAll(List<E> entityList) throws DatabaseGeneralException;

}
