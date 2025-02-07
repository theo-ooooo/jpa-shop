package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Book;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // 요청시 매번 받아야한다.

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("강경원");

            em.persist(book);
            tx.commit();
        }catch(Exception e) {
            System.out.println("e" + e.getMessage());
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
