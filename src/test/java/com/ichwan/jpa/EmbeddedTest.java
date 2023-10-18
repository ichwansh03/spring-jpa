package com.ichwan.jpa;

import com.ichwan.jpa.entity.Department;
import com.ichwan.jpa.entity.DepartmentId;
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

    @Test
    void insertDataEmbeddedId() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        DepartmentId id = new DepartmentId();
        id.setCompanyId("C1");
        id.setDepartmentId("D1");

        Department department = new Department();
        department.setId(id);
        department.setName("Fintech");

        Assertions.assertNotNull(department);
        entityManager.persist(department);

        entityTransaction.commit();
        entityManager.close();
    }

}
