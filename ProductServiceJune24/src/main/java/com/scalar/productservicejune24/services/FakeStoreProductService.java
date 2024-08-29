package com.scalar.productservicejune24.services;
import com.scalar.productservicejune24.dtos.FakeStoreProductDto;
import com.scalar.productservicejune24.models.Category;
import com.scalar.productservicejune24.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//This class will implement ProductService interface.

//service annotation will create an object of FakeStoreProductService class.
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        //call FakeStore to fetch the product with given id-->HTTP call.
        //FakeStoreProductDto.class will just convert the data received from url to our dto class type.
        // throw new ArithmeticException();

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +
                productId, FakeStoreProductDto.class);

        //this will return data as FakeStoreProductDto type but in our method we have return type as Product
        //So now we will convert our FakeStoreProductDto into Product

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        //During runtime list of FakeStoreProductDto type does not even exist.
        //So we can use an array instead.
        //List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.getForObject(
        //       "https://fakestoreapi.com/products", List<FakeStoreProductDto>.class);
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        //convert list of FakeStoreProductDto to list of Product
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return new PageImpl<>(products);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        //instead of using put() we can directly use execute as it return something.
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());

                FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/"+id,
                HttpMethod.PATCH, requestCallback, responseExtractor);
                return convertFakeStoreProductDtoToProduct(response);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
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
