package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Collaborateur;
import dev.repository.CollaborateurRepository;
import dev.repository.DepartementRepository;

@RestController
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

	@PutMapping
	public Collaborateur modifierCollaborateursByMatricule(@PathVariable("matricule") String matricule) {

		return this.collaborateurRepository.save(this.collaborateurRepository.findByMatricule(matricule));
	}
	/*
	 *
	 * GET /api/collaborateurs/[MATRICULE]/banque : récupère les coordonnées
	 * bancaires d'un collaborateur (nom de la banque, iban et bic) PUT
	 * /api/collaborateurs/[MATRICULE]/banque : mo
	 */
}
