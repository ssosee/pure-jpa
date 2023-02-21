package com.study.purejpa.jpa;

import com.study.purejpa.entity.Member;
import com.study.purejpa.entity.Order;
import com.study.purejpa.entity.OrderStatus;
import com.study.purejpa.entity.TestEntity;
import com.study.purejpa.entity.item.Item;
import com.study.purejpa.entity.item.Movie;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            TestEntity testEntity = new TestEntity();
            testEntity.setId(299L);
            TestEntity value = em.merge(testEntity);
            System.out.println("========================");


//            Member member1 = new Member();
//            member1.setName("밍밍이");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("싱싱이");
//            em.persist(member2);
//
//            Order order1 = new Order();
//            order1.setStatus(OrderStatus.ORDER);
//            order1.setMember(member1);
//            em.persist(order1);
//
//            Order order2 = new Order();
//            order2.setStatus(OrderStatus.CANCEL);
//            order2.setMember(member2);
//            em.persist(order2);
//
//            em.flush();
//            em.clear();
//
//            // 패치조인 사용
//            List<Order> orders = em.createQuery(
//                    "select o" +
//                            " from Order o" +
//                            " join fetch o.member m", Order.class)
//                    .getResultList();

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
