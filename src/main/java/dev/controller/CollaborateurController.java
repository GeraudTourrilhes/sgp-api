package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Banque;
import dev.entite.Collaborateur;
import dev.repository.CollaborateurRepository;
import dev.repository.DepartementRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private DepartementRepository departementRepository;

	@GetMapping
	public List<Collaborateur> listerCollaborateurs() {
		return this.collaborateurRepository.findAll();
	}

	@GetMapping("/{matricule}")
	public Collaborateur listerCollaborateursByMatricule(@PathVariable("matricule") String matricule) {

		return this.collaborateurRepository.findByMatricule(matricule);
	}

	@GetMapping(params = "departement")
	public List<Collaborateur> listerCollaborateursByDepartement(@RequestParam("departement") int idDepartement) {

		return this.collaborateurRepository.findByDepartementId(idDepartement);
	}

	@PutMapping("/{matricule}")
	public void modifierCollaborateursByMatricule(@PathVariable("matricule") String matricule,
			@RequestBody Collaborateur collaborateur) {
		collaborateur.setMatricule(matricule);
		this.collaborateurRepository.save(collaborateur);
	}

	@GetMapping("/{matricule}/banque")
	public Banque listerBanqueCollaborateursByMatricule(@PathVariable("matricule") String matricule) {

		return this.collaborateurRepository.findByMatricule(matricule).getBanque();
	}

	@PutMapping("/{matricule}/banque")
	public void modifierBanqueCollaborateursByMatricule(@PathVariable("matricule") String matricule,
			@RequestBody Banque banque) {
		Collaborateur collaborateur = collaborateurRepository.findByMatricule(matricule);
		collaborateur.setBanque(banque);
		this.collaborateurRepository.save(collaborateur);
	}
}
