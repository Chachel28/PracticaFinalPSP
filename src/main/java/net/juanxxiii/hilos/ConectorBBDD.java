package net.juanxxiii.hilos;

import com.github.javafaker.Faker;

import java.sql.*;

public class ConectorBBDD extends Thread {
    private final int rangoInicial;
    private final int rangoFinal;

    public ConectorBBDD(int rangoInicial, int rangoFinal) {
        this.rangoFinal = rangoFinal;
        this.rangoInicial = rangoInicial;
    }

    @Override
    public void run() {
        super.run();
        for (int i = rangoInicial; i <= rangoFinal; i++) {
            insertarDatos();
        }
    }

    private synchronized void insertarDatos() {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/bbdd_psp_1",
                             "DAM2020_PSP",
                             "DAM2020_PSP");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO empleados(email, ingresos) VALUES( ?, ?)")) {
            Faker faker = new Faker();
            preparedStatement.setString(1, faker.internet().emailAddress());
            preparedStatement.setInt(2, faker.number().numberBetween(10, 1000));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
