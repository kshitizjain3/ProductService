package com.scalar.productservicejune24.inheritencetypes.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructors") //giving name is optional
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User{
    private String subject;
}
