package com.backend.clase.service;

import com.backend.clase.model.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private static Map<String, Computadora> computadorasFlyweight = new HashMap<>();

    public static Computadora obtenerComputadora(int ram, int disco){
        //definir la key
        String key = "key:" + ram + ":" + disco;
        //verificar si ya existe esa key en la coleccion
        if(!computadorasFlyweight.containsKey(key)){
            //crear la computadora
            Computadora computadora = new Computadora(ram, disco);
            computadorasFlyweight.put(key, computadora);
            System.out.println("Computadora creada");

        } else System.out.println("Computadora encontrada");


        return computadorasFlyweight.get(key);


    }



}
