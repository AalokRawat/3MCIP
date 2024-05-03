package design.meetingscheduler;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingSchedulerService {
}

class MeetingScheduler {
    private Map<String, Room> roomNameToRoom;
    private List<User> users;
    private MeetingScheduler meetingScheduler = null;

    public MeetingScheduler getInstance() {
        if(meetingScheduler==null) {
            meetingScheduler= new MeetingScheduler();
        }
        return meetingScheduler;
    }

    public String scheduleMeeting(Booking booking) {
        Room room = findRoom(booking.getDate(), booking.getStartTime(), booking.getEndTime(), booking.getParticipants().size() + 1);
        room.book(booking);
        return "bookingId";
    }

    public boolean cancelMeeting(Booking booking) {
        booking.getRoom().release(booking);
        return true;
    };

    private Room findRoom(Date date, Time startTime, Time endTime, int capacity) {
        roomNameToRoom.entrySet();
        return null;
    }

}

class Room {
    private String name;
    private int capacity;
    private Schedule schedule;
    private Notification notification;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable(Booking booking) {
        // Check if the room is free for the request date and time.
        return true;
    }

    public boolean book(Booking booking) {
        boolean isBooked = isAvailable(booking) && schedule.getDateToBookings().get(booking.getDate()).add(booking);
        if(isBooked) {
            booking.getParticipants().keySet().forEach(participant -> notification.sendBooking(participant.getUserId(), booking));
        }
        return isBooked;
    }

    public boolean release(Booking booking) {
        boolean isReleased = schedule.getDateToBookings().get(booking.getDate()).remove(booking);
        if(isReleased) {
            booking.getParticipants().keySet().forEach(participant -> notification.sendCancellation(participant.getUserId(), booking));
        }
        return isReleased;
    }
}

class User {
    private String userId;
    private Schedule schedule = new Schedule();

    public String getUserId() {
        return userId;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void response(Booking booking, InvitationResponse response) {
        booking.getParticipants().put(this, response);
        if(!response.equals(InvitationResponse.REJECTED)) {
            schedule.getDateToBookings().computeIfAbsent(booking.getDate(), k -> new ArrayList<>());
            schedule.getDateToBookings().get(booking.getDate()).add(booking);
        }
    }
}

class Schedule {
    private Map<Date, List<Booking>> dateToBookings;

    public Schedule() {
        this.dateToBookings = new HashMap<>();
    }

    public Schedule(Map<Date, List<Booking>> dateToBookings) {
        this.dateToBookings = dateToBookings;
    }

    public Map<Date, List<Booking>> getDateToBookings() {
        return dateToBookings;
    }
}

class Booking {
    private String bookingId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private User organizer;
    private Room room;
    private Map<User, InvitationResponse> participants;

    public Booking(Date date, Time startTime, Time endTime, User organizer, Map<User, InvitationResponse> participants) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organizer = organizer;
        this.participants = participants;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDate() {
        return date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public User getOrganizer() {
        return organizer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Map<User, InvitationResponse> getParticipants() {
        return participants;
    }
}

class Notification {
    public void sendBooking(String userId, Booking booking) {

    }

    public void sendCancellation(String userId, Booking booking) {

    }
}

enum InvitationResponse {
    ACCEPTED,
    REJECTED,
    TENTATIVE
}