package com.microservice.training.countriesdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.training.countriesdemo.model.Continent;
import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.repository.api.CountryJpaRepository;
import com.microservice.training.countriesdemo.service.api.ICountriesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CountriesController {

//  @Autowired
//  ICountriesService countriesService;

  // Bean llamando a CountryRepository para poder usar sus funciones
  @Autowired
  CountryJpaRepository countryRepository;
  
  @GetMapping(path="/api/countries/all")
  public @ResponseBody Iterable<CountryEntity> getAllCountries() {
		return countryRepository.findAll();
	}
  
  @GetMapping(path = "/api/countries/continent/name/{continentName}")
  public @ResponseBody List<CountryEntity> findCountryByContinent(@PathVariable String continentName) {
	  List<CountryEntity> countriesList = (List<CountryEntity>) countryRepository.findAll(), auxList = new ArrayList<CountryEntity>();
	  for (CountryEntity country : countriesList) {
		if (country.getContinent().equals(continentName.toLowerCase())) {
			auxList.add(country);
		}
	  }
	  return auxList;
  }
  
  @GetMapping(path = "/api/countries/continent/id/{continentId}")
  public @ResponseBody Optional<CountryEntity> findCountryByContinent(@PathVariable Integer continentId) {
    return countryRepository.findById(continentId);
  }
    
  @RequestMapping(value="/api/countries/addCountry", method= {RequestMethod.GET,RequestMethod.POST})
  public String addCountry(
		// @RequestParam Puede ser GET o POST request
		@RequestParam ("name") String name,
		@RequestParam ("capital") String capital,
		@RequestParam ("continent") String continent)
  {
	  CountryEntity C = new CountryEntity();
	  C.setName(name);
	  C.setCapital(capital);
	  C.setContinent(continent);
	  
	  countryRepository.save(C);
	  
	  return "Agregado a la base de datos, ¡Eres un Crack!";
	  
  }

}
