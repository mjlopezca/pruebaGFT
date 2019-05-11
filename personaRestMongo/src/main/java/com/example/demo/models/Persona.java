package com.example.demo.models;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Persona {
  @Id
  public ObjectId _id;
  
  public String nombre;
  public String apellidos;
  public int edad;  
  public Date fechaNacimiento;
  
  
  
  public String get_id() { return _id.toHexString(); }
}