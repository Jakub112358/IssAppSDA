package iss.DAO;

import iss.model.SpaceCrew;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SpaceCrewDao implements IDAO <SpaceCrew> {
    private static SessionFactory sessionFactory;

    public SpaceCrewDao() {
        sessionFactory = DBConnector.getInstance().getSessionFactory();
    }


    @Override
    public Boolean create(SpaceCrew spaceCrew) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(spaceCrew);
        transaction.commit();
        session.close();
        return true;
    }

    //to delete in release version ;)
    public SpaceCrew createFakeSpaceCrew(){
        return new SpaceCrew("Jan Kowalski", "Syrenka");
    }
}
