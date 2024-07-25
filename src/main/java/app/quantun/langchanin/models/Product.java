package app.quantun.langchanin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "product_name", length = 100)
    private String productName;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

}
