package com.microservice.training.countriesdemo.repository.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.training.countriesdemo.model.entity.CountryEntity;

@Repository
public interface CountryJpaRepository extends CrudRepository<CountryEntity, Integer>{

	
	
}
