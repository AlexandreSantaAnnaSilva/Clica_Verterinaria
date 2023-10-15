package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a2484
 */
public class Consulta {
    
    private int id_cons;
    private int id_trat;
    private int id_animal;
    private String dat_con;
    private String sintomas;

    public Consulta(int id_cons, int id_trat, int id_animal, String dat_con, String sintomas) {
        this.id_cons = id_cons;
        this.id_trat = id_trat;
        this.dat_con = dat_con;
        this.sintomas = sintomas;
        this.id_animal = id_animal;
    }

    public String getSintomas() {
        return sintomas;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public int getId_cons() {
        return id_cons;
    }
    
    public int getId_trat() {
        return id_trat;
    }

    public String getDat_con() {
        return dat_con;
    }

    public void setDat_con(String dat_con) {
        this.dat_con = dat_con;
    }
    
}

