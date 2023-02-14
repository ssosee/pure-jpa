package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {
    @Id // PK
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member() {
    }

    public Member(Long id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }
}
