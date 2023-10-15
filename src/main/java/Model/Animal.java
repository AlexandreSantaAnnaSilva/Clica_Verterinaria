package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a2484
 */
public class Animal {
    private int id_ani;
    private int id_cli;
    private int id_esp;
    private String nome_ani;
    private int idade_ani;
    private int sexo_ani; //0 = macho , 1 = femea
    
    
    public Animal(int id_ani , int id_cli , int id_esp , String nome_ani, int idade_ani , int sexo_ani){
        this.id_ani = id_ani;
        this.id_cli = id_cli;
        this.id_esp = id_esp;
        this.nome_ani = nome_ani;
        this.idade_ani = idade_ani;
        this.sexo_ani = sexo_ani;
    }

    
    public int getId_ani(){ // NAO PODERA SER ALTERADO , POR ISSO A AUSENCIA DO SETTER;
        return id_ani;
    }
    
    public void setId_ani(int id_ani){
        this.id_ani = id_ani;
    }
    
    public String getNome_ani(){
        return nome_ani;
    }
    
    public void setNome_ani(String nome_ani){
        this.nome_ani = nome_ani;
    }

    public int getIdade_ani(){
        return idade_ani;
    }
    
    public void setIdade_ani(int idade_ani){
    
        this.idade_ani = idade_ani;
    }
    
    public int getSexo_ani(){
    
        return sexo_ani;
    }
    
    
    public void setSexo_ani(int sexo_ani){
    
        this.sexo_ani = sexo_ani;
    }

}
