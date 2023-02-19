package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
