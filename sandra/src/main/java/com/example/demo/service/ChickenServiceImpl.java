package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChickenDao;
import com.example.demo.model.Chicken;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
	private ChickenDao dao;

	@Override
	public Chicken create(Chicken t) {
		
		return dao.save(t);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void update(Integer id, Chicken t) {
		final Chicken c=dao.findOne(id);
		if(t.getIdOwner()!=null) {
			c.setIdOwner(t.getIdOwner());
		}
		if(t.getType()!=null) {
			c.setType(t.getType());
		}
		dao.save(c);
	}

	@Override
	public Chicken findById(Integer id) {
		return dao.findOne(id);
	}
	
	@Override 
	public Page<Chicken> listAllByPage(Integer page, Integer size){
		PageRequest pageable=new PageRequest(page, size);
		return dao.findAll(pageable);
	}

	
}
