package com.mycompany.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/java_crud";
    private static final String USER = "root";
    private static final String PASSWORD = "senac@2025";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão: " + e.getMessage(), e);
        }
    }
    
    public static void mostrarDados(String tabela) {
        String sql = "SELECT * FROM " + tabela;
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            // Obter informações sobre as colunas
            int columnCount = rs.getMetaData().getColumnCount();
            
            // Imprimir cabeçalho com os nomes das colunas
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println("\n--------------------------------------------------");
            
            // Imprimir os dados
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Teste de conexão
        try (Connection conn = getConnection()) {
            System.out.println("✅ Conexão bem-sucedida!");
            
            // Exemplo: mostrar dados da tabela 'clientes'
            // Substitua pelo nome da tabela que você quer visualizar
            mostrarDados("conta");
            
        } catch (SQLException e) {
            System.out.println("❌ Falha na conexão: " + e.getMessage());
        }
    }
}