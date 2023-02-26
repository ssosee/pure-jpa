package com.study.purejpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<File> files = new ArrayList<>();

    public void changePost(File file) {
        files.add(file);
        file.setPost(this);
    }
}
