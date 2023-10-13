package com.backend.mesas.test;


import com.backend.mesas.model.TipoUsuario;
import com.backend.mesas.model.Usuario;
import com.backend.mesas.proxy.Descarga;
import com.backend.mesas.proxy.ProxyDescarga;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DescargaTest {

    @Test
    public void deberiaIniciarDescarga(){
        Usuario us1 = new Usuario(1, TipoUsuario.PREMIUM);
        Descarga proxy = new ProxyDescarga();

        String rtaEsperada = "Iniciando descarga para el usuario 1";
        String rtaObtenida = proxy.descargarCancion(us1);

        assertEquals(rtaEsperada, rtaObtenida);

    }

    @Test
    public void noDeberiaIniciarDescarga(){
        Usuario us2 = new Usuario(002, TipoUsuario.FREE);
        Descarga proxy = new ProxyDescarga();

        String rtaEsperada = "Iniciando descarga para el usuario 002";
        String rtaObtenida = proxy.descargarCancion(us2);

        assertNotEquals(rtaEsperada, rtaObtenida);
    }
}