/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTextPane;
import Model.Animal;
import Model.AnimalDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.ConsultaDAO;
import Model.Tratamento;
import Model.Veterinario;
import Model.VeterinarioDAO;
import Model.Consulta;
import Model.ExameDAO;
import Model.TratamentoDAO;

/**
 *
 * @author a2484
 */
public class Controller {
    private static Cliente selectedClient = null;
    private static Animal selectedAnimal = null;
    private static Veterinario selectedVeterinario = null;
    private static Tratamento selectedTratamento = null;
    private static Consulta selectedConsulta = null;

    private static JTextPane selectedClientTP = null;
    private static JTextPane selectedAnimalTP = null;
    private static JTextPane selectedIdadeAnimalTP = null;
    private static JTextPane selectedVeterinarioTP = null;
    
    private static JTextPane selectedDataConsTP = null;
    private static JTextPane selectedAnimalConsTP = null;
    private static JTextPane selectedSintomasConsTP = null;

    public static void setSelectedTextFields(JTextPane cliente, JTextPane animal, JTextPane idadeAnimal, JTextPane veterinario) {
        selectedClientTP = cliente;
        selectedAnimalTP = animal;
        selectedIdadeAnimalTP = idadeAnimal;
        selectedVeterinarioTP = veterinario;
    }
    
    public static void setSelectedTextFieldsConsulta(JTextPane data, JTextPane animal, JTextPane sintomas){
        selectedDataConsTP = data;
        selectedAnimalConsTP = animal;
        selectedSintomasConsTP = sintomas;
    }

    public static List getAllClients() {
        return ClienteDAO.getInstance().retrieveAll();
    }

    public static List getAllVeterinarios() {
        return VeterinarioDAO.getInstance().retrieveAll();
    }

    public static List getAllAnimals() {
        return AnimalDAO.getInstance().retrieveAll();
    }

    public static List getAllConsults() {
        return ConsultaDAO.getInstance().retrieveAll();
    }

    public static List getAllTratamentos() {
        return TratamentoDAO.getInstance().retrieveAll();
    }
    
    public static List getAllExames() {
        return ExameDAO.getInstance().retrieveAll();
    }
    
    public static List getExamesByConsultId(int id_cons){
        return ExameDAO.getInstance().retrieveByConsultId(id_cons);
    }

    public static List getAnimalsByClienteId(int id_cli) {
        return AnimalDAO.getInstance().retrieveByClienteId(id_cli);
    }

    public static List getConsultsByAnimalId(int id_animal) {
        return ConsultaDAO.getInstance().retrieveByAnimalId(id_animal);
    }
    
    public static List getConsultsByTratId(int id_trat){
        return ConsultaDAO.getInstance().retrieveByTratId(id_trat);
    }
    
    public static List getConsultsByVetId(int id_vet){
        return ConsultaDAO.getInstance().retrieveByVetId(id_vet);
    }

    public static void addCliente(String nome, String email, String cidade, String estado, String rua, String bairro, String cep) {;
        ClienteDAO.getInstance().create(nome, email, cidade, estado, rua, bairro, cep);
    }

    public static void addVeterinario(String nome, String telefone, String cidade, String estado, String rua, String bairro) {
        VeterinarioDAO.getInstance().create(nome, telefone, cidade, estado, rua, bairro);
    }

    public static void addAnimal(String nome, int idade, int sexo) {
        AnimalDAO.getInstance().create(selectedClient.getId_cli(), 1, nome, idade, sexo);
    }

    public static void addConsulta(String sintomas, int finalizado) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());

        setSelectedTratamentoByAnimalId(finalizado);
        ConsultaDAO.getInstance().create(selectedTratamento.getId_trat(), selectedVeterinario.getId_vet(), sintomas, date, selectedAnimal.getId_ani());
    }
    
    public static void addExame(String descricao, String resultado){
        ExameDAO.getInstance().create(selectedConsulta.getId_cons(), descricao, resultado);
    }

    public static void setSelectedCliente(Cliente cliente) {
        selectedClient = cliente;
        selectedClientTP.setText(cliente.getNome_cli());
    }

    public static void setSelectedAnimal(Animal animal) {
        selectedAnimal = animal;
        selectedAnimalTP.setText(animal.getNome_ani());
        selectedIdadeAnimalTP.setText(String.valueOf(animal.getIdade_ani()));

        setSelectedTratamentoByAnimalId(0);
    }

    public static void setSelectedTratamento(Tratamento tratamento) {
        selectedTratamento = tratamento;
    }

    public static void setSelectedTratamentoByAnimalId(int finalizado) {
        Tratamento tratamentos = TratamentoDAO.getInstance().retrieveByAnimalId(selectedAnimal.getId_ani());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());

        if (tratamentos == null) {
            tratamentos = TratamentoDAO.getInstance().create(selectedAnimal.getId_ani(), date, finalizado);
        }else{
            tratamentos.setFinalizado(finalizado);
            System.out.println(finalizado);
            if(finalizado == 1){
                tratamentos.setDt_fim(date);
            }
            TratamentoDAO.getInstance().update(tratamentos);
        }

        selectedTratamento = tratamentos;
    }

    public static void setSelectedVeterinario(Veterinario veterinario) {
        selectedVeterinario = veterinario;
        selectedVeterinarioTP.setText(veterinario.getNome_vet());
    }
    
    public static void setSelectedConsulta(Consulta consulta){
        selectedConsulta = consulta;
        
        Animal animal = AnimalDAO.getInstance().retrieveById(consulta.getId_animal());
        
        selectedDataConsTP.setText(consulta.getDat_con()) ;
        selectedSintomasConsTP.setText(consulta.getSintomas()) ;
        
        if(animal != null){
            selectedAnimalConsTP.setText(animal.getNome_ani());
        }
    }

    public static Cliente getSelectedClient() {
        return selectedClient;
    }

    public static Animal getSelectedAnimal() {
        return selectedAnimal;
    }

    public static Veterinario getSelectedVeterinario() {
        return selectedVeterinario;
    }

    public static Tratamento getSelectedTratamento() {
        return selectedTratamento;
    }
    
    public static Consulta getSelectedConsulta() {
        return selectedConsulta;
    }
}
