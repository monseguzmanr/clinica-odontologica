package com.backend.mesas.service;


import com.backend.mesas.handlers.ControlCalidad;
import com.backend.mesas.handlers.ControlEnvase;
import com.backend.mesas.handlers.ControlLote;
import com.backend.mesas.handlers.ControlPeso;
import com.backend.mesas.model.Articulo;

public class ControladorCalidad {

    //se encarga de iniciar el proceso, por ende la cadena
    private ControlCalidad controlCalidad;

    public ControladorCalidad() {
        //definir el orden de la cadena
        //inicio
        controlCalidad = new ControlEnvase();

        //segundo eslabon
        ControlCalidad controlLote = new ControlLote();
        controlCalidad.setSiguienteControl(controlLote);

        //tercer eslabon
        ControlCalidad controlPeso = new ControlPeso();
        controlLote.setSiguienteControl(controlPeso);
    }


    public void comprobarCalidad(Articulo articulo) {
        controlCalidad.comprobarCalidad(articulo);
    }

}
