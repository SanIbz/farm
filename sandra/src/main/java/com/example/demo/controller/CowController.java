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

import com.example.demo.dto.CowDTO;
import com.example.demo.mappers.MapperCow;
import com.example.demo.model.Cow;
import com.example.demo.service.CowService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/cow")
public class CowController implements CRUD<CowDTO, Integer>{
	
	@Autowired
	public MapperCow mapperCow;
	
	@Autowired
	private CowService cowService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public CowDTO create(@RequestBody CowDTO t) {
		Cow c=mapperCow.toModel(t);
		return mapperCow.toDTO(cowService.create(c));
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ("id") Integer id) throws IllegalAccessException {
		
		
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable ("id") Integer id, @RequestBody CowDTO t) {
		//log.info("Vamos a actualizar");
		Cow c=mapperCow.toModel(t);
		cowService.update(id, c);
	}
/*
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public List<Production> getAll() {
		//log.info("Vamos a recuperar todos");
		return productionService.getAll();
	}*/

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CowDTO findById(@PathVariable("id") Integer id) {
		//log.info("Vamos a recuperar un usuario con id " + id);
		Cow c= cowService.findById(id);
		return  mapperCow.toDTO(c);
	}
	

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Page<CowDTO> listAllByPage(@Size(min=0) @RequestParam(name="page",defaultValue="0", required=false) Integer page,
			@Size(min=0, max=10) @RequestParam(name="size",defaultValue="10", required=false) Integer size){
		log.info("Vamos a recuperar los usuarios");
		Page<Cow> cows=cowService.listAllByPage(page,size);
		List<CowDTO> cowsDTO=mapperCow.convertPageToListDTO(cows);
		return new PageImpl<CowDTO>(cowsDTO, new PageRequest(page, size), cows.getTotalElements());
	} 
	

}
