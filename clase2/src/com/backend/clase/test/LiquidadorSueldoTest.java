package com.backend.clase.test;

import com.backend.clase.model.Empleado;
import com.backend.clase.model.EmpleadoEfectivo;
import com.backend.clase.service.LiquidadorEfectivo;
import com.backend.clase.service.LiquidadorSueldo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorSueldoTest {

    private LiquidadorSueldo liquidadorSueldo;

    @Test
    void unLiquidadorEfectivo_deberiaCalcularleElSueldoAUnEmpleadoEfectivo(){
        //arrange
        Empleado empleado = new EmpleadoEfectivo("Damian", "Perez", "CA-546846531456", 1000000, 5000, 20000);
        liquidadorSueldo = new LiquidadorEfectivo();

        //act
        String rtaEsperada = "Recibo generado en formato digital. Sueldo a liquidar $985000.0";
        String rtaObtenida = liquidadorSueldo.liquidarSueldo(empleado);

        //assert
        assertEquals(rtaEsperada, rtaObtenida);
    }

}