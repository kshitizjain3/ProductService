package com.scalar.productservicejune24.repository;

import com.scalar.productservicejune24.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { //here Long is the datatype of the primary ket of Product table.
    //It should contain all the methods(CRUD) related to Product Model.
    List<Product> findByPriceIsGreaterThan(Double price);
    //select * from products where price > ?
    List<Product> findProductByTitleLike(String word);//case sensitive
    //select * from products where title like "%iphone%
    List<Product> findByTitleLikeIgnoreCase(String word); //case insensitive
    List<Product> findTop5ByTitleContains(String word);
    //select * from products where title like " " LIMIT 5
    List<Product> findProductsByTitleContainsAndPriceGreaterThan(String word, Double price);
    List<Product> findProductsByTitleContainsOrderById(String word);
    @Override
    List<Product> findAll(Sort sort);
}
