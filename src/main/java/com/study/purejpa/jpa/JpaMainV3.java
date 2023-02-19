package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;
import com.study.purejpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 회원 저장
            Member member1 = new Member();
            member1.setName("페이커");
            em.persist(member1);

            // 팀 저장
            Team team1 = new Team();
            team1.setName("SK T1");
            em.persist(team1);

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
