package com.example.demo.repositories;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.models.Persona;

public interface PersonaRepository extends MongoRepository<Persona, String> {
  Persona findBy_id(ObjectId _id);
}