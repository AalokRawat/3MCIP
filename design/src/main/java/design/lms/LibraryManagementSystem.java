package design.lms;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {
    public static void main(String[] args) {

    }
}

class Book {
    private int isbn;
    private String tile;
    List<Author> authors;
    Subject subject;
    Date publicationDate;
}

class BookItem extends Book {
    private int BookItemId;
    private Rack rack;
    Issued issued;
    BookStatus bookStatus;
}

class Issued {
    int userId;
    private Date issuedAt;
    private Date dueAt;
}

class Reserve {
    int userId;
    private Date reservedAt;
    private ReservedStatus reservedStatus;

    public boolean bookItem(int bookItemId) {
        return true;
    }
}

enum Subject {
    SciFi,
    Commerce
}

class Rack {
    int floor;
    int row;
}

abstract class Person {
    String name;
    Address address;
}

class Author extends Person {
    List<Book> books;
}

class Address {

}

abstract class User {
    int id;
    String name;
    Address address;
    public boolean resetPassword() {
        return true;
    }
}

class Admin extends User {
    public boolean addUser(User user) {
        return true;
    }
    public boolean removeUser(User user) {
        return true;
    }
}

class Member extends User {
    LibraryCard card;
    Plan plan;
    Map<Integer, BookItem> bookItems;

    public List<Book> searchBook(SearchQuery searchQuery) {
        return null;
    }

    public boolean isBookAvailable(int bookId) {
        return true;
    }

    public boolean canReserveBook(int bookId) {
        return true;
    }

    public boolean canGetMoreBook() {
        return true;
    }

    public boolean issueBook(int bookId) {
        return true;
    }

    public boolean reserveBook(int bookId) {
        return true;
    }

    public boolean returnBook(int BookItemId) {
        return true;
    }
}

class LibraryCard {
    int cardNumber;
}

abstract class Plan {

}

class DefaultPlan extends Plan {
    int maxBooks = 10;
    int maxIntervalInDays = 15;
}

class SearchQuery {

}

class BookRecord {
    private int bookId;
    List<Activity> list;
}

class Activity {
    Date timestamp;
    User user;
    BookStatus bookStatus;
}

enum BookStatus {
    AVAILABLE,
    RESERVED,
    BOOKED
}

enum ReservedStatus {
    WAITING,
    PENDING,
    CANCELED
}

abstract class Notification {

    public abstract void execute(int userId, List<Integer> bookId);
}

class EmailNotification extends Notification {
    @Override
    public void execute(int userId, List<Integer> bookId) {

    }
}

class MessageNotification extends Notification {
    @Override
    public void execute(int userId, List<Integer> bookId) {

    }
}

class LibraryManagement {
    Map<Integer, BookItem> bookIdToBookItems;
    Map<Integer, BookItem> bookItemIdToBookIssued;
}

