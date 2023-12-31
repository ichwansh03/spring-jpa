package com.ichwan.jpa;

import com.ichwan.jpa.entity.Customer;
import com.ichwan.jpa.entity.CustomerGender;
import com.ichwan.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * validateContract hanya dapat digunakan pada insert data
 */
class CrudTest extends ValidateContract{
    
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
        customer.setId("2");
        customer.setName("Ujang");
        customer.setPrimaryEmail("ujang@test.com");
        customer.setMarried(true);
        customer.setAge((byte) 29);
        customer.setGender(CustomerGender.MALE);

        validate(customer);
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

        Customer customer = entityManager.find(Customer.class, "2");
        entityManager.remove(customer);

        entityTransaction.commit();
        entityManager.close();
    }

}
