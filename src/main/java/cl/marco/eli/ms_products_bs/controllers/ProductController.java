package cl.marco.eli.ms_products_bs.controllers;

import cl.marco.eli.ms_products_bs.models.Product;
import cl.marco.eli.ms_products_bs.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Define que esta clase es un controlador REST.
@RequestMapping("/api/products") // Todas las URLs de este controlador empezarán con /api/products.
public class ProductController {

    @Autowired // Inyección de dependencias: Spring nos "inyecta" una instancia de ProductRepository.
    private ProductRepository productRepository;

    // Endpoint para obtener todos los productos.
    // GET http://localhost:8081/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Endpoint para obtener un producto por su ID.
    // GET http://localhost:8081/api/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        // Si el producto existe, lo devuelve con un código 200 OK.
        // Si no, devuelve un 404 Not Found.
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
