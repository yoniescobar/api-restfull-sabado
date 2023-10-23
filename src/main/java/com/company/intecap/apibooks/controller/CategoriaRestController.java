package com.company.intecap.apibooks.controller;

import com.company.intecap.apibooks.model.Categoria;
import com.company.intecap.apibooks.respose.CategoriaResponseRest;
import com.company.intecap.apibooks.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1") // prefijo de la ruta  http://localhost:8080/api/v1
public class CategoriaRestController {

    @Autowired // Inyectamos el servicio de categorias para poder utilizarlo en este controlador REST
    private ICategoriaService categoriaService;

    @GetMapping("/categorias") // localhost:8080/api/v1/categorias
    public ResponseEntity<CategoriaResponseRest> consultarCategorias(){
        return categoriaService.buscarCategorias(); // Invocamos el metodo buscarCategorias del servicio de categorias para obtener las info de la base de datos
    }

    @GetMapping("/categorias/{id}") // Indica que este metodo se encarga de recibir las peticiones GET a la ruta /v1/categorias/{id}
    public ResponseEntity<CategoriaResponseRest> consultarCategoriaId(@PathVariable  Long id){
        return categoriaService.buscarCategoriaId(id); // Invocamos el metodo buscarCategoriaId del servicio de categorias para obtener la info de la base de datos
    }

    @PostMapping("/categorias") // Indica que este metodo se encarga de recibir las peticiones POST a la ruta /v1/categorias
    public ResponseEntity<CategoriaResponseRest> guardarCategoria(@RequestBody Categoria request){
        return categoriaService.crear(request); // Invocamos el metodo crear del servicio de categorias para guardar la info en la base de datos
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> actualizarCategoria(@RequestBody Categoria request, @PathVariable Long id) {
        return categoriaService.actualizar(request, id);

    }

}
