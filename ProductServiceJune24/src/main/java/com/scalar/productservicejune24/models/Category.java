package com.scalar.productservicejune24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel
{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    //if we want to represent same relationship both sides,
    //this way we can limit this to only our codebase and not our database.
    private List<Product> products;
}
