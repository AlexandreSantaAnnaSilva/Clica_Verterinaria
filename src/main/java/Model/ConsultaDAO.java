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
public class ConsultaDAO extends DAO {
    
    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }
    
    public static ConsultaDAO getInstance() {
        return (instance == null ? (instance = new ConsultaDAO()) : instance);
    }
    
        public Consulta create(int id_trat, int id_vet, String sintomas, String dat_con, int id_animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Consulta (id_trat, id_vet, dat_con, sintomas, id_animal) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, id_trat);
            stmt.setInt(2, id_vet);
            stmt.setString(3, dat_con);
            stmt.setString(4, sintomas);
            stmt.setInt(5, id_animal);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Consulta", "id_cons"));
    }
        
        private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            consulta = new Consulta(rs.getInt("id_cons"), rs.getInt("id_trat"), rs.getInt("id_animal"), rs.getString("dat_con"), rs.getString("sintomas"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }
        
        public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
        
        public List retrieveAll() {
        return this.retrieve("SELECT * FROM Consulta");
    }
        
        
        public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM Consulta WHERE id_cons = " + id);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }
       
        public List retrieveByTratId(int id_trat) {
        return this.retrieve("SELECT * FROM Consulta WHERE id_trat = " + id_trat);
    }

    public List retrieveByAnimalId(int id_animal) {
        return this.retrieve("SELECT * FROM Consulta WHERE id_animal = " + id_animal);
    }

    public List retrieveByVetId(int id_vet) {
        return this.retrieve("SELECT * FROM Consulta WHERE id_vet = " + id_vet);

    }

    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE Consulta SET dat_con=?, sintomas=? WHERE id_cons=?");
            stmt.setObject(1, consulta.getDat_con());
            stmt.setString(2, consulta.getSintomas());
            stmt.setInt(3, consulta.getId_cons());

            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }    
}
