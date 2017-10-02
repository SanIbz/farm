package com.example.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CowDTO;
import com.example.demo.model.Cow;

@Component
public class MapperCowImpl implements MapperCow{
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public Cow toModel(CowDTO dto) {
		return mapper.map(dto, Cow.class);
	}

	@Override
	public CowDTO toDTO(Cow model) {
		return mapper.map(model, CowDTO.class);
	}

	@Override
	public List<CowDTO> convertPageToListDTO(Page<Cow> models) {
		List<CowDTO> dtos=new ArrayList<>();
		models.forEach(m->dtos.add(mapper.map(m, CowDTO.class)));
		return dtos;
	}

}
