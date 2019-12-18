/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ismaelCRUD.springdata;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ismael
 */
public interface PersonaRepository extends CrudRepository<Persona,Integer> {
    
}
