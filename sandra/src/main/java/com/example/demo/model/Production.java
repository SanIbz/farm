package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Data;

@Data
@Entity
@Table(name ="production")
public class Production {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProduction;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date productionDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date saleDate;
		
	@Column(nullable=false)
	private Double costPrice;
	
	private Double salePrice;
	
	@Column(nullable=false)
	private Integer idProducer;
	
	
	
}