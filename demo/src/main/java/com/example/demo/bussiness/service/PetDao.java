package com.example.demo.bussiness.service;

import java.util.List;

import com.example.demo.bussiness.domain.Pet;

public interface PetDao {
	Pet findById(int petId);
	List<Pet> findAll();
}