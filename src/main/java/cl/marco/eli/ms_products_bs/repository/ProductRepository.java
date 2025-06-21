package cl.marco.eli.ms_products_bs.repository;

import cl.marco.eli.ms_products_bs.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
