package repository;

import model.Location;
import model.Weather;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class WeatherRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();
    static Location location = new Location();


    //ruajtja e nje weatheri
    public void insertWeather(Weather weather ) {
        Session s = session.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(weather);
        s.getTransaction().commit();
        s.close();
    }
    //marrja e weatherit nga ID
    public Weather getWeatherById(int id){
        Session s = session.getSessionFactory().openSession();
        Weather add = s.get(Weather.class, id);
        s.close();
        return add;
    }
    //updatimi i weatherit
    public void updateWeather(Weather weather) {
        Session s = session.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(weather);
        s.getTransaction().commit();
        s.close();
    }
    //  fshirja e weatherit
    public void deleteWeather(Weather weather){
        Session s = session.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(weather);
        s.getTransaction().commit();
        s.close();
    }
    //  marrjae  weatherit nha Location ID
    public Weather getWeatherByLocation(int location_id){
        Session s = session.getSessionFactory().openSession();
        Query q = s.createQuery("from Weather add where add.location.id =: id");
        q.setParameter("id", location_id);
        Weather add =(Weather) q.getSingleResult();
        s.close();
        return add;
    }
    //  marrja e gjithe listes se weatherit
    public List<Weather> findAll(){
        Session s = session.getSessionFactory().openSession();
        List<Weather> list = s.createQuery("from Weather").list();
        s.close();
        return list;
    }

}
