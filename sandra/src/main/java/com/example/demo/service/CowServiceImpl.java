package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.example.demo.dao.CowDao;
import com.example.demo.model.Cow;

@Service
public class CowServiceImpl implements CowService {
	@Autowired
	private CowDao dao;
	
	@Override
	public Cow create(Cow t) {
		
		return dao.save(t);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void update(Integer id, Cow t) {
		final Cow c=dao.findOne(id);
		if(t.getIdOwner()!=null) {
			c.setIdOwner(t.getIdOwner());
		}
		if(t.getType()!=null) {
			c.setType(t.getType());
		}
		dao.save(c);
	}

	@Override
	public Cow findById(Integer id) {
		return (Cow) dao.findOne(id);
	}
	
	@Override 
	public Page<Cow> listAllByPage(Integer page, Integer size){
		PageRequest pageable=new PageRequest(page, size);
		return dao.findAll(pageable);
		
	}

}
