package com.abc.product.repository;

import com.abc.product.dto.Request;
import com.abc.product.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductSearchRepositoryimpl implements ProductSearchRepository {

    @Autowired
    private EntityManager entityManager;

    public List<ProductDetails> search(Request request) {

        StringBuilder query = buildQuery(request);
        return entityManager.createQuery(query.toString()).getResultList();
    }

    private StringBuilder buildQuery(Request request) {
        StringBuilder query = new StringBuilder("SELECT p FROM ProductDetails p WHERE ");

        constructQuery(query, request.getBrand(), " p.brand LIKE '");
        constructQuery(query, request.getProductName(), " p.productName LIKE '");
        constructQuery(query, request.getColor(), " p.color LIKE '");
        constructQuery(query, request.getSku(), " p.sku LIKE '");
        constructQuery(query, request.getSize(), " p.size LIKE '");

        int lastIndex = query.lastIndexOf("AND");
        query.replace(lastIndex, lastIndex + 3, "");
        return query;
    }

    private void constructQuery(StringBuilder query, String value, String field) {
        if (value != null && !"".equalsIgnoreCase(value)) {
            query.append(field + value);
            query.append("' AND ");
        }
    }
}
