package com.abc.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Set;

@Entity
@Table(name = "productCategory")
public class ProductCategory {

	@Id
    @GeneratedValue(generator = "product_cat_generator")
    @SequenceGenerator(
            name = "product_cat_generator",
            sequenceName = "product_cat_id_seq",
            initialValue = 1000
    )
	private int id;
	
	@Column(columnDefinition = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
	private Set<ProductDetails> productDetails;

	public Set<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(Set<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
