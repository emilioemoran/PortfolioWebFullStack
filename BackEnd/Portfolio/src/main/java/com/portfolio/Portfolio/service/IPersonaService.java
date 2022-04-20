/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.Persona;
import java.util.List;

/**
 *
 * @author eemoran
 */
public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona pers);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public List<Educacion> verEstudiosPersona(Long id);
    
    
}
