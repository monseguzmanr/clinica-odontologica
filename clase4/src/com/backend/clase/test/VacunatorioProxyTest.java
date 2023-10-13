package com.backend.clase.test;

import com.backend.clase.model.Persona;
import com.backend.clase.proxy.Vacunatorio;
import com.backend.clase.proxy.VacunatorioProxy;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacunatorioProxyTest {

    private Vacunatorio vacunatorio = new VacunatorioProxy();

    @Test
    void siLaPersonaConcurreAntesDeSuFechaAsignada_noDeberiaVacunarseALaPersona(){
        //arrange
        Persona persona = new Persona("Enzo Fernandez", "45000000", LocalDate.of(2023, 10, 15), "AntiGripal");
        String rtaEsperada = "La fecha no se corresponde con la fecha asignada";

        //act
        String rtaObtenida = vacunatorio.vacunar(persona);

        //assert
        assertEquals(rtaEsperada, rtaObtenida);

    }
}