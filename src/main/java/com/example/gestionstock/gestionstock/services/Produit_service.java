package com.example.gestionstock.gestionstock.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionstock.gestionstock.models.Produit;
import com.example.gestionstock.gestionstock.repositories.Produit_repository;

@Service
public class Produit_service {
	@Autowired
	private Produit_repository repository;
	public Produit saveProduit(Produit produit) {
		return repository.save(produit);
	}
	public List<Produit> saveProduits(List<Produit> Produits) {
        return repository.saveAll(Produits);
    }

    public List<Produit> getProduits() {
        return repository.findAll();
    }

    public Produit getProduitById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Produit getProduitByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduit(int id) {
        repository.deleteById(id);
        return "Produit removed !! " + id;
    }

    public Produit updateProduit(Produit Produit, int id) {
        Produit existingProduit = repository.findById(id).orElse(null);
        existingProduit.setName(Produit.getName());
        existingProduit.setQuantity(Produit.getQuantity());
        existingProduit.setPrice(Produit.getPrice());
        existingProduit.setDescription(Produit.getDescription());
        return repository.save(existingProduit);
    }
    


}
