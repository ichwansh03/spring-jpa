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

import java.util.ArrayList;
import java.util.HashMap;

class CollectionTest {
    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void insertData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setFirstName("Ichwan");
        name.setLastName("Sholihin");
        name.setTitle("Test Join Column");

        Member member = new Member();
        member.setEmail("ichwan@test.com");
        member.setName(name);

        member.setHobbies(new ArrayList<>());
        member.getHobbies().add("Reading");
        member.getHobbies().add("Coding");

        Assertions.assertNotNull(member);
        entityManager.persist(member);
        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void updateDataMap(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = entityManager.find(Member.class, 2);
        member.setSkills(new HashMap<>());
        member.getSkills().put("Java", 90);
        member.getSkills().put("Kotlin", 85);
        member.getSkills().put("C++", 80);

        entityManager.merge(member);

        entityTransaction.commit();
        entityManager.close();
    }
}
