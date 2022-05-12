/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author eemoran
 */

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sobreMi;
   
    @Embedded private Encabezado encabezado;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Educacion> estudios;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Experiencia> experiencias;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Habilidad> habilidades;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Proyecto> proyectos;
    
    public Persona(){
         this.encabezado = new Encabezado();
         
         encabezado.setFotoPerfil("");
         encabezado.setImagenDeFondo("");
    }

    public Persona(Long id, String sobreMi, Encabezado encabezado, List<Educacion> estudios, List<Experiencia> experiencias, List<Habilidad> habilidades, List<Proyecto> proyectos) {
        this.id = id;
        this.sobreMi = sobreMi;
        this.encabezado = encabezado;
        this.estudios = estudios;
        this.experiencias = experiencias;
        this.habilidades = habilidades;
        this.proyectos = proyectos;
    }

  
    

    

    

   

   

    

    

    
    
    
    
}
