package com.zuul.server.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zuul.server.feign.PersonaClientFeign;
import com.zuul.server.request.PersonaRequest;
import com.zuul.server.response.PersonaResponse;

@RestController
public class personaFeignController {
	@Value("${uri.persona.rest:http://localhost:8080/persona-rest}")
	String uriPersona;
	
	@Autowired 
	PersonaClientFeign personaClientFeign;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String creado() {
		return "Creado por "+personaClientFeign.getBy();
	}
	@RequestMapping(value="/endpoint/persona",method=RequestMethod.GET)
	public String persona() {
		return "Endpoint persona "+uriPersona;
	}
	@RequestMapping(value="/persona",method=RequestMethod.GET)
	public Collection<PersonaResponse> getAllPersona() {
		return personaClientFeign.getListPersona();
	}
	@PostMapping("/persona")
	public PersonaResponse creaPersona(@Valid @RequestBody PersonaRequest persona) {
		return personaClientFeign.creaPersona(persona);
	}
	@GetMapping("/persona/{id}")
	public PersonaResponse getPersona(@PathVariable("id") ObjectId id) {
		return personaClientFeign.getPersona(id);
	}
	
	@PutMapping("/persona/{id}")
	public PersonaResponse actualizaPersona(@PathVariable("id") ObjectId id, @Valid @RequestBody PersonaResponse persona) {
		return personaClientFeign.actualizarPersona(id, persona);
	}
	@DeleteMapping("/persona/{id}")
	public String borrarPersona(@PathVariable("id") ObjectId id) {
		return personaClientFeign.borrarPersona(id);
	}
	
}
