package com.study.purejpa;

import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

// 임베디드 타입을 정의하는 곳에 표시
@Embeddable
@Access(AccessType.FIELD)
public class Address {
    private String city;
    private String street;
    private String zipcode;
    private String detailAddress;

    public boolean isDetailAddress(String detailAddress) {
        if(detailAddress.isBlank()) {
            return false;
        }
        return true;
    }
}
