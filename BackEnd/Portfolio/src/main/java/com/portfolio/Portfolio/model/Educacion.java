/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author eemoran
 */

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String escuela;
    private String titulo;
    private String carrera;
    private String imagen;
    private Double gpa;
    private String fechaInicio;
    private String fechaFin;

    public Educacion() {
    }

    public Educacion(int id, String escuela, String titulo, String carrera, String imagen, Double gpa, String fechaInicio, String fechaFin) {
        this.id = id;
        this.escuela = escuela;
        this.titulo = titulo;
        this.carrera = carrera;
        this.imagen = imagen;
        this.gpa = gpa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    

    
    
    
    
    
}
