package com.example.demo.mappers;

import java.util.List;

import org.springframework.data.domain.Page;

public interface Mappers<M, DTO> {
	
	M toModel(DTO dto);
	DTO toDTO(M model);
	List<DTO> convertPageToListDTO(Page<M> models);

}
