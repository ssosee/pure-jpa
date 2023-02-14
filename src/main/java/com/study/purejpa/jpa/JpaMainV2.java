package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;
import com.study.purejpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainV2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team(1L, "홍철없는 홍철팀");
            Member member1 = new Member(1L, "유재석", team);
            em.persist(team);
            em.persist(member1);

            em.flush(); // 영속성 컨텍스트 DB 반영
            em.clear(); // 영속성 컨텍스트 비움

            // 지연 로딩
            Member findMember = em.find(Member.class, 1L);
            System.out.println("전 findMember.getTeam()="+ findMember.getTeam().getClass());

            System.out.println("실제로 Team 엔티티를 사용하면?");
            findMember.getTeam().getName();
            System.out.println("후 findMember.getTeam()="+ findMember.getTeam().getClass());

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
