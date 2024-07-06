package com.scalar.productservicejune24.controllers;
import com.scalar.productservicejune24.models.Product;
import com.scalar.productservicejune24.services.FakeStoreProductService;
import com.scalar.productservicejune24.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ProductController(ProductService productService) { //constructor
        this.productService = productService;
        //here this is equivalent to:
        //this.productService = FakeStoreProductService or
        //this.productService = RealStoreProductService
    }

    //http://localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }
}
