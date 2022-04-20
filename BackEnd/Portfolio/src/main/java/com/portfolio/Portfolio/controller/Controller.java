/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eemoran
 */
@RestController
public class Controller {
    
    @Autowired
    public PersonaService perService;
    
    @GetMapping ("/persona/{id}")
    @ResponseBody
    public Persona listaPersonas(@PathVariable Long id){
        return  perService.buscarPersona(id);
    }
    
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers ){
       perService.crearPersona(pers);
    }
    
    @PostMapping("/edit/persona/estudios")
    public void editarPersonaEstudios(@RequestBody Persona pers ){
        
       perService.buscarPersona(pers.getId());
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> listaPersonas(){
        return  perService.verPersonas();
    }
    
    @GetMapping ("/ver/{id}/estudios")
    @ResponseBody
    public List<Educacion> listaEstudiosPersonas(@PathVariable Long id){
        return  perService.verEstudiosPersona(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        perService.borrarPersona(id);
    }
    
}
