package com.scalar.productservicejune24.services;
import com.scalar.productservicejune24.models.Product;
import java.util.List;

public interface ProductService
{
    //public is not required becoz all methods of an interface are public and static by default.

    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
}
