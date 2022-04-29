package com.cakil.spring.interfaces.repositories;

import com.cakil.spring.domain.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends AbstractBaseEntity> extends JpaRepository<T, Integer> {

}
