package com.backend.clase.service.api;

import com.backend.clase.model.Producto;
import org.apache.log4j.Logger;

public class ApiProducto {

    private static final Logger LOGGER = Logger.getLogger(ApiProducto.class);

    public static int calcularDescuentoProducto(Producto producto){

        //condicion a verificar ? lo que debe suceder si se cumple : lo que debe suceder si no se cumple
        int descuento = producto.getTipo().equalsIgnoreCase("latas") ? 10 : 0;

        //int descuento = 0;
        //if(producto.getTipo().equalsIgnoreCase("latas")){
        //    descuento = 10;
        //}

        LOGGER.info("Descuento correspondiente por producto: \n" + producto + "\nDescuento: " + descuento);

        return descuento;
    }
}
