package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category extends BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;

    /**
     * 다대다 설정
     */
    @ManyToMany
    @JoinTable(name = "category_item",
        // Category에서 join해야 할 대상은 category_id
        joinColumns = @JoinColumn(name = "category_id"),
        // Item에서 join해야 할 대상은 item_id
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();
    /**
     * 상위 카테고리를 설정
     * 하나의 부모 카테고리는 여러개의 자식 카테고리가 있음
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    /**
     * 양방향으로 설정
     * 연관관계 주인 필드를 선택
     */
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
