/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taller.model;

import java.sql.Date;


/**
 *
 * @author E201
 */
public class Empleados {
    private int id;
    private int id_depart;
    private String nombre;
    private float salario;
    private Date fecha_ingreso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_depart() {
        return id_depart;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    
    public Empleados(int id, int id_depart, String nombre, float salario, Date fecha_ingreso) {
        this.id = id;
        this.id_depart = id_depart;
        this.nombre = nombre;
        this.salario = salario;
        this.fecha_ingreso = fecha_ingreso;
    }

    @Override
    public String toString() {
        return "Empleados{" + "id=" + id + ", id_depart=" + id_depart + ", nombre=" + nombre + ", salario=" + salario + ", fecha_ingreso=" + fecha_ingreso + '}';
    }

    
}
