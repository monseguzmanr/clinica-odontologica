package com.backend.clase;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;

    public Grupo() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona(Persona persona){
        if(cumpleCondiciones(persona.getEdad(), persona.getNombre())){
            personas.add(persona);
            System.out.println("Se agrego a la persona " + persona.getNombre() + " al grupo");
        } else{
            System.out.println("No fue posible agregar a " +  persona.getNombre() + " al grupo");
        }
    }

    public boolean esMayor(int edad){
        return edad > 18;
    }

    public boolean cumpleCantidadLetras(String nombre){
        return nombre.length() >= 5;
    }

    public boolean cumpleCondiciones(int edad, String nombre){
        return esMayor(edad) && cumpleCantidadLetras(nombre);
    }


}
