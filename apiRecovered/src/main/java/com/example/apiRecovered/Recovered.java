/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiRecovered;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author yo
 */
@Document(collection = "recovereds")
public class Recovered {
    
    @Id
    private String _id;
    
    private int id;
    private String name;
    private String age;

    public Recovered() {
    }

    public Recovered(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String get_id(){
        return _id;
    }
    public void set_id(String id){
        this._id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
       
    
}
