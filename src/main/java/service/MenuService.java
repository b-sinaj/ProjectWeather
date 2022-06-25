package service;

import model.CurrentResponse;
import model.Location;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import repository.LocationRepository;

import javax.sound.midi.Soundbank;
import java.util.Currency;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    private LocationRepository locationRepository=new LocationRepository();

    public void init(){
        printHeader();
        printMenu();
    }

    private void printHeader(){
        System.out.println("Welcome to WeatherAPP");
    }


    private void printMenu(){
        System.out.println("------------------ MAIN MENU -------------------");
        System.out.println("1. ADD Location ");
        System.out.println("2. List Location");
        System.out.println("3. Get Weather Data");
        System.out.println("4. Exit APP");
        System.out.println("-----------------Action require--------------------");
        System.out.print("Please choose a number : ");
        String input= readInput();
        printMenuByInput(input);
    }

    private void printMenuByInput(String input){
        switch (input){
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

        }
        if (input.isEmpty()){
            System.out.println("Please give a number ! ");
            printMenu();
        }
        else {
            System.out.println("Please give a correct number !");
            printMenu();
        }
        }
    private void getWeatherData() {
        System.out.println("Enter the city name: ");
        String input= readInput();
        WeatherService weatherService=new WeatherService();
        CurrentResponse response= weatherService.getWeatherFromCity(input);
        if (response==null){
            System.out.println("Nuk kemi informacion per kete qytet!");
        }
        System.out.println("Temperatura : " +response.getTemperature() );
        System.out.println("Drejtimi i eres  : " +response.getWindDir() );
        System.out.println("Shpejtesia e eres : " +response.getWindSpeed());

    }

    private void printListOfLocation() {
        System.out.println("-----------------All list of Locations----------------- ");
        List<Location> allLocations = locationRepository.getAllLocation();
        allLocations.forEach(l -> {
            System.out.println("Country: "+ l.getCountry() + "  City : " + l.getCity() + "  ID:  "+l.getCityId());
        });
        System.out.println("------------------FINISHED-------------------");
    }

    private void printAddLocationMenu(){
        System.out.print("Country: " );
        String country = readInput();
        System.out.print("City : ");
        String city=readInput();
        Location location=new Location();
        location.setCountry(country);
        location.setCity(city);
        locationRepository.createLocation(location);

        System.out.println("Saved successfully");
    }

    private String readInput(){
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        if (input.equals("4")){
            System.out.println("System is shuting down");
            System.exit(1);
        }
        return input;
    }

}
