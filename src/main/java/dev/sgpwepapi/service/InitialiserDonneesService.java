package dev.sgpwepapi.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sgpwepapi.entite.Collaborateur;
import dev.sgpwepapi.entite.CompteBancaire;
import dev.sgpwepapi.entite.Departement;
import dev.sgpwepapi.repository.CollaborateurRepository;
import dev.sgpwepapi.repository.CompteBancaireRepository;

@Service
public class InitialiserDonneesService {
	
	@Autowired private CollaborateurRepository repoCollab;
	
	@Autowired private CompteBancaireRepository repoCompte;
	
	public void init() {
		Stream.of(new CompteBancaire("walou", "154", "1566446461345141"), new CompteBancaire("easy", "123", "534486154646476")).forEach(compte -> repoCompte.save(compte));
		Stream.of(new Collaborateur("Cavaillé", "Nicolas", "NC01", Departement.INFO, repoCompte.findOne(Integer.valueOf(1))),
				new Collaborateur("Calahou", "Florent", "FC01", Departement.RH, repoCompte.findOne(Integer.valueOf(2))))
				.forEach(collab -> repoCollab.save(collab));
	}
}
