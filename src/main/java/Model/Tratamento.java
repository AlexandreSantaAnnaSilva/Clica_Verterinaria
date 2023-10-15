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
    private Calendar dt_inic;
    private Calendar dt_fim;
    private int id_animal;
    private boolean finalizado;
    
    public Tratamento(Calendar dt_inic, Calendar dt_fim, int id_animal , boolean finalizado){
            this.dt_inic = dt_inic;
            this.dt_fim = dt_fim;
            this.id_animal = id_animal;
            this.finalizado = finalizado;
    }   
   

    public Calendar getDt_inic(){
        return dt_inic;
    }
    
    public void setDt_inic (Calendar dt_inic){
        this.dt_inic = dt_inic;
    }
    
    
    public Calendar getDt_fim(){
        return dt_fim;
    }   
    
    public void setDtFim( Calendar dt_fim){
        this.dt_fim = dt_fim;
    }
    
    public int getId_animal(){
        return id_animal;
    }
    
    public void setId_animal(int id_animal){
        this.id_animal = id_animal;
    }
    
    public boolean getFinalizou(){
        return finalizado;
    }

   public void setFinalizou( boolean finalizado){
       this.finalizado = finalizado;
   }
}
