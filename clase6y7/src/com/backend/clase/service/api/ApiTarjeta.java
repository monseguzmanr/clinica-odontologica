package com.backend.clase.service.api;

import com.backend.clase.model.Tarjeta;
import org.apache.log4j.Logger;

public class ApiTarjeta {

    private static final Logger LOGGER = Logger.getLogger(ApiTarjeta.class);

    public static int calcularDescuentoTarjeta(Tarjeta tarjeta){

        int descuento = tarjeta.getBanco().equalsIgnoreCase("Star Bank") ? 20 : 0;

        LOGGER.info("Descuento correspondiente por tarjeta: \n" + tarjeta + "\nDescuento: " + descuento);

        return descuento;

    }

}
