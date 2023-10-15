/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author a2484
 */

public abstract class DAO {
    
    public static final String DBURL = "jdbc:h2:./vet2021.db"; //CRIANDO O BANCO
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
}


// Connect to SQLite
    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    
    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    
    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    protected final boolean createTable() {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Cliente( \n" //PRONTO
                    + "id_cli INTEGER PRIMARY KEY, \n"
                    + "nome_cli VARCHAR, \n"
                    + "telefone_cli VARCHAR, \n"
                    + "endereco_cli VARCHAR, \n"
                    + "cep_cli VARCHAR, \n"
                    + "email_cli VARCHAR); \n");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Animal( \n" //PRONTO
                    + "id_ani INTEGER PRIMARY KEY, \n"
                    + "id_cli INTEGER, \n"
                    + "id_esp INTEGER, \n"
                    + "nome_ani VARCHAR, \n"
                    + "idade_ani INTEGER, \n"
                    + "sexo_ani VARCHAR); \n");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Especie( \n"//PRONTO
                    + "id_esp INTEGER PRIMARY KEY, \n"
                    + "nome_esp VARCHAR); \n");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Veterinario( \n"//PRONTO
                    + "id_vet INTEGER PRIMARY KEY, \n"
                    + "nome_vet VARCHAR, \n "
                    +"email VARCHAR, \n"
                    + "cidade_vet VARCHAR, \n "
                    + "estado_vet VARCHAR, \n "
                    + "rua_vet VARCHAR, \n "
                    + "bairro_vet VARCHAR, \n "
                    + "tel_vet VARCHAR); \n");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Tratamento( \n" //PRONTO
                    + "id_trat INTEGER PRIMARY KEY, \n"
                    + "id_animal INTEGER, \n"
                    + "data_ini VARCHAR, \n"
                    + "data_fim VARCHAR, \n"
                    + "finalizado INTEGER); \n");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Consulta( \n" //PRONTO
                    + "id_cons INTEGER PRIMARY KEY, \n"
                    + "id_trat INTEGER, \n"
                    + "id_vet INTEGER, \n"
                    + "id_animal INTEGER, \n"
                    + "sintomas VARCHAR, \n"
                    + "dat_con VARCHAR); \n");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Exame( \n" //PRONTO
                    + "id_exam INTEGER PRIMARY KEY, \n"
                    + "id_cons INTEGER, \n"
                    + "des_exame VARCHAR, \n"
                    + "res_exame VARCHAR); \n");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO Especie (id_esp, nome_esp) VALUES (1, 'Cachorro')");
            executeUpdate(stmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}