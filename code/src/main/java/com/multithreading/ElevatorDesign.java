//package MultiThreading;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Executors;
//import java.util.stream.Collectors;
//
//public class ElevatorDesign {
//
//  public static void main(String[] args) {
//
//  }
//}
//
//enum State {
//  UP,
//  DOWN,
//  STATIC
//}
//
//class Lift {
//  private LiftManagementSystem lms;
//  int liftId;
//  State state;
//  int[] stops;
//  int lowest;
//  int highest;
//  int current;
//
//  public Lift(int liftId, int fromFloor, int toFloor, lms) {
//    this.liftId = liftId;
//    this.state = State.STATIC;
//    this.stops = new int[toFloor-fromFloor];
//    this.lowest = fromFloor;
//    this.highest = toFloor;
//    this.current = fromFloor;
//    this.lms = lms;
//  }
//
//  public void addStop(int floor) {
//    if(floor<lowest && floor > highest)
//      throw new RuntimeException("Requested floor is not available");
//    stops[floor]=1;
//  }
//
//  public void doStop() throws InterruptedException {
//    if (stops[current]==1) {
//      Thread.sleep(200);
//      stops[current]=0;
//    }
//  }
//
//  public void execute() {
//    if ( state == State.STATIC) {
//      lms.
//    }
//  }
//
//}
//
//class LiftManagementSystem {
//
//  private static LiftManagementSystem lms = null;
//  private List<Lift> lifts;
//  private int[] reqStopsUp;
//  private int[] reqStopsDown;
//  private int lowest;
//  private int highest;
//
//  private LiftManagementSystem(int fromFloor, int toFloor) {
//    this.lifts = new ArrayList<>();
//    this.reqStopsUp = new int[toFloor-fromFloor];
//    this.reqStopsDown = new int[toFloor-fromFloor];
//    this.lowest = fromFloor;
//    this.highest = toFloor;
//  }
//
//  public static LiftManagementSystem init(int fromFloor, int toFloor) {
//    if (lms == null) {
//      lms = new LiftManagementSystem(fromFloor, toFloor);
//    }
//    return lms;
//  }
//
//  public void addLift(Lift lift) {
//    lifts.add(lift);
//  }
//
//  public synchronized void reqLift(int fromFloor, State state) {
//    if(state==State.UP && fromFloor<highest)
//      reqStopsUp[fromFloor]=1;
//    else if(state==State.DOWN && fromFloor>lowest)
//      reqStopsDown[fromFloor]=1;
//
//      Executors.newSingleThreadExecutor().execute(() -> {
//        List<Lift> lifts1 =  lifts.stream()
//            .filter(lift1 -> (lift1.state!=state)
//                || (lift1.current<fromFloor && lift1.state==State.DOWN)
//                || (lift1.current>fromFloor && lift1.state==State.UP))
//            .collect(Collectors.toList());
//        Lift minLift = null;
//        int dist=Integer.MAX_VALUE;
//        for (Lift lift1 : lifts1) {
//          if(dist>Math.abs(lift1.current-fromFloor)) {
//            dist = Math.abs(lift1.current-fromFloor);
//            minLift = lift1;
//          }
//        }
//        if(minLift!=null)
//          minLift.execute();
//      });
//  }
//
//  public synchronized boolean serveStop(int floor, State state) {
//    boolean stop=false;
//    int[] stops = null;
//    if (state == State.UP) {
//      stops = reqStopsUp;
//    } else if (state == State.DOWN) {
//      stops = reqStopsDown;
//    }
//
//    if(stops[floor]==1) {
//      stop=true;
//      stops[floor]=0;
//    }
//    return stop;
//  }
//}
