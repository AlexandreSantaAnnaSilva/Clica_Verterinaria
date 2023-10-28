package Model;


import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a2484
 */
public class Tratamento {
    private int id_trat;
    private String dt_inic;
    private String dt_fim;
    private int id_animal;
    private int finalizado;
    
    public Tratamento(int id_trat ,String dt_inic, String dt_fim, int id_animal , int finalizado){
            this.id_trat = id_trat;
            this.dt_inic = dt_inic;
            this.dt_fim = dt_fim;
            this.id_animal = id_animal;
            this.finalizado = finalizado;
    }   
   

    public String getDt_inic(){
        return dt_inic;
    }
    
    public void setDt_inic (String dt_inic){
        this.dt_inic = dt_inic;
    }
    
    
    public String getDt_fim(){
        return dt_fim;
    }   
    
    public void setDt_fim( String dt_fim){
        this.dt_fim = dt_fim;
    }
    
    public int getId_animal(){
        return id_animal;
    }
    
    public void setId_animal(int id_animal){
        this.id_animal = id_animal;
    }
    
    public int getFinalizado(){
        return finalizado;
    }

   public void setFinalizado( int finalizado){
       this.finalizado = finalizado;
   }
   
       public int getId_trat() {
        return id_trat;
    }
}
