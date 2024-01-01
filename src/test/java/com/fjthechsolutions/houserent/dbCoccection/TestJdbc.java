package com.fjthechsolutions.houserent.dbCoccection;


import com.fjthechsolutions.houserent.model.RenterDetails;
import com.fjthechsolutions.houserent.sessionfactoryexecutor.SessionFactoryCreator;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;

@SpringBootTest
public class TestJdbc {
    
    @Test
    public void save()
    {
        Session session = null;
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
            if(session!=null)
            {
                session.close();
            }

        }
    }
    
    
}
