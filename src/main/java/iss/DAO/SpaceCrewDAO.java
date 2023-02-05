package iss.DAO;

import iss.model.SpaceCrew;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SpaceCrewDAO {

    private static SessionFactory sessionFactory;

    public void create(SpaceCrew spaceCrew) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(spaceCrew);
        transaction.commit();
        session.close();
    }

    public List<SpaceCrew> loadSpaceCrew() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<SpaceCrew> spaceCrewList = session
                .createQuery("SELECT * FROM members", SpaceCrew.class)
                .getResultList();
        int length = spaceCrewList.toArray().length;
        transaction.commit();
        SpaceCrew spaceCrew = spaceCrewList.get(length - 1);
        session.close();
        return spaceCrewList;
    }
}
