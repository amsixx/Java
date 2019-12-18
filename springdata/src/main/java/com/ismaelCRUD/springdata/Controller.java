/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ismaelCRUD.springdata;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ismael
 */
@RestController
public class Controller {

    @Autowired
    private ServicePersona servicePersona;

    @RequestMapping("/personas")
    public List<Persona> getAll() {
        return servicePersona.getAll();
    }

    @RequestMapping("/personas/{id}")
    public Persona getOne(@PathVariable int id) {
        return servicePersona.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/personas")
    public void add(@RequestBody Persona p) {
        servicePersona.add(p);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/personas/{id}")
    public void update(@RequestBody Persona p, @PathVariable int id) {
        servicePersona.update(p, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/personas/{id}")
    public void delete(@PathVariable int id) {
        servicePersona.delete(id);
    }
}
