package com.backend.mesas.model;

public class Articulo {
    //https://drive.google.com/file/d/1XLisBZou5SRi7G3F15GYwzH6AdAPCcv8/view - Consigna

    private String nombre;
    private int lote;
    private double peso;
    private String envasado;
    private boolean aceptado;

    public Articulo(String nombre, int lote, double peso, String envasado) {
        this.nombre = nombre;
        this.lote = lote;
        this.peso = peso;
        this.envasado = envasado;
        this.aceptado = true;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEnvasado() {
        return envasado;
    }

    public void setEnvasado(String envasado) {
        this.envasado = envasado;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }
}


