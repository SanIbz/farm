package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUser;
	
	@Column(unique=true, nullable=false)
	private String userName;
	
	private Integer phone;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idOwner")
	private List<Animal> animals;
}




















