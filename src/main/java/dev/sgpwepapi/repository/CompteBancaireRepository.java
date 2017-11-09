package dev.sgpwepapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwepapi.entite.CompteBancaire;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Integer> {
	
}
