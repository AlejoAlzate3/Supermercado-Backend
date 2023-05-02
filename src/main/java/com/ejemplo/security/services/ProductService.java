package com.ejemplo.security.services;

import com.ejemplo.security.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product findById(Long id);
    public Product save(Product product);
    public void deleteById(Long id);
    public Product update(Product product);
}
