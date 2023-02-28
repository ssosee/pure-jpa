package com.study.purejpa.jpa;


import com.study.purejpa.jpql.Address;
import com.study.purejpa.jpql.Member;
import com.study.purejpa.jpql.MemberDto;
import com.study.purejpa.jpql.Team;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("춘식이");
            member.setAge(3);
            member.setAddress(new Address("화성시", "화성로", "942"));
            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            String sql = "select m.username, 'hello', true from Member m" +
                    " where m.age = 10 and TYPE(m) = Member ";
            //String sql = "select m from Member m where exists (select t from Team t where t.name = 'teamA')";
            List<Member> result = em.createQuery(sql, Member.class)
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
