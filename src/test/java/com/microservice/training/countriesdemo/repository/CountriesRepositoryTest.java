
package com.microservice.training.countriesdemo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservice.training.countriesdemo.model.Continent;
import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.repository.api.CountryJpaRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CountriesRepositoryTest {

	@Autowired
	CountryJpaRepository mongoRepository;

	@Before
	public void setUp() {
		assertNotNull(mongoRepository);
	}

	@Test
	public void findById() {

		log.info("Testing Mysql JPA repository findById feature");

		Integer countryId = 169;
		Optional<CountryEntity> countryOpt = mongoRepository.findById(countryId);

		if (countryOpt.isPresent()) {
			CountryEntity country = countryOpt.get();

			//	DADA UNA ENTRADA COMPROBAR LA SALIDA
			assertThat(country.getContinent()).isEqualToIgnoringCase(Continent.NORTH_AMERICA.getContinentName());
			assertThat(country.getName()).isEqualToIgnoringCase("mexico");

			log.info("Country found: {}", country);
		} else {
			log.error("COUNTRY WAS NOT FOUND FOR ID: {}", countryId);
		}

	}

}
