package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    /**
     * status를 enum 타입으로 설정
     */
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    /**
     * 양방향으로 설정
     * 연관관계 주인 필드를 선택
     */
    @OneToOne(mappedBy = "delivery")
    private Order order;
}
