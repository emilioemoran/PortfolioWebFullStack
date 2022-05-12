/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.Repository.PersonaRepository;
import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.Encabezado;
import com.portfolio.Portfolio.model.Experiencia;
import com.portfolio.Portfolio.model.Habilidad;
import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;
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
    
    
    public void editaPersonaEncabezado(Long id, Encabezado encabezado) {
        Persona pers= persRepo.findById(id).orElse(null);
        pers.setEncabezado(encabezado);
        persRepo.save(pers);
    }
    
    public void agregaNuevaExperiencia(Long id, Experiencia experiencia) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Experiencia> exp= pers.getExperiencias();
        exp.add(experiencia);
        pers.setExperiencias(exp);
        persRepo.save(pers);
    }
    
    public void borrarExperiencia(Long id, Experiencia experiencia) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Experiencia> exp= pers.getExperiencias();
        for (int i=0; i<exp.size(); i++) {
            Experiencia e = exp.get(i);
            if (experiencia.getId()== e.getId()){
                exp.remove(i);
            }
        }    
        persRepo.save(pers);
    }
    
    public void agregaNuevaEducacion(Long id, Educacion educacion) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Educacion> edu= pers.getEstudios();
        edu.add(educacion);
        pers.setEstudios(edu);
        persRepo.save(pers);
    }
    
    public void borrarEducacion(Long id, Educacion educacion) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Educacion> edu= pers.getEstudios();
        for (int i=0; i<edu.size(); i++) {
            Educacion e = edu.get(i);
            if (educacion.getId()== e.getId()){
                edu.remove(i);
            }
        }    
        persRepo.save(pers);
    }
    
    public void agregaNuevaHabilidad(Long id, Habilidad habilidad) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Habilidad> hab= pers.getHabilidades();
        hab.add(habilidad);
        pers.setHabilidades(hab);
        persRepo.save(pers);
    }
    
    public void borrarHabilidad(Long id, Habilidad habilidad) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Habilidad> hab= pers.getHabilidades();
        for (int i=0; i<hab.size(); i++) {
            Habilidad e = hab.get(i);
            if (habilidad.getId()== e.getId()){
                hab.remove(i);
            }
        }    
        persRepo.save(pers);
    }
    
    public void agregaNuevoProyecto(Long id, Proyecto proyecto) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Proyecto> pro= pers.getProyectos();
        pro.add(proyecto);
        pers.setProyectos(pro);
        persRepo.save(pers);
    }
    
    public void borrarProyecto(Long id, Proyecto proyecto) {
        Persona pers= persRepo.findById(id).orElse(null);
        List<Proyecto> hab= pers.getProyectos();
        for (int i=0; i<hab.size(); i++) {
            Proyecto e = hab.get(i);
            if (proyecto.getId()== e.getId()){
                hab.remove(i);
            }
        }    
        persRepo.save(pers);
    }
    
    
    public void editaPersonaAcercaDe(Long id, String acercaDe){
        Persona pers= persRepo.findById(id).orElse(null);
        pers.setSobreMi(acercaDe);
        persRepo.save(pers);
    }
    
}
