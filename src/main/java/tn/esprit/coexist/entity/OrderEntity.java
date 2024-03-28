package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer orderId;
    private String quantity;
    @ManyToMany(mappedBy = "orderEntities",cascade = CascadeType.ALL)
    private List<Product>products;



}
