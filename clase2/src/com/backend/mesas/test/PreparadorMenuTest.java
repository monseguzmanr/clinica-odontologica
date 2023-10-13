package com.backend.mesas.test;

import com.backend.mesas.model.Menu;
import com.backend.mesas.model.MenuInfantil;
import com.backend.mesas.service.PreparadorInfantil;
import com.backend.mesas.service.PreparadorMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PreparadorMenuTest {

    @Test
    public void deberiaPrepararMenuInfantil(){
        Menu menu = new MenuInfantil(2000, 2);
        PreparadorMenu preparadorInfantil = new PreparadorInfantil();

        String rtaEsperada =  "Iniciando preparacion...\n" + "1 - Preparar ingredientes. \n2 - Agregar juguetes. \n3 - Cocinar" + "\nEl precio es: $2006.0";
        String rtaObtenida = preparadorInfantil.prepararMenu(menu);

        assertEquals(rtaEsperada, rtaObtenida);

    }

}