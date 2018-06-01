package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, String> {
	public List<Collaborateur> findByDepartementId(int idDepartement);

	public Collaborateur findByMatricule(String matricule);

}
