package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;
import com.study.purejpa.entity.item.Item;
import com.study.purejpa.entity.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setName("개발자");
            member.setCreateDate(LocalDateTime.now());

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
