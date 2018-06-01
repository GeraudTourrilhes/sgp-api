package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Collaborateur;
import dev.entite.Departement;
import dev.repository.CollaborateurRepository;
import dev.repository.DepartementRepository;

@RestController
@RequestMapping("api/initialisation")
public class InitialiseController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private DepartementRepository departementRepository;

	@GetMapping
	public void initialisation() {
		departementRepository.save(new Departement("test"));
		departementRepository.save(new Departement("info"));
		collaborateurRepository.save(new Collaborateur("M01", departementRepository.getOne(1)));
		collaborateurRepository.save(new Collaborateur("M02", departementRepository.getOne(1)));
		collaborateurRepository.save(new Collaborateur("M03", departementRepository.getOne(2)));
	}
}
