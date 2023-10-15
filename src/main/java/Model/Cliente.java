package Model;


import Model.Animal;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.clinica_veterinaria.Clinica_veterinaria;
/**
 *
 * @author a2484
 */
public class Cliente {
    
    private int id_cli;
    private String nome_cli;
    private String endereco_cli;
    private String telefone_cli;
    private String cep_cli;
    private String email_cli;
    
    //private List<Animal> animais;
    
    /*
      Incia-se o Contrutor.O construtor é usado para inicializar os atributos
      da classe Cliente com os valores especificados nos argumentos.
    */
    
    public Cliente(int id_cli,String nome_cli, String endereco_cli, String telefone_cli, String cep_cli, String email_cli){//CONSTRUTOR
    
    this.id_cli = id_cli;
    this.nome_cli = nome_cli;
    this.endereco_cli = endereco_cli;
    this.telefone_cli = telefone_cli;
    this.cep_cli = cep_cli;
    this.email_cli = email_cli;
    //this.animais = new ArrayList<Animal>();
    }
    
    public int getId_cli(){
        return id_cli;
    }
    
    public String getNome_cli(){
        return nome_cli;
    }
    
    public void setNom_clie(String nome_cli){
        this.nome_cli = nome_cli;
    }
    
    public String getEndereco_cli(){
        return endereco_cli;
    }
    
    public void setEndereco_cli(String enderco_cli){
        this.endereco_cli = endereco_cli;
    }
    
    public String getTelefone_cli(){
        return telefone_cli;
    }
    
    public void setTelefone_cli(String telefone_cli){
        this.telefone_cli = telefone_cli;
    }
    
    public String getCep_cli(){
        return cep_cli;
    }
    public String getEmail_cli(){
        return email_cli;
    }
  
    public void setEmail_cli(String email_cli){
          this.email_cli = email_cli;
        }
        
    }

/*
    public void addAnimal(Animal animal){
        if(!animal.getNome().isBlank()){
        animais.add(animal);
        }
    }
    
    public List<Animal> getAnimais(){
        List<Animal> copia = new ArrayList<Animal>(animais);
        return copia;
    }
    
    
    
    //SOBRE-ESCREVENDO O METODO toString
    @Override
    public String toString(){
        String desc = "Cliente{"+ "nome=" + nome +", endereco=" + endereco + ", telefone=" + telefone + ", cep=" +  cep +   ", email=" + email+ '}';
        String strAnimais = animais.toString();
        return desc + "\n" + strAnimais;
    }

*/

