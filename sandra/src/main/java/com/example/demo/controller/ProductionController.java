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

import com.example.demo.dto.ProductionDTO;
import com.example.demo.mappers.MapperProduction;
import com.example.demo.model.Production;
import com.example.demo.service.ProductionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/production")
public class ProductionController implements CRUD<ProductionDTO, Integer>{
	
	@Autowired
	MapperProduction mapperP;

	@Autowired
	private ProductionService productionService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ProductionDTO create(@RequestBody ProductionDTO t) {
		Production p=mapperP.toModel(t);
		return mapperP.toDTO(productionService.create(p));
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) throws IllegalAccessException {
		
		productionService.delete(id);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody ProductionDTO t) {
		Production p=mapperP.toModel(t);
		productionService.update(id, p);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductionDTO findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un usuario con id " + id);
		Production p= productionService.findById(id);
		return  mapperP.toDTO(p);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Page<ProductionDTO> listAllByPage(@Size(min=0) @RequestParam(name="page",defaultValue="0", required=false) Integer page,
			@Size(min=0, max=10) @RequestParam(name="size",defaultValue="10", required=false) Integer size){
		log.info("Vamos a recuperar los usuarios");
		Page<Production> productions=productionService.listAllByPage(page,size);
		List<ProductionDTO> productionsDTO=mapperP.convertPageToListDTO(productions);
		return new PageImpl<ProductionDTO>(productionsDTO, new PageRequest(page, size), productions.getTotalElements());
	}
}










