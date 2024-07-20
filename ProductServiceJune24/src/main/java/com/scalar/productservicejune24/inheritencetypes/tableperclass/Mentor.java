package com.scalar.productservicejune24.inheritencetypes.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //this will not create a table but used to put all attributes of this class in single table
@DiscriminatorValue(value = "2")
public class Mentor extends User {
private String company;
}
