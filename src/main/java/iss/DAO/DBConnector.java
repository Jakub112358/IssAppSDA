package iss.DAO;

import iss.model.ISSLocation;
import iss.model.SpaceCrew;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnector {
    private static DBConnector instance;
    private SessionFactory sessionFactory;

    private DBConnector() {
        connect();
    }

    public static DBConnector getInstance(){
        if (instance == null){
            instance = new DBConnector();
        }
        return instance;
    }

    private void connect(){
         Configuration configuration = new Configuration();
         configuration.addAnnotatedClass(SpaceCrew.class);
         configuration.addAnnotatedClass(ISSLocation.class);
         configuration.configure("hibernate.cfg.xml");
         sessionFactory = configuration.buildSessionFactory();
     }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
