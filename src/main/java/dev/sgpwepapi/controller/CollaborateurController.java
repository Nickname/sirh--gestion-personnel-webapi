package dev.sgpwepapi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwepapi.entite.Collaborateur;
import dev.sgpwepapi.entite.CompteBancaire;
import dev.sgpwepapi.repository.CollaborateurRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateurController {

	@Autowired CollaborateurRepository repoCollab;
	
	@GetMapping
	public List<Collaborateur> getAllCollaborateurs(@RequestParam Optional<String> departement) {
		if (departement.isPresent()) {
			return repoCollab.findByDepartement(departement.get());
		} else {
			return repoCollab.findAll();
		}
	}
	
	@GetMapping(path = "/{matricule}")
	public Collaborateur getOneCollaborateurByMatricule(@PathVariable String matricule) {
		return repoCollab.findByMatricule(matricule);
	}
	
	@PostMapping
	public String saveCollaboteur(@RequestBody Collaborateur collab) {
		repoCollab.save(collab);
		return collab.getMatricule();
	}
	
	@Transactional
	@PutMapping(path = "/{matricule}")
	public String updateCollaboteur(@RequestBody Collaborateur collab, @PathVariable String matricule) {
		Collaborateur updateCollab = repoCollab.findByMatricule(matricule);
		
		if (repoCollab.exists(updateCollab.getId())) {
			collab.setId(updateCollab.getId());
			repoCollab.save(collab);
			
			return collab.getMatricule();
		}
		
		return null;
	}
	
	@GetMapping(path = "/{matricule}/banque")
	public CompteBancaire getCompteBancaireByMatriculeCollaborateur(String matricule) {
		return repoCollab.findByMatricule(matricule).getCompte();
	}
	
	@Transactional
	@PutMapping(path = "/{matricule}/banque")
	public String updateCompteBancaireByMatriculeCollaborateur(@RequestBody CompteBancaire compteBancaire, @PathVariable String matricule) {
		Collaborateur updateCollab = repoCollab.findByMatricule(matricule);
		
		if (repoCollab.exists(updateCollab.getId())) {
			updateCollab.setCompte(compteBancaire);
			repoCollab.save(updateCollab);
			
			return updateCollab.getMatricule();
		}
		
		return null;
	}
	
}
