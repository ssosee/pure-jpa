package com.study.purejpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Embedded // 임베디드 타입 사용하는 곳에 표시
    private Address homeAddress;
    @Embedded // 임베디드 타입 사용하는 곳에 표시
    @AttributeOverrides({
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "work_city")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "work_street")
            ),
            @AttributeOverride(
                    name = "zipcode",
                    column = @Column(name = "work_zipcode")
            ),
            @AttributeOverride(
                    name = "detailAddress",
                    column = @Column(name = "work_detailAddress")
            ),
    })
    private Address workAddress;
}
