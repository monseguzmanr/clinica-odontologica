package com.backend.clase;

import com.backend.clase.model.Computadora;
import com.backend.clase.service.ComputadoraFactory;

public class Main {
    public static void main(String[] args) {
        Computadora windows2 = ComputadoraFactory.obtenerComputadora(2, 128);
        Computadora mac16 = ComputadoraFactory.obtenerComputadora(16, 500);

        Computadora windows2_1 = ComputadoraFactory.obtenerComputadora(2, 128);
        Computadora mac8 = ComputadoraFactory.obtenerComputadora(8, 500);

    }
}
