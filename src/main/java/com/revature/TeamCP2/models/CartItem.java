package com.revature.TeamCP2.models;

import com.revature.TeamCP2.interfaces.Model;

import javax.persistence.*;

/**
Author: Steven Dowd
Purpose: Model for cart item objects
 */

@Entity
@Table(name = "cart-item", schema = "public")
public class CartItem implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart-item-id")
    private Integer id;



    @ManyToOne
    @JoinColumn (name = "cart-id")
    private Cart cart;

    @OneToOne
    @JoinColumn (name = "product-id")
    private Product product;

    @Column
    private Integer quantity;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product, Integer quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}




