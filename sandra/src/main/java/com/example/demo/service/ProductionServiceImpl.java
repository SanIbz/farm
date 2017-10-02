package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductionDao;
import com.example.demo.model.Production;

@Service
public class ProductionServiceImpl implements ProductionService{

	@Autowired
	private ProductionDao dao;

	@Override
	public Production create(Production t) {
		return dao.save(t);
	}

	@Override
	public void delete(Integer id) {
		Production p=dao.findOne(id);
		dao.delete(p);
	}

	@Override
	public void update(Integer id, Production t) {
		final Production p=dao.findOne(id);
		if(t.getCostPrice()!=null) {
			p.setCostPrice(t.getCostPrice());			
		}
		if(t.getSalePrice()!=null) {
			p.setSalePrice(t.getSalePrice());			
		}
		if(t.getSaleDate()!=null) {
			p.setSaleDate(t.getSaleDate());			
		}
		dao.save(p);
	}

	@Override
	public Production findById(Integer id) {
		return dao.findOne(id);
	}
	

	@Override
	public Page<Production> listAllByPage(Integer page, Integer size) {
		PageRequest pageable=new PageRequest(page, size);
		return dao.findAll(pageable);
	}
}
