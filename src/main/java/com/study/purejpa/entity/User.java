package com.study.purejpa.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@TableGenerator(
        name = "USER_SEQ_GENERATOR", // 식별자 생성기 이름
        table = "MY_SEQUENCES", // 키생성 테이블명
        pkColumnName = "USER_SEQ", // 키로 사용할 값 이름
        allocationSize = 1 // 시퀀스 한 번 호출에 증가하는 수
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "USER_SEQ_GENERATOR")
    private Long id;
    @Column(name = "name",
            columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;
    // 소수점 포함 전체 10자리, 소수점은 6자리 까지만
    @Column(precision = 20, scale = 6)
    private BigDecimal age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    // 필드 매핑 안함
    @Transient
    private Integer temp;
}
