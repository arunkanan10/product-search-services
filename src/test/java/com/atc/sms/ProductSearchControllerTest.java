package com.atc.sms;

import com.abc.product.controller.ProductSearchController;
import com.abc.product.dto.Request;
import com.abc.product.model.ProductDetails;
import com.abc.product.repository.ProductSearchRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductSearchControllerTest.class)
public class ProductSearchControllerTest {

	@Mock
	ProductSearchRepository productSearchRepository;

	ProductSearchController productSearchController;

	@Before
	public void setup() {
		productSearchController = new ProductSearchController(productSearchRepository);
	}

	@Test
	public void testProductSearch() {
		Request reqObj = new Request();
		reqObj.setProductName("Formal Shirts");

		List<ProductDetails> products = constructProductDetailsList();
		when(productSearchRepository.search(reqObj)).thenReturn(products);

		List<ProductDetails> productDetailsList = productSearchController.search((reqObj));

		Assert.assertNotNull(productDetailsList);
		Assert.assertTrue(productDetailsList.size() == 3);
	}

	private List<ProductDetails> constructProductDetailsList() {
		List<ProductDetails> productList = new ArrayList<>();
		ProductDetails productDetails = new ProductDetails();
		productDetails.setId(1);
		productDetails.setProductName("Formal Shirts");
		productDetails.setBrand("Peter England");
		productDetails.setSize("XL");
		productDetails.setColor("Red");
		productList.add(productDetails);

		productDetails = new ProductDetails();
		productDetails.setId(2);
		productDetails.setProductName("Formal Shirts");
		productDetails.setBrand("Allen Solly");
		productDetails.setSize("M");
		productDetails.setColor("Blue");
		productList.add(productDetails);

		productDetails = new ProductDetails();
		productDetails.setId(3);
		productDetails.setProductName("Formal Shirts");
		productDetails.setBrand("Peter England");
		productDetails.setSize("XL");
		productDetails.setColor("Red");
		productList.add(productDetails);

		return productList;
	}
}
