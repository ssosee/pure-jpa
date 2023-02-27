package com.study.purejpa.jpa;

import com.study.purejpa.*;
import com.study.purejpa.entity.Member;
import com.study.purejpa.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            List<Member> result = em.createQuery("select m from Member m" +
                            " where m.age >= 20", Member.class)
                            .getResultList();


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
