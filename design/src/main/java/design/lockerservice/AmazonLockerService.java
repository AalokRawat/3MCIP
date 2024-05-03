package design.lockerservice;

import java.util.Date;
import java.util.List;

public class AmazonLockerService {

}

abstract class Item {
    private String itemId;
    private Dimension dimension;

    public String getItemId() {
        return itemId;
    }

    public Dimension getDimension() {
        return dimension;
    }
}

class Package {
    private String packageId;
    private String lockerId;
    private String userId;
    private PackageStatus status;
    private List<Item> items;
    private Address from;
    private Address to;

    public String getPackageId() {
        return packageId;
    }

    public String getUserId() {
        return userId;
    }

    public PackageStatus getStatus() {
        return status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateStatus(PackageStatus status) {
        this.status = status;
    }

    public Dimension getSize() {
        return null;
    }
}

abstract class Locker {
    private String lockerId;
    private Date dueDate;
    private LockerStatus lockerStatus;

    public String getLockerId() {
        return lockerId;
    }
}

class LockerCenter {
    List<Locker> lockers;
    Address lockerAddress;
    Date openTime;
    Date closeTime;
}

abstract class User {
    String userId;
}

class Customer extends User {
    LockerService ls;
}

class LockerService{

    public String requestLockerNearMe(String userId, String packageId) {
        return null;
    }

    public boolean assignLocker(String packageId, String lockerId) {
        return true;
    }

}

class PackageService {

    public void dispatch(String packageId) {

    }


    public void shipped(String packageId) {

    }


    public void delivered(String packageId) {

    }
}

class Scheduler {
    List<Package> packages;
}






///////////////////////

class Dimension {
    private int l, b, h;
}

enum PackageStatus {
    DISPATCHED,
    SHIPPED,
    DELIVERED
}

enum LockerStatus {
    ALLOCATED,
    CLOSED
}

class Address {

}


// customer can choose the nearest location for package from the locker
// The locker is assigned to the customer based on the size of the order package.