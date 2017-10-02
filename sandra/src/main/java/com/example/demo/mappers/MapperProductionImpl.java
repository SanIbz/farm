package com.example.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductionDTO;
import com.example.demo.model.Production;

@Component
public class MapperProductionImpl implements MapperProduction {

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public Production toModel(ProductionDTO dto) {
		return mapper.map(dto, Production.class);
	}

	@Override
	public ProductionDTO toDTO(Production model) {
		return mapper.map(model, ProductionDTO.class);
	}

	@Override
	public List<ProductionDTO> convertPageToListDTO(Page<Production> models) {
		List<ProductionDTO> dtos=new ArrayList<>();
		models.forEach(m->dtos.add(mapper.map(m, ProductionDTO.class)));
		return dtos;
	}

	
	
}
