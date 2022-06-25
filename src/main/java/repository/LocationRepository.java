package repository;

import model.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LocationRepository {

    Session session=HibernateUtil.getSessionFactory().openSession();

    //create location by location opbject

    public Location createLocation(Location location){
        Session s=session.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(location);
        s.getTransaction().commit();
        s.close();
        return location;
    }

    //retrive location by ID
    public Location getLocationById (int id) {
        Session s = session.getSessionFactory().openSession();
        Location location= s.get(Location.class , id);
        s.close();
        return location;
    }

    //update location by a location object
    public  void updateLocation(Location location){
        Session s = session.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(location);
        s.getTransaction().commit();
        s.close();
    }

    //delete Location by a location object
    public void deleteLocation(Location location){
        Session s= session.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(location);
        s.getTransaction().commit();
        s.close();
    }

}
