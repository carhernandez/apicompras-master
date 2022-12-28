package com.platzi.apicompras.persistence;

import com.platzi.apicompras.persistence.crud.ProductoCrudRepository;
import com.platzi.apicompras.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    private List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.finByidCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findBycantidadStockLessthanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public  void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
