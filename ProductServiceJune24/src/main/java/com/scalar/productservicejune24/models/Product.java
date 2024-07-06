package com.scalar.productservicejune24.models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends BaseModel
{
    private String title;
    private double price;
    private Category category;
}
//we are taking attributes as private for security purposes. To make our attributes accessible, we have to make getter
//setter methods.