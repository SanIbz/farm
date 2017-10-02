package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Cow;

public interface CowDao extends PagingAndSortingRepository<Cow, Integer>{

}
