package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;
import com.study.purejpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 팀 저장
            Team team = new Team();
            team.setName("SK T1");
            em.persist(team);

            // 회원 저장
            Member member = new Member();
            member.setName("Faker");

            // 연관관계 설정
            member.changeTeam(team);

            em.persist(member);

            // 1차 캐시
            Team findTeam = em.find(Team.class, team.getId());
            for (Member m : findTeam.getMembers()) {
                // 값이 없음
                System.out.println("m="+m.getName());
            }

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
