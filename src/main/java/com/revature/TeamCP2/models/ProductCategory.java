/**
 * Author(s): @George Henderson
 * Contributor(s):
 * Purpose: ProductCategory Entity
 */

package com.revature.TeamCP2.models;

import com.revature.TeamCP2.interfaces.Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "product_categories", schema = "public")
public class ProductCategory implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
            mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Product> productsAssociated;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private byte[] image;

    public ProductCategory() {
        this.productsAssociated = new LinkedList<Product>();
    }

    public ProductCategory(String name, String description, byte[] image) {
        this.productsAssociated = new LinkedList<Product>();
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ProductCategory addAssociatedProduct(Product product) {
        this.productsAssociated.add(product);
        return this;
    }

    public ProductCategory removeAssociatedProduct(Product product) {
        this.productsAssociated.remove(product);
        return this;
    }

    public ProductCategory setProductsAssociated(List<Product> productsAssociated) {
        this.productsAssociated = productsAssociated;
        return this;
    }

    public List<Product> getProductsAssociated() {
        return productsAssociated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
