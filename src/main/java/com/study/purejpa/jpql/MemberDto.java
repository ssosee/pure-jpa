package com.study.purejpa.jpql;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embedded;

@Data
@AllArgsConstructor
public class MemberDto {
    private String username;
    private int age;
}
