package com.scalar.productservicejune24.controllers;
import com.scalar.productservicejune24.models.Product;
import com.scalar.productservicejune24.services.FakeStoreProductService;
import com.scalar.productservicejune24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")

public class ProductController {
    /*we can't directly create object of interface so we will use concept of DI. We are injecting dependency of
    productService into ProductController.
      A{
      B b;
      A(B b)
      this.b=b; }
    */
    private ProductService productService;
    public ProductController(@Qualifier("selfProductService") ProductService productService) { //constructor
        this.productService = productService;
        //here this is equivalent to:
        //this.productService = FakeStoreProductService or
        //this.productService = RealStoreProductService
    }

    //http://localhost:8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
            ResponseEntity<Product> response = new ResponseEntity<>(
                    productService.getSingleProduct(id), HttpStatus.OK);
            return response;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id")Long productId){
        productService.deleteProduct(productId);
    }

    //PATCH-->http://localhost:8080/products/1
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    //if  we forgot to give the value of any attribute then by default it will be set to null.
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return null;
    }
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }
}
