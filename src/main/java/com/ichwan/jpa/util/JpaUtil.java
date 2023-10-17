package com.ichwan.jpa.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory entityManagerFactory = null;

    /**
     * jika entityManagerFactory null, maka buat entity melalui file persistence.xml,
     * jika sudah ada, maka balikan nilai entityManagerFactory.
     */
    public static EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
        }

        return entityManagerFactory;
    }
}
