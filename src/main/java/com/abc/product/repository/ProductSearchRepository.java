package com.abc.product.repository;

import com.abc.product.dto.Request;

import java.util.List;

import com.abc.product.model.ProductDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSearchRepository {
    List<ProductDetails> search(Request request);
}
