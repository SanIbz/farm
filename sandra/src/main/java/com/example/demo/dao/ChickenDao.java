package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Chicken;

public interface ChickenDao extends PagingAndSortingRepository<Chicken, Integer>{

}
