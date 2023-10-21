package com.ichwan.jpa;

import com.ichwan.jpa.entity.onetoone.Credential;
import com.ichwan.jpa.entity.onetoone.User;
import com.ichwan.jpa.entity.onetoone.Wallet;
import com.ichwan.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class EntityRelationshipTest {

    @Test
    void oneToOneInsertTest() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Credential credential = new Credential();
        credential.setId("ichwan");
        credential.setEmail("ichwansh@gmail.com");
        credential.setPassword("123A");
        manager.persist(credential);
        Assertions.assertNotNull(credential);

        User user = new User();
        user.setId("ichwan");
        user.setName("Ichwan Sholihin");
        manager.persist(user);
        Assertions.assertNotNull(user);

        transaction.commit();
        manager.close();
    }

    @Test
    void oneToOneFindTest() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        User user = manager.find(User.class, "ichwan");
        Assertions.assertEquals("ichwansh@gmail.com", user.getCredential().getEmail());
        Assertions.assertEquals("123A", user.getCredential().getPassword());

        transaction.commit();
        manager.close();
    }

    @Test
    void oneToOneInsertWalletTest() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        User user = manager.find(User.class, "ichwan");

        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(1000000L);
        manager.persist(wallet);

        transaction.commit();
        manager.close();
    }

    @Test
    void oneToOneFindWalletTest() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        User user = manager.find(User.class, "ichwan");
        Assertions.assertEquals("ichwansh@gmail.com", user.getCredential().getEmail());
        Assertions.assertEquals("123A", user.getCredential().getPassword());
        Assertions.assertEquals(1000000L, user.getWallet().getBalance());
        transaction.commit();
        manager.close();
    }
}
