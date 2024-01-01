package com.fjthechsolutions.houserent.repository;

import com.fjthechsolutions.houserent.model.RenterDetails;
import com.fjthechsolutions.houserent.sessionfactoryexecutor.SessionFactoryCreator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.text.SimpleDateFormat;


@Repository
public class RenterDetailsRepoImp implements  RenterDetailsRepo{

    Session session;

    public RenterDetails getRenter() {

        try{
            session = SessionFactoryCreator.getConnection("").getCurrentSession();

            session.beginTransaction();

            RenterDetails renterDetails = new RenterDetails();
            //new SimpleDateFormat("dd/MM/yyyy").parse("2023:02:02");
            renterDetails.setStartDate((new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-02")));
            renterDetails.setEndDate((new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-02")));
            session.persist(renterDetails);
            session.getTransaction().commit();

        }
        catch(Exception e)
        {
            session.close();
        }
        return null;
    }

    /*public static void main(String[] args)
    {
        Session session = null;
        session = SessionFactoryCreator.getConnection("").openSession();
        try{
           // session = SessionFactoryCreator.getConnection("").openSession();

            session.beginTransaction();

            RenterDetails renterDetails = new RenterDetails();
            //new SimpleDateFormat("dd/MM/yyyy").parse("2023:02:02");
            renterDetails.setStartDate((new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-02")));
            renterDetails.setEndDate((new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-02")));
           // session.persist(renterDetails);
            session.getTransaction().commit();

        }
        catch(Exception e)
        {
            System.out.println("connection error"+ e);
            if(session!=null) {
                session.close();
            }
        }

    }*/

    @Override
    public RenterDetails getRenterDetails() {
        session = SessionFactoryCreator.getConnection("houseresntmysql").getCurrentSession();

        return (RenterDetails) session.createQuery("from RenterDetails").getSingleResult();
    }
}
