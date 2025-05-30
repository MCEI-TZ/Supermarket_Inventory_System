package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ProductStock implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_stock")
    private Long idProductStock;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_branch")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

    private int quantity;

    private Integer stock;
    private double price;
    private Date lastRestockDate;
}
