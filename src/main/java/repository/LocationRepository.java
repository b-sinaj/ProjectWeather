package repository;

import config.HibernateConfig;
import model.Location;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class LocationRepository {
    private HibernateConfig HibernateUtil;
    Session session = HibernateUtil.getSessionFactory().openSession();

    //create location by location object
    public Location createLocation(Location location) {
        Session s = session.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(location);
        s.getTransaction().commit();
        s.close();
        return location;
    }

    //retrive location by ID
    public Location getLocationById(int id) {
        Session s = session.getSessionFactory().openSession();
        Location location = s.get(Location.class, id);
        s.close();
        return location;
    }

    //update location by a location object
    public void updateLocation(Location location) {
        Session s = session.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(location);
        s.getTransaction().commit();
        s.close();
    }

    //delete Location by a location object
    public void deleteLocation(Integer id) {
        Session s = session.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(getLocationById(id));
        s.getTransaction().commit();
        s.close();
    }

    //display all location
    public List<Location> getAllLocation() {
        List<Location> results = null;
        try {
            CriteriaQuery<Location> criterias = session.getCriteriaBuilder().createQuery(Location.class);
            criterias.from(Location.class);
            results = session.createQuery(criterias).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;

    }
}
