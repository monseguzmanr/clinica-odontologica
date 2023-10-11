package com.backend.clase.test;

import com.backend.clase.Grupo;
import com.backend.clase.Persona;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
// Dadas 5 personas (Juan, Pedro, Ana, Luz y Julián) y  una colección vacía de objetos tipo Persona, cuando se intentan agregar estas a la colección, el tamaño de la colección debería ser 2.


    private final Grupo GRUPO = new Grupo();

    @Test
    void alIntentarAgregar5PersonasAlGrupo_deberiaAgregar2_teniendoEnCuentaLaCantidadDeLetras(){
        //arrange
        Persona persona1 = new Persona("Juan", 20);
        Persona persona2 = new Persona("Pedro", 20);
        Persona persona3 = new Persona("Ana", 20);
        Persona persona4 = new Persona("Luz", 20);
        Persona persona5 = new Persona("Julian", 20);

        //act
        GRUPO.agregarPersona(persona1);
        GRUPO.agregarPersona(persona2);
        GRUPO.agregarPersona(persona3);
        GRUPO.agregarPersona(persona4);
        GRUPO.agregarPersona(persona5);

        //assert
        assertEquals(2, GRUPO.getPersonas().size());
    }

}