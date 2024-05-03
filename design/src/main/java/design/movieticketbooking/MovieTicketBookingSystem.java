package design.movieticketbooking;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieTicketBookingSystem {
}



/////////////////////////// Cinema /////////////////////

class Cinema {
    private String id;
    private String name;
    private String address;
    private String city;
    private Map<String, List<Show>> movieToShowTime;
    private Map<Show, Hall> showToHall;
}

class Hall {
    private final String id;
    private final Show show;
    private final Map<Character, List<Boolean>> rowToSeats;

    public Hall(String id, Show show, Map<Character, List<Boolean>> rowToSeats) {
        this.id = id;
        this.show = show;
        this.rowToSeats = rowToSeats;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public Map<Character, List<Boolean>> getRowToSeats() {
        return rowToSeats;
    }
}

class Movie {
    String movieId; // for same movie there can be different language so creating id to uniquely identify them.
    String title;
    Language language;
    Genre genre;
    Date releaseDate;
    Float duration;
}

class Show {
    Movie movie;
    Date showTime;
}

class MovieSearch {
    private Map<String, List<Cinema>> tileToCinema;
    private Map<Language, List<Cinema>> languageToCinema;
    private Map<Genre, List<Cinema>> genreToCinema;
    private Map<Date, List<Cinema>> releaseDateToCinema;

    public MovieSearch() {
        this.tileToCinema = new HashMap<>();
        this.languageToCinema = new HashMap<>();
        this.genreToCinema = new HashMap<>();
        this.releaseDateToCinema = new HashMap<>();
    }

    public List<Cinema> search(String title, Language language, Genre genre, Date releaseDate) {
        return new ArrayList<>();
    }
}

//////////////////////////////////////// User ///////////////////////////

abstract class User {
    private String userId;
    Payment payment;

    public boolean bookTicket(String cinemaId, Show show, List<String> seats) {
        return true;
    }

    public abstract boolean payment();
}

class OnlineUser extends User {


    @Override
    public boolean payment() {
        return false;
    }
}

interface Payment{
    void execute(float amount);
}

class CreditCard implements Payment {
    @Override
    public void execute(float amount) {

    }
}

class Cash implements Payment {
    @Override
    public void execute(float amount) {

    }
}


enum Language {
    ENGLISH,
    HINDI
}
enum Genre {
    ACTION,
    SCI_FI,
    ROMANCE,
    THRILLER
}
