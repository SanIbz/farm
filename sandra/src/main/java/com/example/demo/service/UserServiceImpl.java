package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	


	@Override
	public User create(User t) {
		return dao.save(t);
	}

	@Override
	public void delete(Integer id) {
		User t=dao.findOne(id);
		dao.delete(t);
	}

	@Override
	public User findById(Integer id) {
		return dao.findOne(id);
	}
	
	@Override
	public Page<User> listAllByPage(Integer page, Integer size) {
		PageRequest pageable=new PageRequest(page, size);
		return dao.findAll(pageable);
	}


	@Override
	public void update(Integer id, User t) {
		final User u=dao.findOne(id);
		u.setPhone(t.getPhone());
		dao.save(u);
		
	}

	
	
}
