package com.marketclub.clients.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
@Table(name="CLIENTS")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Registered names column
    @Column(name="NAME")
    private String name;

    // Registered cpf column
    @Column(name="CPF")
    private String cpf;

    // Registered client level column (Bronze, Silver, Gold)
    @Column(name="ACCOUNT_LEVEL")
    private String accountLevel;

    // Getter Method - get id
    public Long getId(){
        return this.id;
    }
    // Setter Method - set id
    public void setId(Long id){
        this.id = id;
    }

    // Getter Method - get name
    public String getName(){
        return this.name;
    }
    // Setter Method - set name
    public void setName(String name){
        this.name = name;
    }

    // Getter Method - get cpf
    public String getCpf(){
        return this.cpf;
    }
    // Setter Method - set cpf
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    // Getter Method - get account
    public String getAccountLevel(){
        return this.accountLevel;
    }
    // Setter Method - set account
    public void setAccountLevel(String accountLevel){
        this.accountLevel = accountLevel;
    }




}