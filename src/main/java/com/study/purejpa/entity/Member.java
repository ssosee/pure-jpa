package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {
    @Id // PK
    private Long id;
    private String name;
}
