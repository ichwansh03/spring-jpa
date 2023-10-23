package com.ichwan.jpa;

import com.ichwan.jpa.entity.singletable.Employee;
import com.ichwan.jpa.entity.singletable.Manager;
import com.ichwan.jpa.entity.singletable.VicePresident;
import com.ichwan.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InheritanceTest {

    @Test
    void singleInheritanceInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Employee employee = new Employee();
        employee.setId("abdul");
        employee.setName("Abdullah");
        entityManager.persist(employee);

        Manager manager = new Manager();
        manager.setId("ahmad");
        manager.setName("Ahmad Ali");
        manager.setTotalEmployee(10);
        entityManager.persist(manager);

        VicePresident vp = new VicePresident();
        vp.setId("andi");
        vp.setName("Andi Susanto");
        vp.setTotalManager(7);
        entityManager.persist(vp);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void singleInheritanceFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Manager manager = entityManager.find(Manager.class, "ahmad");
        Assertions.assertEquals("Ahmad Ali", manager.getName());

        entityTransaction.commit();
        entityManager.close();
    }
}
