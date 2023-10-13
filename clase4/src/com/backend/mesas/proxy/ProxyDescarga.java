package com.backend.mesas.proxy;


import com.backend.mesas.model.TipoUsuario;
import com.backend.mesas.model.Usuario;

public class ProxyDescarga implements Descarga{

    private ServicioDescarga servicioDescarga;

    @Override
    public String descargarCancion(Usuario usuario) {
        String rta = "Deber ser usuario premium para poder descargar";
        if(comprobarTipoUsuario(usuario.getTipoUsuario())){
            servicioDescarga = new ServicioDescarga();
            rta = servicioDescarga.descargarCancion(usuario);
        }
        return rta;
    }

    private boolean comprobarTipoUsuario(TipoUsuario tipoUsuario){
        return tipoUsuario.equals(TipoUsuario.PREMIUM);
    }
}
