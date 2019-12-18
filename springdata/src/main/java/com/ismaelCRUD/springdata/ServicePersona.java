/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ismaelCRUD.springdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ismael
 */
@Service
public class ServicePersona {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    
    public List<Persona> getAll(){
        List<Persona> personas = new ArrayList<>();
        personaRepository.findAll().forEach(personas :: add);
        return personas;
    }
    
        public Persona getOne (int id){
            return personaRepository.findById(id).get();
    }
        
        public void add(Persona p){
            personaRepository.save(p);
        }
        
        public void update(Persona p, int id){
            personaRepository.save(p);
        }
        
        public void delete(int id){
            personaRepository.deleteById(id);
        }
}

