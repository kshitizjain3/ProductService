package com.scalar.productservicejune24.services;
import com.scalar.productservicejune24.dtos.FakeStoreProductDto;
import com.scalar.productservicejune24.models.Category;
import com.scalar.productservicejune24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//This class will implement ProductService interface.

//service annotation will create an object of FakeStoreProductService class.
@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        //call FakeStore to fetch the product with given id-->HTTP call.
        //FakeStoreProductDto.class will just convert the data received from url to our dto class type.
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +
                productId, FakeStoreProductDto.class);

        //this will return data as FakeStoreProductDto type but in our method we have return type as Product
        //So now we will convert our FakeStoreProductDto into Product

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
        private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());

            Category category = new Category();
            category.setDescription(fakeStoreProductDto.getDescription());
            product.setCategory(category);
            return product;
        }
}
