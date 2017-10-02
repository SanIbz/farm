package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class  Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAnimal;
	
	private String type; 

	private Integer idOwner;
	
	@Column(nullable=true)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idProducer")
	private List<Production> production;
	
	
	
	
	
}
