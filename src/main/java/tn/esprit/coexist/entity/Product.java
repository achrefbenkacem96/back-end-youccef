package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer productId;
    private String productName;
    private String description;
    private String image;
    private Integer rate;
    private Integer stock;
    private float price;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<OrderEntity> orderEntities;


}
