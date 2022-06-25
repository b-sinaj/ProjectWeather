package repository;

import model.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LocationRepository {

    public Location savecourse(Location course) {
        // krijimi i nje session factory
        SessionFactory factory= new Configuration()
                .configure()
                .addAnnotatedClass(Location.class)
                .buildSessionFactory();
        // nga session factory do marrim nje session
        Session session= factory.getCurrentSession();
        //do startojme nje transaksion nepermjet sessionit
        session.beginTransaction();
        //kryejme nje save(insert) nepermjet session e cila merr nje objekt qe eshte nje entity
        session.save(course);
        //commit transaksion nepermjet session
        session.getTransaction().commit();
        //close session factory
        factory.close();
        return course;
    }

}
