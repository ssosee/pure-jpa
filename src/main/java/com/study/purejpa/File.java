package com.study.purejpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class File {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String path;
    // 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private Post post;
}
