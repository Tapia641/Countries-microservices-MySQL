package com.microservice.training.countriesdemo.model.test;

import java.util.List;

import org.junit.Test;

import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.utils.AfricaContinentList;
import com.microservice.training.countriesdemo.model.utils.AsiaContinentList;
import com.microservice.training.countriesdemo.model.utils.EuropeContinentList;
import com.microservice.training.countriesdemo.model.utils.NorthAmericaContinentList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContinentListTest {

	private static final String INSERT_SQL = "INSERT INTO countries VALUES (null, \"{}\", \"{}\", \"{}\");";

	@Test
	public void generateMysqlScript() {

		List<Country> europeList = EuropeContinentList.getAllContinentCountries();
		for (Country c : europeList) {
			log.info(INSERT_SQL, c.getCountryName(), c.getCapitalName(), c.getContinent().getContinentName());
		}

		List<Country> africaList = AfricaContinentList.getAllContinentCountries();
		for (Country c : africaList) {
			log.info(INSERT_SQL, c.getCountryName(), c.getCapitalName(), c.getContinent().getContinentName());
		}

		List<Country> asiaList = AsiaContinentList.getAllContinentCountries();
		for (Country c : asiaList) {
			log.info(INSERT_SQL, c.getCountryName(), c.getCapitalName(), c.getContinent().getContinentName());
		}

		List<Country> northAmericaList = NorthAmericaContinentList.getAllContinentCountries();
		for (Country c : northAmericaList) {
			log.info(INSERT_SQL, c.getCountryName(), c.getCapitalName(), c.getContinent().getContinentName());
		}

	}

}
