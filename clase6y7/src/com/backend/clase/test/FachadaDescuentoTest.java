package com.backend.clase.test;

import com.backend.clase.model.Producto;
import com.backend.clase.model.Tarjeta;
import com.backend.clase.service.facade.FachadaDescuento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FachadaDescuentoTest {

    private FachadaDescuento fachadaDescuento = new FachadaDescuento();

    @Test
    void deberiaCalcularse25DeDescuento(){

        //arrange
        Producto producto = new Producto("choclo", "latas");
        Tarjeta tarjeta = new Tarjeta("48663595", "Galicia");

        //act
        int descuentoObtenido = fachadaDescuento.calcularDescuento(producto, tarjeta, 15);

        //assert
        assertEquals(25, descuentoObtenido);

    }

}