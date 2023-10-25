package com.backend.clase;

import com.backend.clase.dbConnection.H2Connection;
import com.backend.clase.model.Cuenta;
import org.apache.log4j.Logger;

import java.sql.*;


public class Transaccion {
    //https://docs.google.com/document/d/1DI0BR3R7Uy_PWCnm-b1YMeBuhIsDe6OeR6DwmLlx_qQ/edit
    private static final Logger LOGGER = Logger.getLogger(Transaccion.class);

    private static final String CREATE = "DROP TABLE IF EXISTS CUENTAS; CREATE TABLE CUENTAS (ID INT PRIMARY KEY AUTO_INCREMENT, NOMBRE VARCHAR(100) NOT NULL, NUMERO_CUENTA INT NOT NULL, SALDO NUMERIC(10, 2) NOT NULL)";
    private static final String INSERT = "INSERT INTO CUENTAS (NOMBRE, NUMERO_CUENTA, SALDO) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE CUENTAS SET SALDO = ? WHERE NUMERO_CUENTA = ?";

    private static final String SELECT = "SELECT * FROM CUENTAS WHERE NUMERO_CUENTA = ?";

    public static void main(String[] args) {

        Connection connection = null;
        Cuenta cuenta = new Cuenta("Lu", 26596, 50000);
        Cuenta cuenta1 = null;

        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            //creamos la tabla
            Statement statement = connection.createStatement();
            statement.execute(CREATE);

            //Insertar datos
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, cuenta.getNombre());
            preparedStatement.setInt(2, cuenta.getNumeroCuenta());
            preparedStatement.setDouble(3, cuenta.getSaldo());
            preparedStatement.execute();


            //agregar 10 al saldo
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(UPDATE);
            preparedStatementUpdate.setDouble(1, cuenta.getSaldo() + 10);
            preparedStatementUpdate.setInt(2, cuenta.getNumeroCuenta());
            preparedStatementUpdate.execute();
            cuenta.setSaldo(cuenta.getSaldo() + 10);


            int aux = 1/0;


            //agregar 15 al saldo
            PreparedStatement preparedStatementUpdate2 = connection.prepareStatement(UPDATE);
            preparedStatementUpdate2.setDouble(1, cuenta.getSaldo() + 15);
            preparedStatementUpdate2.setInt(2, cuenta.getNumeroCuenta());
            preparedStatementUpdate2.execute();


            connection.commit();

            //obtener los datos y mostrarlos
            PreparedStatement preparedStatementSelect = connection.prepareStatement(SELECT);
            preparedStatementSelect.setInt(1, cuenta.getNumeroCuenta());
            ResultSet resultSet = preparedStatementSelect.executeQuery();
            while (resultSet.next()){
                cuenta1 = new Cuenta(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4));
                LOGGER.info(cuenta1);
            }


            //connection.setAutoCommit(true);

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    exception.printStackTrace();
                    LOGGER.error(exception.getMessage());
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }

        } finally {

            try {
                connection.close();
            } catch (Exception exception) {
                LOGGER.error(exception.getMessage());
            }
        }

    }
}
