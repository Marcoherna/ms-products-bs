package cl.marco.eli.ms_products_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import cl.marco.eli.ms_products_bs.models.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products-data-service", url = "${ferremas.ms-products-data.url}")
public interface ProductDataClient {

    // La ruta debe coincidir con la del ProductDataController
    @GetMapping("/data/products")
    List<ProductDTO> getAllProducts();

    @GetMapping("/data/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}