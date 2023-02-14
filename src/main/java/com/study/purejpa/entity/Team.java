package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
// 유니크 제약 조건 추가
@Table(uniqueConstraints =
        {@UniqueConstraint(
                name = "NAME_AGE_UNIQUE",
                columnNames = {"NAME", "AGE"}
        )})
public class Team {

    @Id
    private Long id;
    private String name;
    private Integer age;
    // 유니크 제약 조건 추가
    @Column(unique = true)
    private String nickName;
    // 기본 생성자 필수
    public Team() {
    }

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
