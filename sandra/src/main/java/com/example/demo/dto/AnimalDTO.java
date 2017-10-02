package com.example.demo.dto;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public abstract class AnimalDTO {
	
	public Integer idOwner;
	
	public Integer idAnimal;
	
	public List<String> production;
	
	public String type;
	
	
}
