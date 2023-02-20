package com.study.purejpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Setter @Getter
@MappedSuperclass
public class BaseTimeEntity {
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;
}
