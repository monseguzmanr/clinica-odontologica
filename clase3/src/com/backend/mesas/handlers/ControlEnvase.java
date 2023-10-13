package com.backend.mesas.handlers;


import com.backend.mesas.model.Articulo;

public class ControlEnvase extends ControlCalidad {
    @Override
    public void comprobarCalidad(Articulo articulo) {
        if (articulo.getEnvasado().equalsIgnoreCase("sano") || articulo.getEnvasado().equalsIgnoreCase("casi sano")) {
            System.out.println("El artículo ha pasado exitosamente el control de envase ✅");

        } else {
            articulo.setAceptado(false);
            System.out.println("El artículo no ha pasado el control de envase ❌");
        }


        if (getSiguienteControl() != null) {
            getSiguienteControl().comprobarCalidad(articulo);
        }

        if (articulo.isAceptado()) {
            System.out.println("\u001B[32m" + "✅ El artículo ha sido aprobado por el departamento de calidad ✅" + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "❌ El artículo no ha sido aprobado por el departamento de calidad ❌" + "\u001B[0m");
        }

    }
}