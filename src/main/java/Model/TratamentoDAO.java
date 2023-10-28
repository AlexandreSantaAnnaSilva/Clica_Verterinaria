/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import Model.Tratamento;

/**
 *
 * @author Gritti
 */
public class TratamentoDAO extends DAO {

    private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    public static TratamentoDAO getInstance() {
        return (instance == null ? (instance = new TratamentoDAO()) : instance);
    }

    public Tratamento create(int id_animal, String dt_inic, int finalizado) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Tratamento (id_animal,dt_inic,finalizado) VALUES( ?,  ?,  ?)");
            stmt.setInt(1, id_animal);
            stmt.setString(2, dt_inic);
            stmt.setInt(3, finalizado);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Tratamento", "id_trat"));
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            tratamento = new Tratamento(rs.getInt ("id_trat"), rs.getString ("dt_inic"), rs.getString ("dt_fim"), rs.getInt ("id_animal") , rs.getInt ("finalizado"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamento;
    }

    public List retrieve(String query) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamentos;
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM Tratamento");
    }

    public Tratamento retrieveByAnimalId(int id_ani) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM Tratamento WHERE id_animal = " + id_ani);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public Tratamento retrieveById(int id_trat) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM Tratamento WHERE id_trat = " + id_trat);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public void update(Tratamento tratamento) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE Tratamento SET finalizado=?, dt_fim=? WHERE id_trat=?");
            stmt.setObject(1, tratamento.getFinalizado());
            stmt.setString(2, tratamento.getDt_fim());
            stmt.setInt(3, tratamento.getId_trat());

            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}