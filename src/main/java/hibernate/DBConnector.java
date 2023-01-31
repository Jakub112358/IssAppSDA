package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBConnector {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(SpaceCrew.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        SpaceCrew crewMember1 = new SpaceCrew(1, "Jan Kowalski", "Syrenka");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(crewMember1);
        transaction.commit();
        session.close();
    }
}
