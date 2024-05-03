package design.CarRental;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalSystemSoftware {
    public static void main(String[] args) {

    }
}

abstract class User {

    abstract public boolean book();

}

class Customer extends User {

    @Override
    public boolean book() {
        return false;
    }
}

class Receptionist extends User {

    @Override
    public boolean book() {
        return false;
    }
}


///////////////////////

abstract class Vehicle {
    String id;
    Category category;
    SubCategory subCategory;
}

abstract class Car extends Vehicle {
    public Car() {
        this.category=Category.CAR;
    }
}

abstract class Trucks extends Vehicle {
    public Trucks() {
        this.category=Category.TRUCK;
    }
}

abstract class Van extends Vehicle {
    public Van() {
        this.category=Category.VAN;
    }
}

abstract class Motorcycle extends Vehicle {
    public Motorcycle() {
        this.category=Category.MOTORCYCLE;
    }
}

class EconomyCar extends Car {
    public EconomyCar() {
        this.subCategory=SubCategory.ECONOMY;
    }
}

class LuxuryCar extends Car {
    public LuxuryCar() {
        this.subCategory=SubCategory.LUXURY;
    }
}

class StandardCar extends Car {
    public StandardCar() {
        this.subCategory=SubCategory.STANDARD;
    }
}

class CompactCar extends Car {
    public CompactCar() {
        this.subCategory=SubCategory.COMPACT;
    }
}

class PassengerVan extends Van {
    public PassengerVan() {
        this.subCategory=SubCategory.PASSENGER;
    }
}

class CargoVan extends Van {
    public CargoVan() {
        this.subCategory=SubCategory.CARGO;
    }
}

class CruiserBike extends Motorcycle {
    public CruiserBike() {
        this.subCategory=SubCategory.CRUISE;
    }
}

class TouringBike extends Motorcycle {
    public TouringBike() {
        this.subCategory=SubCategory.TOURING;
    }
}

class SportsBike extends Motorcycle {
    public SportsBike() {
        this.subCategory=SubCategory.SPORTS;
    }
}

class LightTruck extends Trucks {
    public LightTruck() {
        this.subCategory=SubCategory.LIGHT;
    }
}

class MediumTruck extends Trucks {
    public MediumTruck() {
        this.subCategory=SubCategory.MEDIUM;
    }
}

class HeavyTruck extends Trucks {
    public HeavyTruck() {
        this.subCategory=SubCategory.HEAVY;
    }
}

enum Category {
    CAR, TRUCK, VAN, MOTORCYCLE
}

enum SubCategory {
    ECONOMY, LUXURY, STANDARD, COMPACT, // Car
    PASSENGER, CARGO,                   // Van
    CRUISE, TOURING, SPORTS,            // Motorcycle
    LIGHT, MEDIUM, HEAVY                // Truck
}

///////////////////////////////////

class Reservations {
    User user;
    Vehicle vehicle;

    Date startTime;
    Date endTime;
}



class CarRentalSystem {
    Map<Category, Map<SubCategory, List<Vehicle>>> vehicles = new ConcurrentHashMap<>();
    Map<String, Reservations> VehicleReservations = new ConcurrentHashMap<>();
    Map<String, Reservations> userBookings = new ConcurrentHashMap<>();
}