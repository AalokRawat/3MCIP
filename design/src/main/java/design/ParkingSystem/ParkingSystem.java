package design.ParkingSystem;

import java.util.Date;
import java.util.HashMap;

public class ParkingSystem {

    public static void main(String[] args) {

    }
}

abstract class ParkingSpot {
    private int id;
    private boolean isFree;

    public boolean isFree() {
        return isFree;
    }
    public abstract boolean assignVehicle(Vehicle vehicle);
    public boolean removeVehicle() {
        return true;
    }
}

abstract class Vehicle {
    private String vehicleNumber;
    abstract void assignTicket(ParkingTicket ticket);
}

abstract class Payment {
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public abstract boolean initiateTransaction();
}

class ParkingTicket {
    private int ticketNo;
    private long issuedAt;
    private long revokedAt;
    private double amount;

    private Vehicle vehicle;
    private Payment payment;
    private Entry entry;
    private Exit exit;
}

class Entry {
    private int id;
    public ParkingTicket issueTicket() {
        return null;
    }
}

class Exit {
    private int id;
    public boolean validateTicket(ParkingTicket ticket) {
        return true;
    }
}

enum PaymentStatus {
    SUCCESS, FAILURE
}

class ParkingLot {
    private ParkingLot parkingLot;
    HashMap<Integer, Entry> entries;
    HashMap<Integer, Exit> exits;
    private HashMap<Integer, ParkingTicket> tickets;

    private ParkingLot() {
    }

    public ParkingLot getInstance() {
        if(parkingLot==null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public ParkingTicket issueTicket(int entranceId, Vehicle vehicle) {
        return null;
    }

    public boolean processExit(int exitId, int ticketId) {
        return true;
    }

    public boolean isSpotAvailable(Vehicle vehicle) {
        return true;
    }
}

