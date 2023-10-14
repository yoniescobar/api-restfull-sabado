package com.company.intecap.apibooks.service;

import com.company.intecap.apibooks.model.Libro;
import com.company.intecap.apibooks.model.dao.ILibroDao;
import com.company.intecap.apibooks.respose.LibroResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service //anotacion para indicar que es un servicio
public class LibroServiceImpl implements ILibroService {

    private static final Logger log = Logger.getLogger(LibroServiceImpl.class.getName());

    @Autowired //@Autowired: inyecta el repositorio de libros para poder utilizarlo en este servicio
    private ILibroDao libroDao; //variable de tipo ILibroDao para acceder a los metodos de la interface ILibroDao

    @Override
    @Transactional(readOnly = true) //anotacion para indicar que es un metodo de solo lectura
    public ResponseEntity<LibroResponseRest> buscarLibros() {
        log.info("inicio metodo buscarLibros");

        LibroResponseRest response = new LibroResponseRest(); //creacion de un objeto de tipo LibroResponseRest

        try{
            List<Libro> listLibros = (List<Libro>) libroDao.findAll(); //creacion de una lista de libros para guardar los libros que se encuentren en la base de datos
            response.getLibroResponse().setLibros(listLibros); //se asigna la lista de libros al objeto de tipo LibroResponseRest
            response.setMetadata("Respuesta exitosa", "200", "Lista de Libros"); //se asigna el mensaje de respuesta al objeto de tipo LibroResponseRest
        }catch (Exception e){
             log.severe("Error en el metodo buscarLibros: " + e.getMessage()); //se muestra un mensaje de error en caso de que ocurra una excepcion
             e.getStackTrace();
             response.setMetadata("Respuesta no exitosa", "500", "Error al consultar la lista de libros"); //se asigna el mensaje de respuesta al objeto de tipo LibroResponseRest

            return new ResponseEntity<LibroResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo LibroResponseRest y el codigo de estado 500

        }
        return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo LibroResponseRest y el codigo de estado 200
    }

}
