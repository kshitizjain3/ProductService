package com.scalar.productservicejune24.services;
import com.scalar.productservicejune24.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService
{
    //public is not required becoz all methods of an interface are public and static by default.

    Product getSingleProduct(Long productId);
    Page<Product> getAllProducts(int pageNumber, int pageSize);
    Product updateProduct(Long productId, Product product);
    Product replaceProduct(Long productId, Product product);
    void deleteProduct(Long productId);
    Product addNewProduct(Product product);
}
