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

import com.example.demo.dto.UserDTO;
import com.example.demo.mappers.MapperUser;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController implements CRUD<UserDTO, Integer> {
	
	@Autowired
	MapperUser mapperU;
	
	
	@Autowired
	private UserService userService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO t) {
		log.info("Intentando crear un usuario");
		User u=mapperU.toModel(t);
		return mapperU.toDTO(userService.create(u));
	}
	
	@RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
	public void delete(@PathVariable (name="idUser") Integer id) throws IllegalAccessException {
		log.info("Vamos a borrar");
		userService.delete(id);
	}
	
	
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable ("id") Integer id, @RequestBody UserDTO t) {
		log.info("Vamos a actualizar");
		
		User u=mapperU.toModel(t);
		userService.update(id, u);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un usuario con id " + id);
		User u= userService.findById(id);
		return  mapperU.toDTO(u);
	}

	
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Page<UserDTO> listAllByPage(@Size(min=0) @RequestParam(name="page",defaultValue="0", required=false) Integer page,
			@Size(min=0, max=10) @RequestParam(name="size",defaultValue="10", required=false) Integer size){
		log.info("Vamos a recuperar los usuarios");
		Page<User> users=userService.listAllByPage(page,size);
		List<UserDTO> usersDTO=mapperU.convertPageToListDTO(users);
		return new PageImpl<UserDTO>(usersDTO, new PageRequest(page, size), users.getTotalElements());
	}


}
