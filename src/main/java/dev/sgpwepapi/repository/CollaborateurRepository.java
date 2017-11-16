package dev.sgpwepapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwepapi.entite.Collaborateur;
import dev.sgpwepapi.entite.Departement;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	Optional<Collaborateur> findByMatricule(String matricule);
	
	List<Collaborateur> findByDepartement(Departement departement);
}
