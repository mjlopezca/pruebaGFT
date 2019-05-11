package com.example.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Persona;
import com.example.demo.repositories.PersonaRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	private PersonaRepository repository;
	@Value("${by.alias:MJLOPEZ}")
	String alias;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Persona> getAllPersona() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	public String getCreador() {
		return alias;
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Persona getPersonaById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Persona modificaPersonaById(@PathVariable("id") ObjectId id, @Valid @RequestBody Persona persona) {
		persona.set_id(id);
		repository.save(persona);
		return persona;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Persona creaPersona( @RequestBody Persona persona) {
		persona.set_id(ObjectId.get());
		repository.save(persona);
		return persona;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletePersona(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "delete";
	}

}