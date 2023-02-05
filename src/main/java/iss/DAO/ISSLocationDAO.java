package iss.DAO;

import iss.model.ISSLocation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ISSLocationDAO {

    private static SessionFactory sessionFactory;

    public ISSLocationDAO() {
        sessionFactory = DBConnector.getInstance().getSessionFactory();
    }

    public void create(ISSLocation issLocation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(issLocation);
        transaction.commit();
        session.close();
    }

    public List<ISSLocation> loadISSLocation() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ISSLocation> issLocationList = session
                .createQuery("from ISSLocation", ISSLocation.class)
                .getResultList();
        int length = issLocationList.toArray().length;
        transaction.commit();
        ISSLocation issLocation = issLocationList.get(length - 1);
        session.close();
        return issLocationList;
    }
}

