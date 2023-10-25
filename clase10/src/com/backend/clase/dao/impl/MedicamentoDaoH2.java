package com.backend.clase.dao.impl;

import com.backend.clase.dao.H2Connection;
import com.backend.clase.dao.IDao;
import com.backend.clase.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private final Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);


    @Override
    public Medicamento registrar(Medicamento medicamento) {
        Connection connection = null;
        Medicamento medicamentoPersistido = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MEDICAMENTOS (CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO) VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, medicamento.getCodigo());
            preparedStatement.setString(2, medicamento.getNombre());
            preparedStatement.setString(3, medicamento.getLaboratorio());
            preparedStatement.setInt(4, medicamento.getCantidad());
            preparedStatement.setDouble(5, medicamento.getPrecio());
            preparedStatement.execute();

            connection.commit();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                medicamentoPersistido = new Medicamento(resultSet.getInt(1), medicamento.getCodigo(), medicamento.getNombre(), medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());
            }

            LOGGER.info("Medicamento guardado: " + medicamentoPersistido);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }


        return medicamentoPersistido;
    }

    @Override
    public Medicamento buscarPorId(int id) {
        Medicamento medicamento = null;

        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                medicamento = crearObjetoMedicamento(rs);

            }
            LOGGER.info("Se ha encontrado el medicamento " + medicamento);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }


        return medicamento;
    }


    private Medicamento crearObjetoMedicamento(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        int codigo = rs.getInt("codigo");
        String laboratorio = rs.getString("laboratorio");
        int cantidad = rs.getInt("cantidad");
        double precio = rs.getDouble("precio");

        return new Medicamento(id, codigo, nombre, laboratorio, cantidad, precio);

    }
}
