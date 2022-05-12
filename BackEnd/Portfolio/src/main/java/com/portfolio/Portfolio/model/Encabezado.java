/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.model;

import javax.persistence.Embeddable;
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
@Embeddable
@Getter @Setter
public class Encabezado {
    
    private String fechaNacimiento;
    private String nacionalidad;
    private String nombre;
    private String posicion;
    private String compania;
    private String ubicacion;
    private String imagenDeFondo;
    private String fotoPerfil;

    
}


