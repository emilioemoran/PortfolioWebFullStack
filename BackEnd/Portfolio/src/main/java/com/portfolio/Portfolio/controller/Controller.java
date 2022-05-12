/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.Encabezado;
import com.portfolio.Portfolio.model.Experiencia;
import com.portfolio.Portfolio.model.Habilidad;
import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.service.PersonaService;
import com.portfolio.Portfolio.service.UserService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
    
    @Autowired
    public PersonaService perService;
    
    @Autowired
    public UserService userService;
    
    
    
    @GetMapping ("/persona/{id}")
    @ResponseBody
    public User buscaPersonas(@PathVariable Long id){
        return  userService.buscarUser(id);
    }
    
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers ){
       perService.crearPersona(pers);
    }
    
    @PostMapping("/edit/persona/estudios")
    public void editarPersonaEstudios(@RequestBody Persona pers ){
        
       perService.buscarPersona(pers.getId());
    }
    
    @PostMapping("/persona/edit/acercade/{id}")
    public void editarPersonaAcercaDe(@PathVariable Long id , @RequestBody String acercaDe ){
        
       perService.editaPersonaAcercaDe(id, acercaDe);
    }
    
    @PostMapping("/persona/new/experiencia/{id}")
    public void nuevaExperiencia(@PathVariable Long id , @RequestBody Experiencia experiencia ){
        
       perService.agregaNuevaExperiencia(id, experiencia);
    }
    
    @PostMapping("/persona/delete/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id , @RequestBody Experiencia experiencia ){
        
       perService.borrarExperiencia(id, experiencia);
    }
    
    @PostMapping("/persona/new/educacion/{id}")
    public void nuevaEducacion(@PathVariable Long id , @RequestBody Educacion educacion ){
        
       perService.agregaNuevaEducacion(id, educacion);
    }
    
    @PostMapping("/persona/delete/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id , @RequestBody Educacion educacion ){
        
       perService.borrarEducacion(id, educacion);
    }
    
    @PostMapping("/persona/new/habilidad/{id}")
    public void nuevaHabilidad(@PathVariable Long id , @RequestBody Habilidad habilidad ){
        
       perService.agregaNuevaHabilidad(id, habilidad);
    }
    
    @PostMapping("/persona/delete/habilidad/{id}")
    public void borrarHabilidad(@PathVariable Long id , @RequestBody Habilidad habilidad ){
        
       perService.borrarHabilidad(id, habilidad);
    }
    
    @PostMapping("/persona/edit/encabezado/{id}")
    public void editarPersonaEncabezado(@PathVariable Long id , @RequestBody Encabezado encabezado){
        
       perService.editaPersonaEncabezado(id, encabezado);
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
    
    @PostMapping("/persona/new/proyecto/{id}")
    public void nuevoProyecto(@PathVariable Long id , @RequestBody Proyecto proyecto ){
        
       perService.agregaNuevoProyecto(id, proyecto);
    }
    
     @PostMapping("/persona/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id , @RequestBody Proyecto proyecto ){
        
       perService.borrarProyecto(id, proyecto);
    }
    
}
