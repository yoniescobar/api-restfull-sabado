package com.company.intecap.apibooks.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "categoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Categoria implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER,
                orphanRemoval = true,
                mappedBy = "categoria"
    )
    private Set<Libro> libros;
}
