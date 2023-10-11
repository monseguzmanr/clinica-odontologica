package com.backend.clase.service;

import com.backend.clase.model.Empleado;
import com.backend.clase.model.EmpleadoEfectivo;

public class LiquidadorEfectivo extends LiquidadorSueldo {
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double sueldo = 0;
        if (empleado instanceof EmpleadoEfectivo empleadoEfectivo) {
            sueldo = empleadoEfectivo.getSueldoBasico() + empleadoEfectivo.getPremio() - empleadoEfectivo.getDescuento();
        }

        return sueldo;
    }

    @Override
    protected String generarRecibo(Empleado empleado) {
        return "Recibo generado en formato digital";
    }
}
