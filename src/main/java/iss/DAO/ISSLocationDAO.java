package iss.DAO;

import iss.model.ISSLocation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ISSLocationDAO {

    private SessionFactory sessionFactory;

    public void create(List<ISSLocation> issLocation) {
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
                .createQuery("SELECT * FROM iss_location", ISSLocation.class)
                .getResultList();
        int length = issLocationList.toArray().length;
        transaction.commit();
        ISSLocation issLocation = issLocationList.get(length - 1);
        session.close();
        return issLocationList;
    }
}

