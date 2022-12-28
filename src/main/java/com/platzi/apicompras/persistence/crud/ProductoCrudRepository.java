package com.platzi.apicompras.persistence.crud;

import com.platzi.apicompras.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> finByidCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findBycantidadStockLessthanAndEstado(int cantidadStock, boolean estado);

}
