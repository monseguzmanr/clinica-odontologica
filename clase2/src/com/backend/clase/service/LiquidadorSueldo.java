package com.backend.clase.service;

import com.backend.clase.model.Empleado;

public abstract class LiquidadorSueldo {

    //metodo template
    public String liquidarSueldo(Empleado empleado) {
        String respuesta = "La liquidacion no se pudo realizar";

        //paso 1 - calcular sueldo
        double sueldo = calcularSueldo(empleado);
        //paso 2 - generar recibo
        if (sueldo > 0) {
            String recibo = generarRecibo(empleado);
            respuesta = recibo + ". Sueldo a liquidar $" + sueldo;
            //paso 3 - depositar
            System.out.println(depositar(empleado));
        }


        return respuesta;

    }

    protected abstract double calcularSueldo(Empleado empleado);

    protected abstract String generarRecibo(Empleado empleado);

    private String depositar(Empleado empleado) {
        return "Orden de deposito en la cuenta: " + empleado.getNumeroCuenta();
    }


}
