package com.backend.mesas.model;

import com.backend.mesas.model.Menu;

public class MenuInfantil extends Menu {
    private int juguetes;

    public MenuInfantil(double precioBase, int juguetes) {
        super(precioBase);
        this.juguetes = juguetes;
    }

    public int getJuguetes() {
        return juguetes;
    }

    public void setJuguetes(int juguetes) {
        this.juguetes = juguetes;
    }
}
