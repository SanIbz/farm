package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Animal;

@Repository
public interface AnimalDao extends PagingAndSortingRepository<Animal, Integer>{

}
