package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductionDTO {
	
	private Integer idProducer;
	private Date productionDate;
	private Date saleDate;
	private Double costPrice;
	private Double salePrice;
	

}
