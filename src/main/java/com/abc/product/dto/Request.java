package com.abc.product.dto;

import lombok.Data;

@Data
public class Request {
    private String productName;
    private String sku;
    private String brand;
    private String color;
    private int minPrice;
	private int maxPrice;
    private String size;
}
