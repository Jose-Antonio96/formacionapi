package com.formacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.formacion.models.Formacion;
import com.formacion.services.FormacionService;

import org.springframework.http.MediaType;

@RestController
public class FormacionController {
    @Autowired
    FormacionService formacionService;
    
    @GetMapping(value="cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formacion> listar(){
        return formacionService.listaCursos();
    } 

    @PostMapping(value="formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevaFormacion(@RequestBody Formacion formacion){
        formacionService.nuevaFormacion(formacion);
    }
}
