package com.ejemplo.security.services.impl;

import com.ejemplo.security.model.Product;
import com.ejemplo.security.repository.ProductRepository;
import com.ejemplo.security.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto no encontrado")
        );
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        product.setNombre(product.getNombre());
        product.setPrecio(product.getPrecio());
        product.setStock(product.getStock());
        product.setDescripcion(product.getDescripcion());
        product.setPromocion(product.getPromocion());
        product.setActivo(product.isActivo());
        return productRepository.save(product);
    }

}
