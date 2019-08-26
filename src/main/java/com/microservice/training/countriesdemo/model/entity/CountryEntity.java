package com.microservice.training.countriesdemo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {

	@Id
	@GeneratedValue
	@Column(name = "country_id")
	Integer countryId;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "capital")
	String capital;
	
	@Column(name = "continent")
	String continent;
	
}
