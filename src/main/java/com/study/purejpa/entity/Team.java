package com.study.purejpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    /**
     * 일대다 단방향 매핑
     * 외래키를 Team에서 관리
     */
    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Member> members = new ArrayList<>();
}
