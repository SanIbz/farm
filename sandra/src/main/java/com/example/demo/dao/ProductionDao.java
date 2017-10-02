package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Production;

@Repository
public interface ProductionDao extends PagingAndSortingRepository<Production, Integer>{

}
