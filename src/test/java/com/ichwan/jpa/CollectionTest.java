package com.ichwan.jpa;

import com.ichwan.jpa.entity.Customer;
import com.ichwan.jpa.entity.CustomerGender;
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

public class CollectionTest {
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

        entityManager.persist(member);
        entityTransaction.commit();
        entityManager.close();
    }

}
