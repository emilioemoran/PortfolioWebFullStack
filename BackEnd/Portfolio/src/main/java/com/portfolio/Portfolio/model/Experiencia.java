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
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String posicion;
    private String compania;
    private String imagen;
    private String modo;
    private String fechaInicio;
    private String fechaFin;

    public Experiencia() {
    }

    public Experiencia(String posicion, String compania, String imagen, String modo, String fechaInicio, String fechaFin) {
        this.posicion = posicion;
        this.compania = compania;
        this.imagen = imagen;
        this.modo = modo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
 
    
    
    
}
