/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiRecovered;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yo
 */
@CrossOrigin(origins = "*" )
@RestController
//@RequestMapping("/api")
public class ControladorRecovered {
    @Autowired
    RecoveredRepository repository;
    
   
    
    @GetMapping("/recovered")
    public ResponseEntity<List<Recovered>> getRecovereds() {
        try {
            List<Recovered> recovereds = new ArrayList<Recovered>();
            repository.findAll().forEach(recovereds::add);
            if (recovereds.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Recovered>>(recovereds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/recovered")
    public ResponseEntity<Recovered> addRecovered(@RequestBody Recovered recovered) {
        try {
            Recovered _recovered = repository.save(new Recovered(recovered.getId(), recovered.getName(), recovered.getAge()));
            return new ResponseEntity<>(_recovered, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recovered/{id}")
    public ResponseEntity<Recovered> getRecoveredById(@PathVariable("id") String id) {
        Optional<Recovered> recoveredData = repository.findById(id);

        if (recoveredData.isPresent()) {
            return new ResponseEntity<>(recoveredData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/recovered/{id}")
    public ResponseEntity<Recovered> updateRecovered(@PathVariable("id") String id, @RequestBody Recovered recovered) {
        Optional<Recovered> recoveredData = repository.findById(id);
        System.out.println(id);
        if (recoveredData.isPresent()) {
            Recovered _recovered = recoveredData.get();
            _recovered.setName(recovered.getName());
            _recovered.setAge(recovered.getAge());
            _recovered.setId(recovered.getId());
            return new ResponseEntity<>(repository.save(_recovered), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/recovered/{id}")
    public ResponseEntity<HttpStatus> deleteRecovered(@PathVariable("id") String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
