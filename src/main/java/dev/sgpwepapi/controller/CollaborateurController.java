package dev.sgpwepapi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import dev.sgpwepapi.entite.Departement;
import dev.sgpwepapi.repository.CollaborateurRepository;
import dev.sgpwepapi.repository.CompteBancaireRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:9000")
@RequestMapping("/collaborateurs")
public class CollaborateurController {

	@Autowired CollaborateurRepository repoCollab;
	
	@Autowired CompteBancaireRepository repoCompte;
	
	@GetMapping
	public List<Collaborateur> getAllCollaborateurs(@RequestParam Optional<Departement> departement) {
		if (departement.isPresent()) {
			return repoCollab.findByDepartement(departement.get());
		} else {
			return repoCollab.findAll();
		}
	}
	
	@GetMapping(path = "/{matricule}")
	public Collaborateur getOneCollaborateurByMatricule(@PathVariable String matricule) {
		Optional <Collaborateur> collab = repoCollab.findByMatricule(matricule);
		
		if (collab.isPresent()) {
			return collab.get();
		} else {
			return null;
		}
	}
	
	@PostMapping
	public String saveCollaboteur(@RequestBody Collaborateur collab) {
		repoCollab.save(collab);
		return collab.getMatricule();
	}
	
	@Transactional
	@PutMapping(path = "/{matricule}")
	public String updateCollaboteur(@RequestBody Collaborateur collab, @PathVariable String matricule) {
		Optional<Collaborateur> updateCollab = repoCollab.findByMatricule(matricule);
		
		if (updateCollab.isPresent()) {
			collab.setId(updateCollab.get().getId());
			repoCollab.save(collab);
			
			return collab.getMatricule();
		}
		
		return null;
	}
	
	@GetMapping(path = "/{matricule}/banque")
	public CompteBancaire getCompteBancaireByMatriculeCollaborateur(@PathVariable String matricule) {
		return repoCollab.findByMatricule(matricule).get().getCompte();
	}
	
	@Transactional
	@PutMapping(path = "/{matricule}/banque")
	public String updateCompteBancaireByMatriculeCollaborateur(@RequestBody CompteBancaire compteBancaire, @PathVariable String matricule) {
		Optional<Collaborateur> updateCollab = repoCollab.findByMatricule(matricule);
		
		if (updateCollab.isPresent()) {
			compteBancaire.setId(updateCollab.get().getCompte().getId());
			
			repoCompte.save(compteBancaire);
			updateCollab.get().setCompte(compteBancaire);
			
			return updateCollab.get().getMatricule();
		}
		
		return null;
	}
	
}
