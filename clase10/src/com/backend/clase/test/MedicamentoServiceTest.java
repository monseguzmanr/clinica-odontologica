package com.backend.clase.test;

import com.backend.clase.dao.impl.MedicamentoDaoH2;
import com.backend.clase.dao.impl.MedicamentoDaoMemoria;
import com.backend.clase.model.Medicamento;
import com.backend.clase.service.MedicamentoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MedicamentoServiceTest {


    private MedicamentoService medicamentoService;

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/c1clase10;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void deberiaAgregarYRetornarIdDeMedicamentoEnH2() {
        medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        Medicamento medicamentoAPersistir = new Medicamento(35465, "Aspirina", "Bayer", 50, 200);

        Medicamento medicamentoPersistido = medicamentoService.registrarMedicamento(medicamentoAPersistir);

        assertNotNull(medicamentoPersistido.getId());

    }


    @Test
    void deberiaAgregarYRetornarIdDeMedicamentoEnMemoria() {
        medicamentoService = new MedicamentoService(new MedicamentoDaoMemoria(new ArrayList<>()));
        Medicamento medicamentoAPersistir = new Medicamento(35465, "Aspirina", "Bayer", 50, 200);
        Medicamento medicamentoPersistido = medicamentoService.registrarMedicamento(medicamentoAPersistir);
        assertNotNull(medicamentoPersistido.getId());

    }


}