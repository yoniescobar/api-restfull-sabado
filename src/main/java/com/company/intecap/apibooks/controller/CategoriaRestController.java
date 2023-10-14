package com.company.intecap.apibooks.controller;

import com.company.intecap.apibooks.respose.CategoriaResponseRest;
import com.company.intecap.apibooks.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1") // prefijo de la ruta  http://localhost:8080/api/v1
public class CategoriaRestController {

    @Autowired // Inyectamos el servicio de categorias para poder utilizarlo en este controlador REST
    private ICategoriaService categoriaService;

    @GetMapping("/categorias") // Indica que este metodo se encarga de recibir las peticiones GET a la ruta /v1/categorias
    public ResponseEntity<CategoriaResponseRest> consultarCategorias(){
        return categoriaService.buscarCategorias(); // Invocamos el metodo buscarCategorias del servicio de categorias para obtener las info de la base de datos
    }

    @GetMapping("/categorias/{id}") // Indica que este metodo se encarga de recibir las peticiones GET a la ruta /v1/categorias/{id}
    public ResponseEntity<CategoriaResponseRest> consultarCategoriaId(@PathVariable  Long id){
        return categoriaService.buscarCategoriaId(id); // Invocamos el metodo buscarCategoriaId del servicio de categorias para obtener la info de la base de datos
    }

}
