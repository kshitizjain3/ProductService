package com.scalar.productservicejune24.models;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

//All the common attributes will be present here.

@Getter
@Setter

public class BaseModel
{
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
