package com.backend.mesas.service;

public class CalculadoraDeAreaService {
    //consigna https://docs.google.com/document/d/15AFTgrYuCdzXSJ2s-ZhsVzrnaE5HSS4cI3c9F21VHU4/edit
    public static String areaCirculo(double radio){
        String respuesta = "El valor tiene que ser mayor a cero";
        if(radio > 0) respuesta = "El area del circulo es igual a " + (Math.PI * Math.pow(radio, 2));
        return respuesta;
    }

    public static String areaCuadrado(double lado){
        String respuesta = "El valor tiene que ser mayor a cero";
        if(lado > 0) respuesta = "El area del cuadrado es igual a " + Math.pow(lado, 2);
        return respuesta;
    }

}
