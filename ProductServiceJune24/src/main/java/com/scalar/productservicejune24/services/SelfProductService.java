package com.scalar.productservicejune24.services;

import com.scalar.productservicejune24.ProductServiceJune24Application;
import com.scalar.productservicejune24.models.Category;
import com.scalar.productservicejune24.models.Product;
import com.scalar.productservicejune24.repository.CategoryRepository;
import com.scalar.productservicejune24.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
     //   Sort sort = Sort.by("price").ascending().and(Sort.by("title").descending());
        return productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("price").ascending().and(Sort.by("title").descending())));
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return null;
            // throw new ProductNotFoundException("Product with id" + productId + "doesn't exist");
        }
        Product productInDb = productOptional.get();
        if(product.getTitle() != null){
            productInDb.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            productInDb.setPrice(product.getPrice());
        }
        return productRepository.save(productInDb);
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
    //    Category category = product.getCategory();
    //    if(category.getId() == null){
        // we need to create new category in the DB first
    //        category = CategoryRepository.save(category);
    //        product.setCategory(category);
    //    }
        return productRepository.save(product);
    }
}
