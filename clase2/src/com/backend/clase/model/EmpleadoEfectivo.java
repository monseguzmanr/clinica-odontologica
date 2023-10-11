package com.backend.clase.model;

public class EmpleadoEfectivo extends Empleado {
    private double sueldoBasico;
    private double premio;
    private double descuento;

    public EmpleadoEfectivo(String nombre, String apellido, String numeroCuenta, double sueldoBasico, double premio, double descuento) {
        super(nombre, apellido, numeroCuenta);
        this.sueldoBasico = sueldoBasico;
        this.premio = premio;
        this.descuento = descuento;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
