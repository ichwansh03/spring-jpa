package com.ichwan.jpa;

import com.ichwan.jpa.entity.embedded.Member;
import com.ichwan.jpa.entity.embedded.Name;
import com.ichwan.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmbeddedTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void insertDataEmbedded() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTitle("Mr.");
        name.setFirstName("Ichwan");
        name.setLastName("Sholihin");

        Member member = new Member();
        member.setEmail("ichwan@test.com");
        member.setName(name);

        Assertions.assertNotNull(member);
        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }

}
