package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter @Getter
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
