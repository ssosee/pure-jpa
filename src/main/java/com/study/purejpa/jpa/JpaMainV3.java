package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;
import com.study.purejpa.entity.RoleType;
import com.study.purejpa.entity.Team;
import com.study.purejpa.entity.User;

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
            User user1 = new User();
            user1.setName("노홍철");
            user1.setRoleType(RoleType.USER);

            System.out.println("persist 전");
            em.persist(user1);
            System.out.println("persist 후");

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
