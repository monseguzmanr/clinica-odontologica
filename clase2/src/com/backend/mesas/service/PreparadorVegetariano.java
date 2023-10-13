package com.backend.mesas.service;


import com.backend.mesas.model.Menu;
import com.backend.mesas.model.MenuVegetariano;

public class PreparadorVegetariano implements PreparadorMenu{

    @Override
    public String armar(Menu menu) {
        return "1 - Preparar ingredientes. \n2 - Agregar especias. \n3 - Cocinar";
    }

    @Override
    public double calcularPrecio(Menu menu) {
        double precio = 0;
        if(menu instanceof MenuVegetariano menuVegetariano){
            double recargos = (menuVegetariano.getPrecioBase() * 0.01) + (2 * menuVegetariano.getCantSalsas());
            precio = menuVegetariano.getPrecioBase() + recargos;
        }

        return precio;
    }
}
