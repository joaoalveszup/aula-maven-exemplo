package br.com.zup.estrelas.exemplo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection fabricaConexao() {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/estrelas?user=root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
