/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author a2484
 */

public class Exame {
    
    private int id_exam;
    private int id_cons;
    private String des_exame;
    private String res_exame;

    public Exame(int id_exam, int id_cons, String des_exame, String res_exame) {
        this.id_exam = id_exam;
        this.id_cons = id_cons;
        this.des_exame = des_exame;
        this.res_exame = res_exame;
    }

    public int getId_exam() {
        return id_exam;
    }
    
    public int getId_cons(){
        return id_cons;
    }

    public String getDes_exame() {
        return des_exame;
    }

    public void setDes_exame(String des_exame) {
        this.des_exame = des_exame;
    }

    public String getRes_exame() {
        return res_exame;
    }

    public void setRes_exame(String res_exame) {
        this.res_exame = res_exame;
    }
    
}