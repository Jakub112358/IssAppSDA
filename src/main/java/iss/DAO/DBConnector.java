package iss.DAO;

import iss.model.ISSLocation;
import iss.model.ISSVelocity;
import iss.model.SpaceCrew;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnector {
    private DBConnector instance;
    private SessionFactory sessionFactory;

    DBConnector() {
        connect();
    }

    DBConnector getInstance(){
        if (instance == null){
            instance = new DBConnector();
        }
        return instance;
    }

    SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private void connect(){
         Configuration configuration = new Configuration();
         configuration.addAnnotatedClass(SpaceCrew.class);
         configuration.addAnnotatedClass(ISSLocation.class);
         configuration.addAnnotatedClass(ISSVelocity.class);
         configuration.configure("hibernate.cfg.xml");
         sessionFactory = configuration.buildSessionFactory();
     }
}
