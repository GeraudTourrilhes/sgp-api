package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Banque;
import dev.entite.Collaborateur;
import dev.entite.Departement;
import dev.repository.BanqueRepository;
import dev.repository.CollaborateurRepository;
import dev.repository.DepartementRepository;

@RestController
@RequestMapping("api/initialisation")
public class InitialiseController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private BanqueRepository banqueRepository;

	@GetMapping
	public void initialisation() {
		departementRepository.save(new Departement("test"));
		departementRepository.save(new Departement("info"));
		banqueRepository.save(new Banque("B1", "IBAN1", "BIC1"));
		banqueRepository.save(new Banque("B2", "IBAN2", "BIC2"));
		collaborateurRepository
				.save(new Collaborateur("M01", departementRepository.getOne(1), banqueRepository.getOne(1)));
		collaborateurRepository
				.save(new Collaborateur("M02", departementRepository.getOne(1), banqueRepository.getOne(1)));
		collaborateurRepository
				.save(new Collaborateur("M03", departementRepository.getOne(2), banqueRepository.getOne(2)));
	}
}
