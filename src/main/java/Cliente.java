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
    
    private String nome;
    private String endereco;
    private String telefone;
    private String cep;
    private String email;
    
    /*
      Incia-se o Contrutor.O construtor é usado para inicializar os atributos
      da classe Cliente com os valores especificados nos argumentos.
    */
    
    public Cliente(String nome, String endereco, String telefone, String cep, String email){//CONSTRUTOR
    this.nome = nome;
    this.endereco = endereco;
    this.telefone = telefone;
    this.cep = cep;
    this.email = email;
    }
    
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getCep(){
        return cep;
    }
    public String getEmail(){
        return email;
    }
  
    public void setEmail(String email){
        if(!email.equals("")){
          this.email = email;
        }
        
    }
    
}

