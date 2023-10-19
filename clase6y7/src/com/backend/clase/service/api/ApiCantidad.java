package com.backend.clase.service.api;

import org.apache.log4j.Logger;

public class ApiCantidad {
    private static final Logger LOGGER = Logger.getLogger(ApiCantidad.class);

    public static int calcularDescuentoCantidad(int cantidad) {
        int descuento = cantidad > 12 ? 15 : 0;

        LOGGER.info("Descuento correspondiente por cantidad: " + descuento);

        return descuento;
    }
}
