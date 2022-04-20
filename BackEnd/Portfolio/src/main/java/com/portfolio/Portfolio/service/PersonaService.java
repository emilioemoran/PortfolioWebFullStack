/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.Repository.PersonaRepository;
import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eemoran
 */
@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persRepo.findAll();
    }

    @Override
    public void crearPersona(Persona pers) {
        persRepo.save(pers);
    }

    @Override
    public void borrarPersona(Long id) {
        persRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persRepo.findById(id).orElse(null);
    }

    @Override
    public List<Educacion> verEstudiosPersona(Long id) {
        return persRepo.findById(id).orElse(null).getEstudios();
    }
    
}
