/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.playload.request;

/**
 *
 * @author eemoran
 */
import com.portfolio.Portfolio.model.Persona;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.*;

public class SignUpRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;


  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Persona persona;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public Persona getPersona() {
    return persona ;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

}
