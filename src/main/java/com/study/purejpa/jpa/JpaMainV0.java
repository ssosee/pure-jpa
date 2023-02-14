package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainV0 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

//        Member member = new Member();
//        member.setId(1L);
//        member.setName("아이유");
//        saveMember(member, em, emf);

        //Member member = findMember(1L, em, emf);
        updateMemberName(1L, "밍키밍카이", em, emf);
    }

    private static void saveMember(Member member, EntityManager em, EntityManagerFactory emf) {

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 얻음
        tx.begin(); // 트랜잭션 시작
        try {
            em.persist(member);
            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }

    private static Member findMember(Long id, EntityManager em, EntityManagerFactory emf) {

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 얻음
        Member member = null;
        tx.begin(); // 트랜잭션 시작
        try {
            member = em.find(Member.class, id); // 영속성 컨텍스트로 관리
            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
        return member;
    }

    private static void updateMemberName(Long id, String name, EntityManager em, EntityManagerFactory emf) {
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 얻음
        tx.begin(); // 트랜잭션 시작
        try {
            Member findMember = em.find(Member.class, id);
            findMember.setName(name);
            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }

    private static void deleteMember(Long id, EntityManager em, EntityManagerFactory emf) {
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            Member findMember = em.find(Member.class, id);
            em.remove(findMember); // 삭제

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
