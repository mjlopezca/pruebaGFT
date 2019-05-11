package com.zuul.server.feign;

import java.util.Collection;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.zuul.server.request.PersonaRequest;
import com.zuul.server.response.PersonaResponse;

@FeignClient("persona-rest") 
public interface PersonaClientFeign {
	
	 @GetMapping(value = "/persona/1")
	 String getBy();
	 
	 @GetMapping(value = "/persona/")
	 Collection<PersonaResponse> getListPersona();
	
	 @GetMapping(value = "/persona/{id}")
	 PersonaResponse getPersona(@PathVariable("id") ObjectId id);
	 
	 
	 @PostMapping(value = "/persona/")
	 PersonaResponse creaPersona(PersonaRequest persona);
	 
	 @DeleteMapping(value = "/persona/{id}")
	 String borrarPersona(@PathVariable("id") ObjectId id);
	 
	 @PutMapping(value = "/persona/{id}")	 
	 PersonaResponse actualizarPersona(@PathVariable("id") ObjectId id,PersonaResponse persona);
}
