package com.scalar.productservicejune24.inheritencetypes.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_students")
@PrimaryKeyJoinColumn(name="userid")
public class Student extends User{
    private String batch;
}
