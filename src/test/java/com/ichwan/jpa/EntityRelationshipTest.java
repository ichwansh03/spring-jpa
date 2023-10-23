package com.ichwan.jpa;

import com.ichwan.jpa.entity.onetomany.Brand;
import com.ichwan.jpa.entity.onetomany.Product;
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

import java.util.HashSet;

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

    @Test
    void oneToOneInsertProductTest() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("xiaomi");
        brand.setName("XIAOMI");
        manager.persist(brand);

        Product product = new Product();
        product.setId("p1");
        product.setName("Xiaomi REDMI 6A");
        product.setBrand(brand);
        product.setPrice(1000000L);
        manager.persist(product);

        Product product2 = new Product();
        product2.setId("p2");
        product2.setName("Xiaomi REDMI 5A");
        product2.setBrand(brand);
        product2.setPrice(800000L);
        manager.persist(product2);

        transaction.commit();
        manager.close();
    }

    @Test
    void manyToManyInsertTest() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        User user = manager.find(User.class, "ichwan");
        user.setLikes(new HashSet<>());

        Product product1 = manager.find(Product.class, "p1");
        Product product2 = manager.find(Product.class, "p2");

        user.getLikes().add(product1);
        user.getLikes().add(product2);

        manager.merge(user);

        transaction.commit();
        manager.close();
    }

    @Test
    void manyToManyUpdateTest() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        User user = manager.find(User.class, "ichwan");
        user.getLikes().forEach(product -> System.out.println(product.getName()));

        transaction.commit();
        manager.close();
    }
}
