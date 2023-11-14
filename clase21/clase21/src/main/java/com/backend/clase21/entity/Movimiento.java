package com.backend.clase21.entity;


import javax.persistence.*;

@Entity
@Table(name = "MOVIMIENTOS")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESC")
    private String descripcion;

    @Column(name = "MONT")
    private double monto;

    public Movimiento() {
    }

    public Movimiento(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
