package com.example.demo.controller;

import java.io.Serializable;

import org.springframework.data.domain.Page;

public interface CRUD<T, ID extends Serializable> {

	T create(T t);

	void delete(ID id) throws IllegalAccessException;

	T findById(ID id);
	
	Page<T> listAllByPage(Integer page, Integer size);

	void update(Integer id, T t);
	
	

}
