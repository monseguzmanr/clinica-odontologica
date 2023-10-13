package com.backend.clase.model;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String dni;
    private LocalDate fechaAsignada;
    private String vacuna;

    public Persona(String nombre, String dni, LocalDate fechaAsignada, String vacuna) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaAsignada = fechaAsignada;
        this.vacuna = vacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(LocalDate fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
}
