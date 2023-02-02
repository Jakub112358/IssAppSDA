package iss.DAO;

import iss.model.ISSLocation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ISSLocationDao implements IDAO <ISSLocation> {
    private static SessionFactory sessionFactory;

    public ISSLocationDao() {
        sessionFactory = DBConnector.getInstance().getSessionFactory();
    }

    public Boolean create(ISSLocation issLocation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(issLocation);
        transaction.commit();
        session.close();
        return true;
    }

    public ISSLocation loadISSLocation() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ISSLocation> issLocationList = session.createQuery("SELECT * FROM craft_info", ISSLocation.class)
                .getResultList();
        int length = issLocationList.toArray().length;
        transaction.commit();
        ISSLocation issLocation = issLocationList.get(length - 1);
        session.close();
        return issLocation;
    }

//    to delete in release version
    public ISSLocation createFakeISSLocation(){
        return new ISSLocation(5, 70.4554, 120.8342);
    }
}

