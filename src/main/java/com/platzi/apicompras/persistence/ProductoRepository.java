package com.platzi.apicompras.persistence;

import com.platzi.apicompras.domain.Product;
import com.platzi.apicompras.domain.repository.ProductRepository;
import com.platzi.apicompras.persistence.crud.ProductoCrudRepository;
import com.platzi.apicompras.persistence.entity.Producto;
import com.platzi.apicompras.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;
    @Override
    public List<Product> getAll() {
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.finByidCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
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
