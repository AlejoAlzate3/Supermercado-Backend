package com.ejemplo.security.controllers;

import com.ejemplo.security.auth.AuthenticationRequest;
import com.ejemplo.security.auth.AuthenticationResponse;
import com.ejemplo.security.model.Product;
import com.ejemplo.security.services.AuthenticationService;
import com.ejemplo.security.auth.RegisterRequest;
import com.ejemplo.security.services.ProductService;
import com.ejemplo.security.services.UserService;
import com.ejemplo.security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserService userService;
    private final ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }


    //Usuarios
    @GetMapping("/user")
    public User getUserActual(Principal principal) {
        return (User) service.getUserActual(principal);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }



    //Productos
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        List<?> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Producto eliminado");
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }
}
