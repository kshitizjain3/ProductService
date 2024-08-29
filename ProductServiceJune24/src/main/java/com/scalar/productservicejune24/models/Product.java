package com.scalar.productservicejune24.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Product extends BaseModel
{
    private String title;
    private Double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    //due to cascade category object will automatically create if it doesn't exist while creating a new product.
    private Category category;
}
//we are taking attributes as private for security purposes. To make our attributes accessible, we have to make getter
//setter methods.