package com.abc.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.Set;

@Entity
@Table(name = "productDetails")
public class ProductDetails {

    @Id
    @GeneratedValue(generator = "product_generator")
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_id_seq",
            initialValue = 1000
    )
    private int id;

    @Column(columnDefinition = "productName")
    private String productName;

    @Column(columnDefinition = "sku")
    private String sku;

    @Column(columnDefinition = "brand")
    private String brand;

    @Column(columnDefinition = "price")
    private Double price;

    @Column(columnDefinition = "color")
    private String color;

    @Column(columnDefinition = "size")
    private String size;

    @Column(columnDefinition = "productCategoryId")
    private int productCategoryId;

    @ManyToOne(optional=false)
    @JoinColumn(name="productCategoryId", referencedColumnName="id", insertable = false, updatable = false)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "productDetails", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProductInventory> productInventories;

    public Set<ProductInventory> getProductInventories() {
        return productInventories;
    }

    public void setProductInventories(Set<ProductInventory> productInventories) {
        this.productInventories = productInventories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @JsonIgnore
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
