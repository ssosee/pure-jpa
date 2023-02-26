package com.study.purejpa.jpa;

import com.study.purejpa.File;
import com.study.purejpa.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainV3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pureJpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            File file1 = new File();
            file1.setName("둘리");
            file1.setPath("/image/둘리.png");

            File file2 = new File();
            file2.setName("도우너");
            file2.setPath("/image/도우너.png");

            Post post = new Post();
            post.setName("아기공룡 둘리");
            post.changePost(file1);
            post.changePost(file2);

            em.persist(post);
            em.persist(file1);
            em.persist(file2);

            em.flush();
            em.clear();

            Post findPost = em.find(Post.class, post.getId());
            findPost.getFiles().remove(0);

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
