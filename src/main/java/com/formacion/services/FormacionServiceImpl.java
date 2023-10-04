package com.formacion.services;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import com.formacion.models.Formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacion.models.Curso;

/**
 * Funciones que el controlador va a llamar para que la api formacion se conecte con la api cursos, implementando desde el FormacionService
 */
@Service
public class FormacionServiceImpl implements FormacionService {

    @Autowired
    RestTemplate template;

    private String url = "http://localhost:8080/";

    /**
     * Obtiene una lista de formaciones (cursos) disponibles.
      * @return Lista de formaciones.
      */
    @Override
    public List<Formacion> listaCursos() {
        List<Formacion> listaFormacion = new ArrayList<>();

        ResponseEntity<Curso[]> response = template.exchange(url + "cursos", HttpMethod.GET, null,
                Curso[].class);
        List<Curso> listaCurso = Arrays.asList(response.getBody());

        for (Curso curso : listaCurso) {
            Formacion formacion = new Formacion();
            formacion.setCurso(curso.getNombre());
            formacion.setAsignaturas(curso.getDuracion() >= 50? 10:5);
            formacion.setPrecio(curso.getPrecio());
            listaFormacion.add(formacion);
        }

        return listaFormacion;
    }

    /**
     * Agrega una nueva formación (curso).
      * @param formacion La formación a agregar.
      */
    @Override
    public void nuevaFormacion(Formacion formacion) {
        boolean existe = false;
                ResponseEntity<Curso[]> response = template.exchange(url + "cursos", HttpMethod.GET, null,
                Curso[].class);
        List<Curso> listaCurso = Arrays.asList(response.getBody());

        for (Curso curso : listaCurso) {
            if(curso.getNombre().equals(formacion.getCurso())){
                existe = true;
            }
        }
            if(!existe){
                template.postForLocation(url + "curso", new Curso(0, formacion.getCurso(), formacion.getAsignaturas()*10, formacion.getPrecio()));
                
            }


    }

}
