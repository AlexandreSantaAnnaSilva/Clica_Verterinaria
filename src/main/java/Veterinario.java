/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a2484
 */
public class Veterinario {
    private String nome;
    private String email;
    private String telefone;
    
    
    
    public Veterinario(String nome, String email, String telefone){
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    
    public String getEmail(){
        return email;
    }
    

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }


}
