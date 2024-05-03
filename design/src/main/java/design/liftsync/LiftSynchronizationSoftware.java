package design.liftsync;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LiftSynchronizationSoftware {

    public static void main(String[] args) throws InterruptedException {
        LiftSynchronizer l = LiftSynchronizer.getInstance(3);

        l.call(20);
        Thread.sleep(1100);
        l.call(10);
        l.call(5);
        Thread.sleep(1100);
        l.call(0);
        l.call(2);
    }
}

enum Direction {
    UP, DOWN, ATREST
}
class Lift {
    private int currentFloor;
    private Direction direction;
    private final TreeSet<Integer> stops;
    private Runnable r;

    public Lift() {
        currentFloor=0;
        direction=Direction.ATREST;
        stops = new TreeSet<>();
        r = () -> {
            try {
                moving();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private void moving() throws InterruptedException {
        while(!stops.isEmpty()) {

            Integer first = stops.first();
            if(currentFloor == first) {
                stopAtFloor(currentFloor);
            }

            if(currentFloor< first) {
                direction = Direction.UP;
                Integer last = stops.last();
                for(int i = currentFloor+1; i<= last; i++) {
                    if(stops.contains(i)) {
                        stopAtFloor(i);
                    }
                }
            } else {
                direction = Direction.DOWN;
                for(int i = currentFloor-1; i>= first; i--) {
                    if(stops.contains(i)) {
                        stopAtFloor(i);
                    }
                }
            }
        }
    }

    private void stopAtFloor(int currentFloor) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ ": In Floor: "+ currentFloor);
        stops.remove(currentFloor);
        this.currentFloor = currentFloor;
        if(stops.isEmpty()) {
            direction = Direction.ATREST;
        }
        Thread.sleep(1000);
    }

    public TreeSet<Integer> getStops() {
        return stops;
    }

    public void addStop(Integer stop) {
        stops.add(stop);
        if (stops.size()==1) {
            new Thread(r).start();
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}

class LiftSynchronizer {
    private static LiftSynchronizer liftSynchronizer;
    private final List<Lift> lifts = new ArrayList<>();

    private LiftSynchronizer(int n) {
        for(int i=0; i<n; i++) {
            lifts.add(new Lift());
        }
    }

    public static LiftSynchronizer getInstance(int n) {
        if(liftSynchronizer ==null) {
            liftSynchronizer = new LiftSynchronizer(n);
        }
        return liftSynchronizer;
    }

    public void call(int floor) {
        System.out.println("Lift: "+ findLift(floor));
    }

    private int findLift(int floor) {
        int liftId=0, minDistance=Integer.MAX_VALUE;
        for (int i=0; i<lifts.size(); i++) {
            Lift lift = lifts.get(i);
            int currFloor = lift.getCurrentFloor();
            Direction direction = lift.getDirection();

            if(currFloor==floor && direction.equals(Direction.ATREST)) {
                liftId = i;
            }
            if(lift.getStops().contains(floor)) {
                liftId = i;
            }

            int distance = calculateDist(lift, floor);
            if (minDistance > distance) {
                minDistance=distance;
                liftId=i;
            }
        }
        lifts.get(liftId).addStop(floor);
        return liftId;
    }

    private int calculateDist(Lift lift, int reqFloor) {
        int currFloor = lift.getCurrentFloor();
        Direction direction = lift.getDirection();

        if(currFloor-reqFloor<0 && Direction.DOWN.equals(direction)) {
            return reqFloor-findMin(lift.getStops());
        }
        if(currFloor-reqFloor>0 && Direction.UP.equals(direction)) {
            return findMax(lift.getStops())-reqFloor;
        }

        return Math.abs(currFloor-reqFloor);
    }

    private int findMin(TreeSet<Integer> stops) {
        return stops.first();
    }

    private int findMax(TreeSet<Integer> stops) {
        return stops.last();
    }
}
