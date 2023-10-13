package com.backend.mesas.model;

public class Menu {
    //consigna - https://drive.google.com/file/d/1Al8GtM8V4bWTbyB7UO0VVoYG2D9D8qet/view
    private double precioBase;

    public Menu(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}
