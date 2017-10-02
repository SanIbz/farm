package com.example.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ChickenDTO;
import com.example.demo.model.Chicken;

@Component
public class MapperChickenImpl implements MapperChicken{
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public Chicken toModel(ChickenDTO dto) {
		return mapper.map(dto, Chicken.class);
	}

	@Override
	public ChickenDTO toDTO(Chicken model) {
		return mapper.map(model, ChickenDTO.class);
	}

	@Override
	public List<ChickenDTO> convertPageToListDTO(Page<Chicken> models) {
		List<ChickenDTO> dtos=new ArrayList<>();
		models.forEach(m->dtos.add(mapper.map(m, ChickenDTO.class)));
		return dtos;
	}

	
}
