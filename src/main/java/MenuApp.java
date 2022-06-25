import model.Location;
import repository.LocationRepository;

public class MenuApp {

    public static void main(String[] args) {
        LocationRepository locationRepository=new LocationRepository();
        Location location= createLocation();

    }

    public static Location createLocation(){
        Location location=new Location();
        location.setCity("Tirana");
        location.setCountry("Albania");
        location.setLatitude(41.34375340389631);
        location.setLongitude(19.839559454999115);
        return location;
    }
}
