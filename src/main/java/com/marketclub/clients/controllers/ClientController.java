package com.marketclub.clients.controllers;

import com.marketclub.clients.repositories.ClientRepository;
import com.marketclub.clients.repositories.AccountLevelRepository;
import com.marketclub.clients.entities.Client;
import com.marketclub.clients.entities.AccountLevel;

import java.lang.Iterable;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping(path="/marketclub")
public class ClientController{

    private ClientRepository clientRepository;
    private AccountLevelRepository accountLevelRepository;

    public ClientController(ClientRepository clientRepository, AccountLevelRepository accountLevelRepository){
        this.accountLevelRepository = accountLevelRepository;
        this.clientRepository = clientRepository;
    }
    
    // Get all comands
    @GetMapping(path="/comands")
    public ArrayList<String> allComands(){
        ArrayList<String> allComands = new ArrayList<>();
        allComands.add("localhost:8080/marketclub/comands - To see the available comands.");
        allComands.add("localhost:8080/marketclub/clients - Command to view all registered clients.");
        allComands.add("localhost:8080/marketclub/clients/(accountLevel) - Command to view registered clients by account level.");
        allComands.add("localhost:8080/marketclub/clients/(cpf) - Command to view registered client by cpf.");
        allComands.add("localhost:8080/marketclub/accountlevel/discounts - Command to view all registered account levels.");
        allComands.add("localhost:8080/marketclub/accountlevel/(gold, silver or bronze) - Command to see the discount for an account level.");

        return allComands;
    }

    // get all clients
    @GetMapping(path="/clients")
    public Iterable<Client> allClients(){
        return this.clientRepository.findAll();
    }
  
    // Add new client
    @PostMapping(path="/clients")
    public Client addNewClient(@RequestBody Client client){
        client.setAccountLevel("localhost:8080/marketclub/accountlevel/"+client.getAccountLevel().toLowerCase());
        Client newClient = this.clientRepository.save(client);
        
        return newClient;
    }

    // Delete client
    @DeleteMapping(path="/clients")
    public Client deleteClient(@PathVariable String cpf){
        Optional<Client> optionalCpf = this.clientRepository.getClientByCpf(cpf);

        if(!optionalCpf.isPresent()){
            return null;
        }

        Client cpfToDelete = optionalCpf.get();
        this.clientRepository.delete(cpfToDelete);
        return cpfToDelete;
    }

    // Get discount per account level
    @GetMapping(path="/accountlevel/discounts")
    public Iterable<AccountLevel> allAccountLevel(){
        return this.accountLevelRepository.findAll();
    }

    // Get account level per level (BRONZE, SILVER or GOLD)
    @GetMapping(path="/accountlevel/{level}")
    public AccountLevel getAccountLevel(@PathVariable("level") String level){
        Optional<AccountLevel> optionalAccountLevel = this.accountLevelRepository.findLevelByLevel(level.toUpperCase());

        if(!optionalAccountLevel.isPresent()){
            return null;
        }
        AccountLevel foundAccountLevel = optionalAccountLevel.get();
        return foundAccountLevel;
        
    }

    // Get client by account level (BRONZE, SILVER or GOLD)
    @GetMapping(path="/clients/{accountlevel}")
    public Iterable<Client> clientByAccountLevel(@PathVariable("accountlevel") String accountLevel){
        return this.clientRepository.getListByAccountLevel("localhost:8080/marketclub/accountlevel/"+accountLevel.toLowerCase());
    }

    // Get client by cpf
    @GetMapping(path="/client/{cpf}")
    public Client clientByCpf(@PathVariable("cpf") String cpf){
        Optional<Client> optionalCpf = this.clientRepository.getClientByCpf(cpf);

        if(!optionalCpf.isPresent()){
            return null;
        }

        Client foundCpf = optionalCpf.get();
        return foundCpf;
    }

    // Update client
    @PutMapping(path="/client/update/{cpf}")
    public Client updateClientByCpf(
        @RequestBody Client updateClient,
        @PathVariable String cpf){
            Optional<Client> optionalClient = this.clientRepository.getClientByCpf(cpf);

            if(!optionalClient.isPresent()){
                return null;
            }

            Client clientToUpdate = optionalClient.get();

            if(updateClient.getName()!=null){
                clientToUpdate.setName(updateClient.getName());
            }
            if(updateClient.getCpf()!=null){
                clientToUpdate.setCpf(updateClient.getCpf());
            }
            if(updateClient.getAccountLevel()!=null){
                if(updateClient.getAccountLevel().toUpperCase() == "GOLD"){
                    clientToUpdate.setAccountLevel("localhost:8080/marketclub/accountlevel/gold");
                }
                if(updateClient.getAccountLevel().toUpperCase() == "SILVER"){
                    clientToUpdate.setAccountLevel("localhost:8080/marketclub/accountlevel/silver");
                }
                if(updateClient.getAccountLevel().toUpperCase() == "BRONZE"){
                    clientToUpdate.setAccountLevel("localhost:8080/marketclub/accounstlevel/bronze");
                }
            }


            Client updatedClient = this.clientRepository.save(clientToUpdate);
            return updatedClient;

    }

    
}
