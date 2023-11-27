package com.marketclub.clients.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
@Table(name="ACCOUNT_LEVEL")
public class AccountLevel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Level client column
    @Column(name="LEVEL")
    private String level;

    // Dairy descount column
    @Column(name="DAIRY")
    private String dairy;

    // Meats descount column
    @Column(name="MEATS")
    private String meats;

    // Fruits and Vegetables descount column
    @Column(name="FRUITS_AND_VEGETABLES")
    private String fruitsAndVegetables;

    // Cleaning Products descount column
    @Column(name="CLEANING_PRODUCTS")
    private String cleaningProducts;

    // Personal Hygiene descount column
    @Column(name="PERSONAL_HYGIENE")
    private String personalHygiene;

    // Getter Method - get id
    public Integer getId(){
        return this.id;
    }
    // Setter Method - set id
    public void setId(Integer id){
        this.id = id;
    }

    // Getter Method - get level
    public String getLevel(){
        return this.level;
    }
    // Setter Method - set level
    public void setLevel(String level){
        this.level = level;
    }

    // Getter Method - get dairy
    public String getDairy(){
        return this.dairy;
    }
    // Setter Method - set dairy
    public void setDairy(String dairy){
        this.dairy = dairy;
    }

    // Getter Method - get meats
    public String getMeats(){
        return this.meats;
    }
    // Setter Method - set meats
    public void setmeats(String meats){
        this.meats = meats;
    }

    // Getter Method - get fruitsAndVegetables
    public String getFruitsAndVegetables(){
        return this.fruitsAndVegetables;
    }
    // Setter Method - set fruitsAndVegetables
    public void setFruitsAndVegetables(String fruitsAndVegetables){
        this.fruitsAndVegetables = fruitsAndVegetables;
    }

    // Getter Method - get cleaningProducts
    public String getCleaningProducts(){
        return this.cleaningProducts;
    }
    // Setter Method - set cleaningProducts
    public void setCleaningProducts(String cleaningProducts){
        this.cleaningProducts = cleaningProducts;
    }

    // Getter Method - get personalHygiene
    public String getPersonalHygiene(){
        return this.personalHygiene;
    }
    // Setter Method - set personalHygiene
    public void setPersonalHygiene(String personalHygiene){
        this.personalHygiene = personalHygiene;
    }
}
