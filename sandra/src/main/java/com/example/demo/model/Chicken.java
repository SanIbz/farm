package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name ="chicken")
@PrimaryKeyJoinColumn(name="idAnimal")
public class Chicken extends Animal {
	

}
