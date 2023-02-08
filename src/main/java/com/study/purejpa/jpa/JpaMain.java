package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 얻음
        tx.begin(); // 트랜잭션 시작

        Member member = new Member();
        member.setId(1L);
        member.setName("세웅");
        em.persist(member);

        tx.commit(); // 커밋

        em.close();

        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
