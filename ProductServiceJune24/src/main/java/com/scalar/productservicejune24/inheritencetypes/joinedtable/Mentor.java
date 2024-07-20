package com.scalar.productservicejune24.inheritencetypes.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentors")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User{
private String company;
}
