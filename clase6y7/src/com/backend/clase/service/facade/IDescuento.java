package com.backend.clase.service.facade;

import com.backend.clase.model.Producto;
import com.backend.clase.model.Tarjeta;

public interface IDescuento {
    //https://docs.google.com/document/d/1Fp2XKtbGUxr8i6EXzDScdZNF1nDtXsKf/edit
    int calcularDescuento(Producto producto, Tarjeta tarjeta, int cantidad);
}
