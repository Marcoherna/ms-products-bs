package cl.marco.eli.ms_products_bs.controllers;


import cl.marco.eli.ms_products_bs.clients.ProductDataClient;
import cl.marco.eli.ms_products_bs.models.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Inyectamos el cliente Feign en lugar del repositorio
    @Autowired
    private ProductDataClient productDataClient;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        // La lógica de negocio (si la hubiera) iría aquí.
        // En este caso, simplemente delegamos la llamada.
        return productDataClient.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productDataClient.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}