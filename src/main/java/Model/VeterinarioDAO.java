/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO;
/**
 *
 * @author a248488
 */
public class VeterinarioDAO extends DAO {
    
    private static VeterinarioDAO instance;

    private VeterinarioDAO() {
        getConnection();
        createTable();
    }
    
    public static VeterinarioDAO getInstance() {
        return (instance == null ? (instance = new VeterinarioDAO()) : instance);
    }
    
    
    public Veterinario create(String nome_vet, String tel_vet, String cidade_vet, String estado_vet, String rua_vet, String bairro_vet) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Veterinario (nome_vet, tel_vet, cidade_vet, estado_vet, rua_vet, bairro_vet) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, nome_vet);
            stmt.setString(2, tel_vet);
            stmt.setString(3, cidade_vet);
            stmt.setString(4, estado_vet);
            stmt.setString(5, rua_vet);
            stmt.setString(6, bairro_vet);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Veterinario", "id_vet"));
    }
    
    
        public boolean isLastEmptys() {
        Veterinario lastVet = this.retrieveById(lastId("Veterinario", "id_vet"));
        if (lastVet != null) {
            return lastVet.getNome_vet().isBlank();
        }
        return false;
    }
    
        private Veterinario buildObject(ResultSet rs) {
        Veterinario veterinario = null;
        try {
            veterinario = new Veterinario(rs.getInt("id_vet"), rs.getString("nome_vet"), rs.getString("tel_vet"),
            rs.getString("cidade_vet"), rs.getString("estado_vet"), rs.getString("rua_vet"), rs.getString("bairro_vet"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinario;
    }

        public List retrieve(String query) {
        List<Veterinario> veterinarios = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                veterinarios.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinarios;
    }

    public Veterinario retrieveById(int id) {
        List<Veterinario> veterinarios = this.retrieve("SELECT * FROM Veterinario WHERE id_vet = " + id);
        return (veterinarios.isEmpty() ? null : veterinarios.get(0));
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM Veterinario");
    }
        
   public void update(Veterinario veterinario) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE Veterinario SET nom_vet=?, tel_vet=?, cidade_vet=?, estado_vet=?,"
                    + "rua_vet=?, bairro_vet=? WHERE id_vet=?");
            stmt.setString(1, veterinario.getNome_vet());
            stmt.setString(2, veterinario.getTel_vet());
            stmt.setString(3, veterinario.getCidade_vet());
            stmt.setString(4, veterinario.getEstado_vet());
            stmt.setString(5, veterinario.getRua_vet());
            stmt.setString(6, veterinario.getBairro_vet());
            stmt.setInt(7, veterinario.getId_vet());

            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
