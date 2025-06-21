package cl.marco.eli.ms_products_bs.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity // Le dice a Spring que esta clase es una tabla de la base de datos.
@Table(name = "products") // Asocia esta clase con la tabla 'products'.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id // Marca este campo como la clave primaria (Primary Key).
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se auto-incrementa.
    private Long id;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

}
