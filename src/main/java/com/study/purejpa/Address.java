package com.study.purejpa;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.util.Objects;

// 임베디드 타입을 정의하는 곳에 표시
@Embeddable
@Getter
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;
    private String detailAddress;

//    public boolean isDetailAddress(String detailAddress) {
//        if(detailAddress.isBlank()) {
//            return false;
//        }
//        return true;
//    }

    public Address(String city, String street, String zipcode, String detailAddress) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.detailAddress = detailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(
                getCity(),
                address.getCity()) && Objects.equals(getStreet(),
                address.getStreet()) && Objects.equals(getZipcode(),
                address.getZipcode()) && Objects.equals(getDetailAddress(),
                address.getDetailAddress()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode(), getDetailAddress());
    }
}
