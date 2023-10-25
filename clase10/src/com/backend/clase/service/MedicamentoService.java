package com.backend.clase.service;

import com.backend.clase.dao.IDao;
import com.backend.clase.model.Medicamento;

public class MedicamentoService {
    //capa de logica de negocio que interactua con la capa de persistencia, pero desconoce los detalles de la implementacion de esa persistencia
    private IDao<Medicamento> medicamentoIDao;


    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento registrarMedicamento(Medicamento medicamento) {
        return medicamentoIDao.registrar(medicamento);
    }

    public Medicamento buscarMedicamentoPorId(int id) {
        return medicamentoIDao.buscarPorId(id);
    }


}
