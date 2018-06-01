package dev.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.entite.Banque;
import dev.entite.Collaborateur;
import dev.entite.Departement;
import dev.repository.CollaborateurRepository;
import dev.repository.DepartementRepository;

@Component
public class Listener {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private DepartementRepository departementRepository;

	@EventListener(ContextRefreshedEvent.class)
	public void handleContextStarted() {
		if (collaborateurRepository.findAll().size() == 0) {
			departementRepository.save(new Departement("Comptabilité"));
			departementRepository.save(new Departement("Ressources Humaines"));
			departementRepository.save(new Departement("Informatique"));
			Banque banque1 = new Banque("B1", "IBAN1", "BIC1");
			Banque banque2 = new Banque("B2", "IBAN2", "BIC2");
			collaborateurRepository
					.save(new Collaborateur("M01", "Nom1", "Prenom1", departementRepository.getOne(1), banque1));
			collaborateurRepository
					.save(new Collaborateur("M02", "Nom2", "Prenom2", departementRepository.getOne(1), banque1));
			collaborateurRepository
					.save(new Collaborateur("M03", "Nom3", "Prenom3", departementRepository.getOne(2), banque2));

		}
	}
}
