package com.microservice.training.countriesdemo.service;

import com.microservice.training.countriesdemo.errorhandling.InvalidContinentException;
import com.microservice.training.countriesdemo.model.Continent;
import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.repository.api.ICountriesRepository;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountriesService implements ICountriesService {

  @Autowired
  ICountriesRepository countriesRepository;
  
  public List<Country> findCountriesByContinentName(String continentName) {
    Continent continent = Continent.continentByName(continentName);
    switch (continent) {
      case EUROPE:
        return countriesRepository.findAllEuropeCountries();
      case ASIA:
        return countriesRepository.findAllAsiaCountries();
      case AFRICA:
        return countriesRepository.findAllAfricaCountries();
      case NORTH_AMERICA:
        return countriesRepository.findAllNorthAmericaCountries();
      default:
        throw new InvalidContinentException("Continent: " + continentName + " does not exist.");
    }
  }
  
  public List<Country> findCountriesByContinentId(Integer continentId) {
    Continent continent = Continent.continentById(continentId);
    switch (continent) {
      case EUROPE:
        return countriesRepository.findAllEuropeCountries();
      case ASIA:
        return countriesRepository.findAllAsiaCountries();
      case AFRICA:
        return countriesRepository.findAllAfricaCountries();
      case NORTH_AMERICA:
        return countriesRepository.findAllNorthAmericaCountries();
      default:
        throw new InvalidContinentException("Continent id: " + continentId + " does not exist.");
    }
  }

}
