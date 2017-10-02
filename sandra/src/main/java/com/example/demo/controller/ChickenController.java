package com.example.demo.controller;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChickenDTO;
import com.example.demo.mappers.MapperChicken;
import com.example.demo.model.Chicken;
import com.example.demo.service.ChickenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/chicken")
public class ChickenController implements CRUD<ChickenDTO, Integer>{

	@Autowired
	public MapperChicken mapperC;
	
	@Autowired
	private ChickenService chickenService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ChickenDTO create(@RequestBody ChickenDTO t) {
		Chicken c=mapperC.toModel(t);
		return mapperC.toDTO(chickenService.create(c));
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ("id") Integer id) throws IllegalAccessException {
		//log.info("Vamos a borrar");
		
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable ("id") Integer id, @RequestBody ChickenDTO t) {
		//log.info("Vamos a actualizar");
		Chicken c=mapperC.toModel(t);
		chickenService.update(id, c);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ChickenDTO findById(@PathVariable("id") Integer id) {
		//log.info("Vamos a recuperar un usuario con id " + id);
		Chicken c= chickenService.findById(id);
		return  mapperC.toDTO(c);
	}
	
	
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Page<ChickenDTO> listAllByPage(@Size(min=0) @RequestParam(name="page",defaultValue="0", required=false) Integer page,
			@Size(min=0, max=10) @RequestParam(name="size",defaultValue="10", required=false) Integer size) {
		//log.info("Vamos a recuperar los usuarios");
		Page<Chicken> chickens=chickenService.listAllByPage(page,size);
		List<ChickenDTO> chickensDTO=mapperC.convertPageToListDTO(chickens);
		return new PageImpl<ChickenDTO>(chickensDTO, new PageRequest(page, size), chickens.getTotalElements());
	} 

}
