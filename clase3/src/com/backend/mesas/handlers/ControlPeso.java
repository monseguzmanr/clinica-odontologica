package com.backend.mesas.handlers;


import com.backend.mesas.model.Articulo;

public class ControlPeso extends ControlCalidad {
    @Override
    public void comprobarCalidad(Articulo articulo) {
        if (articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300) {
            System.out.println("El artículo ha pasado exitosamente el control de peso ✅");

        } else {
            System.out.println("El artículo no ha pasado el control de lote ❌");
            articulo.setAceptado(false);
        }

        if (getSiguienteControl() != null) {
            getSiguienteControl().comprobarCalidad(articulo);
        }

    }
}
