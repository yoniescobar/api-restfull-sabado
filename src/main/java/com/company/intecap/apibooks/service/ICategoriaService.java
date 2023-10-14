package com.company.intecap.apibooks.service;

import com.company.intecap.apibooks.model.Categoria;
import com.company.intecap.apibooks.respose.CategoriaResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoriaService {

    public ResponseEntity<CategoriaResponseRest> buscarCategorias();

    public ResponseEntity<CategoriaResponseRest> buscarCategoriaId(Long id);

    public ResponseEntity<CategoriaResponseRest> crear(Categoria categoria);

    public ResponseEntity<CategoriaResponseRest> actualizar(Long id, Categoria categoria);

    public ResponseEntity<CategoriaResponseRest> eliminar(Long id);
}
