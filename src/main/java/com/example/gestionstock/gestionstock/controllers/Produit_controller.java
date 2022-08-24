package com.example.gestionstock.gestionstock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionstock.gestionstock.models.Produit;
import com.example.gestionstock.gestionstock.services.Produit_service;

@RestController
public class Produit_controller {
	@Autowired
	private Produit_service service;
	@CrossOrigin("*") 
	@PostMapping("/addproduit")
	public Produit addProduit(@RequestBody Produit produit) {
		return service.saveProduit(produit);

	}

	@PostMapping("/addProduits")
	public List<Produit> addProduits(@RequestBody List<Produit> Produits) {
		return service.saveProduits(Produits);
	}

	@GetMapping("/allproduits")
	public List<Produit> findAllProduits() {
		return service.getProduits();
	}

	@GetMapping("/ProduitById/{id}")
	public Produit findProduitById(@PathVariable int id) {
		return service.getProduitById(id);
	}

	@GetMapping("/Produit/{name}")
	public Produit findProduitByName(@PathVariable String name) {
		return service.getProduitByName(name);
	}

	@PutMapping("/update/{id}")
	public Produit updateProduit(@PathVariable int id,@RequestBody Produit Produit) {
		return service.updateProduit(Produit, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduit(@PathVariable int id) {
		return service.deleteProduit(id);
	}

}
