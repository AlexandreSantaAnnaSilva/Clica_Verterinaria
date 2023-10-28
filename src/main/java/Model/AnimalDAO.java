/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import model.DAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a2484
 */
public class AnimalDAO extends DAO {
    
 private static AnimalDAO instance;

    private AnimalDAO() {
        getConnection();
        createTable();
    }

    public static AnimalDAO getInstance() {
        return (instance == null ? (instance = new AnimalDAO()) : instance);
    }


public Animal create(int id_cli, int id_esp, String nome_animal, int idade_animal, int sexo_animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Animal (id_cli, id_esp, nome_animal, idade_animal, sexo_animal) VALUES (?,?,?,?,?)");
            stmt.setInt(1, id_cli);
            stmt.setInt(2, id_esp);
            stmt.setString(3, nome_animal);
            stmt.setInt(4, idade_animal);
            stmt.setInt(5, sexo_animal);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Animal", "id_ani"));
    }

    public boolean isLastEmpty() {
        Animal lastAnimal = this.retrieveById(lastId("Animal", "id_ani"));
        if (lastAnimal != null) {
            return lastAnimal.getNome_ani().isBlank();
        }
        return false;
    }

 private Animal buildObject(ResultSet rs) {
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("id_ani"), rs.getInt("id_cli"), rs.getInt("id_esp"), rs.getString("nome_animal"), rs.getInt("idade_animal"), rs.getInt("sexo_animal"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
            
    public List retrieve(String query) {
        List<Animal> animais = new ArrayList();
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

    public Animal retrieveById(int id) {
        List<Animal> animais = this.retrieve("SELECT * FROM Animal WHERE id_ani = " + id);
        return (animais.isEmpty() ? null : animais.get(0));
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM Animal");
    }
    
    public List retrieveByClienteId(int id_cli){
        return this.retrieve("SELECT * FROM Animal WHERE id_cli = " + id_cli);
    }

    public void update(Animal animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE Animal SET nome_animal=?, idade_animal=?, sexo_animal=?, id_esp=?"
                    + " WHERE id_ani=?");
            stmt.setString(1, animal.getNome_ani());
            stmt.setInt(2, animal.getIdade_ani());
            stmt.setInt(3, animal.getSexo_ani());
            stmt.setInt(4, animal.getEsp_id());
            stmt.setInt(5, animal.getId_ani());

            executeUpdate(stmt);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());

        }
    }        
            
}
