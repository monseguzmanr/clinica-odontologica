package com.backend.clase.model;

public class EmpleadoContratado extends Empleado {
    private double cantHoras;
    private double valorHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroCuenta, double cantHoras, double valorHora) {
        super(nombre, apellido, numeroCuenta);
        this.cantHoras = cantHoras;
        this.valorHora = valorHora;
    }

    public double getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(double cantHoras) {
        this.cantHoras = cantHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
