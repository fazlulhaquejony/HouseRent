package com.fjthechsolutions.houserent.sessionfactoryexecutor;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryCreator {

    private  SessionFactory sessionFactory;

    private  SessionFactoryCreator(String dataBase)
    {
        System.out.println("hbm file==="+dataBase);
       sessionFactory = new Configuration()
                       .configure("" +
                               dataBase+".hbm.cfg.xml").buildSessionFactory();


    }

    public static SessionFactory getConnection(String db) {
        System.out.println("hbm file1==="+db);

        if (db.isEmpty()) {
            //db = "houseresntmysql";
            db = "houserentpostgre";
            System.out.println("hbm file1==="+db);

        }
        return new SessionFactoryCreator(db).sessionFactory;
    }

}
