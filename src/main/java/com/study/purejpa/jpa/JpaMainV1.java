package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainV1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        // 비영속
        Member member1 = new Member(1L, "유재석",null);

        // 영속성 컨텐스트에 저장, 쓰기 지연 SQL 저장소에 SQL 저장
        em.persist(member1);

        // 1차 캐시에서 조회
        Member findMember = em.find(Member.class, 1L);
        findMember.setName("박명수");

        tx.commit(); // 커밋(쿼리 발생)
    }
}
