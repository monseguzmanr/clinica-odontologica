package com.backend.clase.dao.impl;

import com.backend.clase.dao.IDao;
import com.backend.clase.model.Medicamento;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoDaoMemoria implements IDao<Medicamento> {

    private final Logger LOGGER = Logger.getLogger(MedicamentoDaoMemoria.class);
    private List<Medicamento> medicamentoRepository;

    public MedicamentoDaoMemoria(List<Medicamento> medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    public Medicamento registrar(Medicamento medicamento) {
        int id = medicamentoRepository.size() + 1;
        medicamentoRepository.add(medicamento);
        Medicamento medicamentoGuardado = new Medicamento(id,  medicamento.getCodigo(), medicamento.getNombre(),medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());
        LOGGER.info("Medicamento guardado: " + medicamentoGuardado);
        return medicamento;
    }


    @Override
    public Medicamento buscarPorId(int id) {
        Medicamento medicamentoBuscado = medicamentoRepository.get(id - 1);
        if (medicamentoBuscado != null)
            LOGGER.info("El medicamento de id " + id + " ha sido encontrado: " + medicamentoBuscado);
        else LOGGER.info("Medicamento no encontrado");
        return medicamentoBuscado;
    }

    public List<Medicamento> getMedicamentoRepository() {
        return medicamentoRepository;
    }
}
