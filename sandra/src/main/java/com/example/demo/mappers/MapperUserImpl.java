package com.example.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

@Component
public class MapperUserImpl implements MapperUser{
	

	@Autowired
	private DozerBeanMapper mapper=new DozerBeanMapper();

	@Override
	public User toModel(UserDTO dto) {
		return mapper.map(dto, User.class);
	}

	@Override
	public UserDTO toDTO(User model) {
		return mapper.map(model, UserDTO.class);
	}

	@Override
	public List<UserDTO> convertPageToListDTO(Page<User> models) {
		List<UserDTO> dtos=new ArrayList<>();
		models.forEach(m->dtos.add(mapper.map(m, UserDTO.class)));
		return dtos;
	}

	

}
