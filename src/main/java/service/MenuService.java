package service;

import model.CurrentResponse;
import model.Location;
import repository.LocationRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    private LocationRepository locationRepository = new LocationRepository();

    public void init() {
        printHeader();
        printMenu();
    }

    private void printHeader() {
        System.out.println("Welcome to WeatherAPP");
    }


    private void printMenu() {
        System.out.println("------------------ MAIN MENU -------------------");
        System.out.println("0. Exit APP");
        System.out.println("1. ADD Location ");
        System.out.println("2. List Location");
        System.out.println("3. Get Weather Data");
        System.out.println("4. Delete Weather Data");
        System.out.println("-----------------Action required----------------");
        System.out.print("Please choose a number : ");
        String input = readInput();
        printMenuByInput(input);
    }

    private void printMenuByInput(String input) {
        switch (input) {
            case "1":
                printAddLocationMenu();
                printMenu();
                break;
            case "2":
                printListOfLocation();
                printMenu();
                break;
            case "3":
                getWeatherData();
                printMenu();
                break;
            case "4":
                deleteWeatherData();
                printMenu();
                break;
        }
        if (input.isEmpty()) {
            System.out.println("Please give a number ! ");
            printMenu();
        } else {
            System.out.println("Please give a correct number !");
            printMenu();
        }
    }

    private void deleteWeatherData() {
        System.out.println("Enter the City ID to delete the Location: ");
        Scanner scanner = new Scanner(System.in);
        Integer inputId = scanner.nextInt();
        locationRepository.deleteLocation(inputId);
        System.out.println("The Location is successfully deleted!");
    }

    private void getWeatherData() {
        System.out.println("Enter the city name that you want to read the data : ");
        String input = readInput();
        WeatherService weatherService = new WeatherService();
        CurrentResponse response = weatherService.getWeatherFromCity(input);
        if (response == null) {
            System.out.println("We do not have an information for this City !");
        }
        System.out.println("Temperature : " + response.getTemperature());
        System.out.println("Wind Direction : " + response.getWindDir());
        System.out.println("Wind speed : " + response.getWindSpeed());

    }

    private void printListOfLocation() {
        System.out.println("-----------------All list of Locations-----------------");
        List<Location> allLocations = locationRepository.getAllLocation();
        allLocations.forEach(l -> {
            System.out.println("Country: " + l.getCountry() + "  City : " + l.getCity() + "  ID:  " + l.getCityId());
        });
        System.out.println("-----------------FINISHED------------------------------");
    }

    private void printAddLocationMenu() {
        System.out.print("Country: ");
        String country = readInput();
        System.out.print("City : ");
        String city = readInput();
        Location location = new Location();
        location.setCountry(country);
        location.setCity(city);
        locationRepository.createLocation(location);
        System.out.println("New Location is saved successfully!");
    }

    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("0")) {
            System.out.println("System is shutting down");
            System.exit(1);
        }
        return input;
    }

}
