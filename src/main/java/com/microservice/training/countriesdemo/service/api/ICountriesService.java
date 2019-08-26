package com.microservice.training.countriesdemo.service.api;

import com.microservice.training.countriesdemo.model.Country;
import java.util.List;

public interface ICountriesService {

  List<Country> findCountriesByContinentName(String continentName);
  
  List<Country> findCountriesByContinentId(Integer continentId);
  
}
