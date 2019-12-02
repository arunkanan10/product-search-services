package com.abc.product.controller;

import com.abc.product.dto.Request;
import com.abc.product.model.ProductDetails;
import com.abc.product.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductSearchController {

	@Autowired
    ProductSearchRepository hotelSearchRepository;
	
    public ProductSearchController() {}

    @PostMapping("/product/search")
    public List<ProductDetails> search(@RequestBody Request request) {
        List<ProductDetails> productList = hotelSearchRepository.search(request);
        return productList;
    }
}
