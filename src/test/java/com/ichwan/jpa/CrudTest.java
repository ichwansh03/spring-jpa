package com.ichwan.jpa;

import com.ichwan.jpa.entity.Customer;
import com.ichwan.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrudTest {
    
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

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Ichwan");
        customer.setPrimaryEmail("ichwan@test.com");
        customer.setMarried(false);
        customer.setAge((byte) 20);

        Assertions.assertNotNull(customer);
        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void findData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Ichwan", customer.getName());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void updateData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        customer.setName("Ichwan Sholihin");
        entityManager.merge(customer);

        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Ichwan Sholihin", customer.getName());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void deleteData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        entityManager.remove(customer);

        Assertions.assertNull(customer);

        entityTransaction.commit();
        entityManager.close();
    }

}
