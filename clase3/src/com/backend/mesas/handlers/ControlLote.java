package com.backend.mesas.handlers;


import com.backend.mesas.model.Articulo;

public class ControlLote extends ControlCalidad {

    @Override
    public void comprobarCalidad(Articulo articulo) {
        System.out.println("----  " + articulo.getNombre() + " en proceso de control de calidad ----");

        if (articulo.getLote() >= 1000 && articulo.getLote() <= 2000) {
            System.out.println("El artículo ha pasado exitosamente el control de lote ✅");
        } else {
            System.out.println("El artículo no ha pasado el control de lote ❌");
            articulo.setAceptado(false);
        }


        if (getSiguienteControl() != null) {
            getSiguienteControl().comprobarCalidad(articulo);
        }
    }
}