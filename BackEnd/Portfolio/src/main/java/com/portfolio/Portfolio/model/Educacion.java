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
    private Float puntaje;
    private int inicio;
    private int fin;

    public Educacion() {
    }

    public Educacion(int id, String escuela, String titulo, String carrera, Float puntaje, int inicio, int fin) {
        this.id = id;
        this.escuela = escuela;
        this.titulo = titulo;
        this.carrera = carrera;
        this.puntaje = puntaje;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    
    
    
}
