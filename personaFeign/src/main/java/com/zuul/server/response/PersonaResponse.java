package com.zuul.server.response;
import java.util.Date;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class PersonaResponse {
  
  public ObjectId _id;  
  public String nombre;
  public String apellidos;
  public int edad;  
  public Date fechaNacimiento;
  
  
  
  public String get_id() { return _id.toHexString(); }
}