package com.example.gestionstock.gestionstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionstock.gestionstock.models.Produit;

public interface Produit_repository extends JpaRepository<Produit,Integer> {
	Produit findByName(String name);
	

}
