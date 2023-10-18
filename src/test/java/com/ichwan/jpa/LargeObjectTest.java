package com.ichwan.jpa;

import com.ichwan.jpa.entity.Customer;
import com.ichwan.jpa.entity.CustomerGender;
import com.ichwan.jpa.entity.Images;
import com.ichwan.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeObjectTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void insertDataImage() throws IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Images images = new Images();
        images.setName("image example");
        images.setDescription("image description");

        byte[] bytes = Files.readAllBytes(Path.of(getClass().getResource("/images/6.png").getPath()));

        images.setImage(bytes);
        entityManager.persist(images);
        entityTransaction.commit();
        entityManager.close();
    }

}
