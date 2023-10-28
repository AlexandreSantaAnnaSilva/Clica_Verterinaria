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
 * @author a2484
 */
public class EspecieDAO extends DAO {
    
    private static EspecieDAO instance;

    private EspecieDAO() {
        getConnection();
        createTable();
    }

    
     public static EspecieDAO getInstance() {
        return (instance == null ? (instance = new EspecieDAO()) : instance);
    }

        public Especie create(String nome_esp) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Especie (nome_esp) VALUES (?)");
            stmt.setString(1, nome_esp);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Especie", "id_esp"));
    }
    
        public boolean isLastEmpty() {
            Especie lastAnimal = this.retrieveById(lastId("Especie", "id_esp"));
             if (lastAnimal != null) {
                return lastAnimal.getNome_esp().isBlank();
        }
        return false;
    }
       private Especie buildObject(ResultSet rs) {
            Especie especie = null;
            try {
                especie = new Especie(rs.getInt("id_esp"), rs.getString("nome_esp"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return especie;
    }
    
       
        public List retrieve(String query) {
            List<Especie> animais = new ArrayList();
            ResultSet rs = getResultSet(query);
            try {
                while (rs.next()) {
                    animais.add(buildObject(rs));
                }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animais;
    }
        
        public Especie retrieveById(int id) {
            List<Especie> animais = this.retrieve("SELECT * FROM Especie WHERE id_esp = " + id);
        return (animais.isEmpty() ? null : animais.get(0));
    }

        public Especie retrieveByName(String name) {
            List<Especie> animais = this.retrieve("SELECT * FROM Especie WHERE nome_esp LIKE '%" + name + "%'");
        return (animais.isEmpty() ? null : animais.get(0));
    }
        
        
}
