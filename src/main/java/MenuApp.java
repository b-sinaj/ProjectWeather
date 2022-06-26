import model.Location;
import repository.LocationRepository;
import service.MenuService;

public class MenuApp {

    private static MenuService menuService = new MenuService();

    public static void main(String[] args) {
        menuService.init();
    }

}
