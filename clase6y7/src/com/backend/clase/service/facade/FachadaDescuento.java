package com.backend.clase.service.facade;

import com.backend.clase.model.Producto;
import com.backend.clase.model.Tarjeta;
import com.backend.clase.service.api.ApiCantidad;
import com.backend.clase.service.api.ApiProducto;
import com.backend.clase.service.api.ApiTarjeta;
import org.apache.log4j.Logger;

public class FachadaDescuento implements IDescuento{


    private final Logger LOGGER = Logger.getLogger(FachadaDescuento.class);

    @Override
    public int calcularDescuento(Producto producto, Tarjeta tarjeta, int cantidad) {
        int descuento = 0;
        //llamada api producto
        descuento += ApiProducto.calcularDescuentoProducto(producto);
        //llamada api tarjeta
        descuento += ApiTarjeta.calcularDescuentoTarjeta(tarjeta);
        //llamada api cantidad
        descuento += ApiCantidad.calcularDescuentoCantidad(cantidad);
        LOGGER.info("Descuento total: " + descuento);

        return descuento;
    }
}
