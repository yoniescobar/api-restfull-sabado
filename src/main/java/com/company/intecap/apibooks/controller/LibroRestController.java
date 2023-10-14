package com.company.intecap.apibooks.controller;

import com.company.intecap.apibooks.respose.LibroResponseRest;
import com.company.intecap.apibooks.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // @RequestMapping: prefijo de la ruta de la API REST  http://localhost:8083/api/v1
public class LibroRestController {

    @Autowired // @Autowired: inyecta el servicio de libros para poder utilizarlo en este controlador REST
    private ILibroService libroService; // ILibroService: interface que contiene los metodos para acceder a los datos de la tabla libro de la base de datos (CRUD)

    @GetMapping("/libros") // @GetMapping: indica que este metodo se encarga de recibir las peticiones GET a la ruta /v1/libros
    public ResponseEntity<LibroResponseRest> buscarLibros() { //http://localhost:8083/api/v1/libros
        return libroService.buscarLibros(); // Retornamos la respuesta al cliente
    }

    @GetMapping("/libros/{id}") // @GetMapping: indica que este metodo se encarga de recibir las peticiones GET a la ruta /v1/libros/{id}
    public ResponseEntity<LibroResponseRest> consultarPorId(@PathVariable Long id) {  //  http://localhost:8083/api/v1/libros/1
        return libroService.buscarLibroPorId(id);
    }
}
