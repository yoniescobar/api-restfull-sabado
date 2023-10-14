package com.company.intecap.apibooks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity // Indica que es una entidad de la base de datos (tabla)
@Table(name = "libro") // Indica el nombre de la tabla
public class Libro implements Serializable { //Serializable: Permite que la clase se pueda converit en un arreglo bity

    private static final long serialVersionUID = 1L;
    // esta constante es para que se pueda serializar el objeto y se pueda enviar por la red

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el id es autoincrementable
    private Long id;
    private String nombre;
    @Column(length = 100) // Indica el tamaño del campo
    private String descripcion;



    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
