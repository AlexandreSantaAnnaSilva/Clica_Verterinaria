
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
    private String nome;
    private Calendar dtInicio;
    private Calendar dtFim;
    private int idAnimal;
    private boolean terminou;
    
    public Tratamento(String nome, Calendar dtIncio, Calendar dtFim, int idAnimal , boolean terminou){
            this.nome = nome;
            this.dtInicio = dtIncio;
            this.dtFim = dtFim;
            this.idAnimal = idAnimal;
            this.terminou = terminou;
    }   
   


    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
         this.nome = nome;
    }

    public Calendar getDtInicio(){
        return dtInicio;
    }
    
    public void setDtInicio (Calendar dtIncio){
        this.dtInicio = dtInicio;
    }
    
    
    public Calendar getDtFim(){
        return dtFim;
    }   
    
    public void setDtFim( Calendar dtFim){
        this.dtFim = dtFim;
    }
    
    public int getIdAnimal(){
        return idAnimal;
    }
    
    public void setIdAniaml(int idAnimal){
        this.idAnimal = idAnimal;
    }
    
    public boolean getTerminou(){
        return terminou;
    }

   public void setTerminou( boolean terminou){
       this.terminou = terminou;
   }
}
