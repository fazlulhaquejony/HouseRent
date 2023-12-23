package com.fjthechsolutions.houserent.sessionfactoryexecutor;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



import java.util.HashMap;
import java.util.List;

import static com.fjthechsolutions.houserent.sessionfactoryexecutor.AllClassLoader.getClasses;

public class SessionFactoryCreator {

    private static HashMap<String, SessionFactory> sessionFactoryExecutor = new HashMap<>();

    private SessionFactoryCreator(String dataBase)
    {
        if(sessionFactoryExecutor.get(dataBase)==null)
        {
         StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure(dataBase + ".hbm.cfg.xml").build();
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

            List<Class<?>> classes=  getClasses("com.fjthechsolutions.houserent");


            for(Class<?> packegeClass : classes)
             {
                 metadataSources.addAnnotatedClass(packegeClass);

             }
            sessionFactoryExecutor.put(dataBase,metadataSources.buildMetadata().buildSessionFactory());
      }

    }

    public static SessionFactory getConnection(String db) {
        if (sessionFactoryExecutor.get(db) == null) {
            new SessionFactoryCreator(db);
        }
        return sessionFactoryExecutor.get(db);
    }

}
