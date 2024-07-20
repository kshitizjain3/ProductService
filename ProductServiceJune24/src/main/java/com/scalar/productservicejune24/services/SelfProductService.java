package com.scalar.productservicejune24.services;

import com.scalar.productservicejune24.ProductServiceJune24Application;
import com.scalar.productservicejune24.models.Product;
import com.scalar.productservicejune24.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{
    private final ProductServiceJune24Application productServiceJune24Application;
    private ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository, ProductServiceJune24Application productServiceJune24Application) {
        this.productRepository = productRepository;
        this.productServiceJune24Application = productServiceJune24Application;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        //make a call to DB to fetch a product of given ID.
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()) {
            return null;
            // throw new ProductNotFoundException("Product with id" + productId + "doesn't exist");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }
}
