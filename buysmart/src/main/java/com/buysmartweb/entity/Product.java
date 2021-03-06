package com.buysmartweb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "text")
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private String briefDesc;
    private Float salePrice;
    private Float percentDiscount;
    private Integer quantityProd;
    private Integer quantityImport;
    private boolean isHot = false;
    private String image;
    @Column(columnDefinition = "text")
    private String url;
    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Category category;
    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "product")
    private Set<OrderDetail> orderDetail;
    @Column(name = "cost")
    private Float cost;
    @OneToMany(targetEntity = Cart.class, cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Cart> cart;
}


