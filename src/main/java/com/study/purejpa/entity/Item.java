package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
// 조인 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer price;
    private Integer stockQuantity;

    // 연관관계 주인 필드를 선택
    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItem = new ArrayList<>();

    // 연관관계 주인 필드를 선택
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
