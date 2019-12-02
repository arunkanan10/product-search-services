package com.abc.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "productInventory")
public class ProductInventory {

    @Id
    @GeneratedValue(generator = "product_inv_generator")
    @SequenceGenerator(
            name = "product_inv_generator",
            sequenceName = "product_inv_id_seq",
            initialValue = 1000
    )
    private int id;

    @Column(columnDefinition = "productId")
    private int productId;

    @Column(columnDefinition = "inventory")
    private int inventory;

    @ManyToOne(optional=false)
    @JoinColumn(name="productId", referencedColumnName="id", insertable = false, updatable = false)
    private ProductDetails productDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @JsonIgnore
    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }
}
