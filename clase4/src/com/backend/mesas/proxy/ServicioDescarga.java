package com.backend.mesas.proxy;


import com.backend.mesas.model.Usuario;

public class ServicioDescarga implements Descarga {
    @Override
    public String descargarCancion(Usuario usuario) {
        return "Iniciando descarga para el usuario " + usuario.getId();
    }
}
