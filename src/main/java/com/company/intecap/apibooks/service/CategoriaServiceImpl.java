package com.company.intecap.apibooks.service;

import com.company.intecap.apibooks.model.Categoria;
import com.company.intecap.apibooks.model.dao.ICategoriaDao;
import com.company.intecap.apibooks.respose.CategoriaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private static final Logger log = Logger.getLogger(CategoriaServiceImpl.class.getName());

    @Autowired //Inyeccion de dependencias
    private ICategoriaDao categoriaDao; //Instancia de la interface ICategoriaDao Jpa

    @Override
    @Transactional(readOnly = true) //Metodo para buscar todas las categorias de la base de datos
    public ResponseEntity<CategoriaResponseRest> buscarCategorias() {
        log.info("Inicio metodo buscarCategorias()");

        CategoriaResponseRest response = new CategoriaResponseRest();

        try {
            List<Categoria> listaCategorias = (List<Categoria>) categoriaDao.findAll();
            response.getCategoriaResponse().setCategorias(listaCategorias);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");

        } catch (Exception e) {
            log.info("Error al consultar categorias: " + e.getMessage());
            e.getStackTrace();
            response.setMetadata("Respuesta no ok", "500", "Error al consultar categorias");
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Retorna un error 500
        }

        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK); //Retorna un error 200
    }

    @Override
    @Transactional(readOnly = true) //Metodo para buscar una categoria por su id
    public ResponseEntity<CategoriaResponseRest> buscarCategoriaId(Long id) {
        log.info("Inicio metodo buscarCategoriaId()");

        CategoriaResponseRest response = new CategoriaResponseRest();
        List<Categoria> listaCategorias = new ArrayList<>();

        try {
            Optional<Categoria> categoria = categoriaDao.findById(id);

            if (categoria.isPresent()) {
                listaCategorias.add(categoria.get());
                response.getCategoriaResponse().setCategorias(listaCategorias);
                response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
            } else {
                response.setMetadata("Respuesta no ok", "404", "Categoria no encontrada");
                return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND); //Retorna un error 404
            }
        } catch (Exception e) {
            log.info("Error al consultar categoria: " + e.getMessage());
            e.getStackTrace();
            response.setMetadata("Respuesta no ok", "500", "Error al consultar categoria");
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Retorna un error 500
        }
        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK); //Retorna un error 200
    }

    @Override
    public ResponseEntity<CategoriaResponseRest> crear(Categoria categoria) {
        return null;
    }

    @Override
    public ResponseEntity<CategoriaResponseRest> actualizar(Long id, Categoria categoria) {
        return null;
    }

    @Override
    public ResponseEntity<CategoriaResponseRest> eliminar(Long id) {
        return null;
    }
}
