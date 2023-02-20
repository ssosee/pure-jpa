package com.study.purejpa.jpa;

import com.study.purejpa.entity.item.Item;
import com.study.purejpa.entity.item.Movie;

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

            Movie movie = new Movie();
            movie.setDirector("봉준호");
            movie.setActor("송강호");
            movie.setName("기생충");
            movie.setPrice(15000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie movie1 = em.find(Movie.class, 1L);
            System.out.println("movie1="+movie1);

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback(); // 롤백
        } finally {
            em.close(); // DB Connection을 사용하여 작업함
        }
        emf.close(); // 애플리케이션이 종료되면 닫아야함
    }
}
