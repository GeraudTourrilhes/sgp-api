package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Departement;
import dev.repository.DepartementRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/departements")
public class DepartementController {

	@Autowired
	private DepartementRepository departementRepository;

	@GetMapping
	public List<Departement> listerDepartements() {
		return this.departementRepository.findAll();
	}

}
