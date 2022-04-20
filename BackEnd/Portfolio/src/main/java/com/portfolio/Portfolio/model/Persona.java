/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private String mail;
    private String sobreMi;
    private String ocupacion;
    private String imagenDeFondo;
    private String fotoPerfil;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Educacion> estudios;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Habilidad> habilidades;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Proyecto> proyectos;
    
    public Persona(){
        
    }

    public Persona(long id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String mail, String sobreMi, String ocupacion, String imagenDeFondo, String fotoPerfil, List<Educacion> estudios, List<Habilidad> habilidades, List<Proyecto> proyectos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.mail = mail;
        this.sobreMi = sobreMi;
        this.ocupacion = ocupacion;
        this.imagenDeFondo = imagenDeFondo;
        this.fotoPerfil = fotoPerfil;
        this.estudios = estudios;
        this.habilidades = habilidades;
        this.proyectos = proyectos;
    }

    
    
    
    
}
