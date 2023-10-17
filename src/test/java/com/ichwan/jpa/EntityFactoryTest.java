package com.ichwan.jpa;

import com.ichwan.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EntityFactoryTest {

    @Test
    void createEntity() {
        EntityManagerFactory managerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager manager = managerFactory.createEntityManager();

        manager.close();
        Assertions.assertNotNull(managerFactory);
    }
}
