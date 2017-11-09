package dev.sgpwepapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwepapi.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	Collaborateur findByMatricule(String matricule);
	
	List<Collaborateur> findByDepartement(String departement);
}
