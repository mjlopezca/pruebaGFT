package com.zuul.server.request;
import java.util.Date;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class PersonaRequest {
  
  public String nombre;
  public String apellidos;
  public int edad;  
  public Date fechaNacimiento;
 
}