package com.study.purejpa.jpa;

import com.study.purejpa.Address;
import com.study.purejpa.File;
import com.study.purejpa.Post;
import com.study.purejpa.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Address address1 = new Address("서울시",
                    "광장시장로",
                    "110",
                    "신영상가 3층");

            User user1 = new User();
            user1.setName("민혁이");
            user1.setHomeAddress(address1);
            em.persist(user1);

            /**
             * address1의 값을 변경하고
             * 싶으면 새로운 address2를 만들어야함
             */
            Address address2 = new Address(address1.getCity(),
                    address1.getStreet(),
                    address1.getZipcode(),
                    "민혁상가 2층");

            User user2 = new User();
            user2.setName("용준이");
            user2.setHomeAddress(address2);
            em.persist(user2);

            tx.commit();

        } catch (Exception e) {
            tx.rollback(); // 롤백
            System.out.println("e = " + e);
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
