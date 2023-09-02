package library;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int phoneNumber;
    private String name;
    private int age;
    private int studentId;
    private int fine;
    private Map<Integer, Book> borrowedBooks = new HashMap<>();

    public Student(int studentId, String name, int age, int phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.fine = 0; // Initialize fine to zero
    }

    public void payFine() {
        if (fine == 0) {
            System.out.println("No fine to pay.");
        } else {
            System.out.println("Total fine of " + fine + " paid.");
            fine = 0;
        }
    }

    public void borrowBook(int bookId) {
        if (!borrowedBooks.containsKey(bookId)) {
            borrowedBooks.put(bookId, book);
            System.out.println("Book '" + book.getTitle() + "' borrowed.");
            book.issue(this);
        } else {
            System.out.println("You already borrowed this book.");
        }
    }

    public void returnBook(int bookId) {
        if (borrowedBooks.containsKey(bookId)) {
            borrowedBooks.remove(bookId);
            book.returnBook(this);
            System.out.println("Book '" + book.getTitle() + "' returned.");
        } else {
            System.out.println("You never borrowed this book.");
        }
    }
    public voide printInfo(){
        System.out.println("Member ID - " + this.studentId);
        System.out.println("Name - " + this.name);
        System.out.println("Fine - " + this.fine);
        System.out.println("Books:");
        printborrowedbook();

    }
    public voide printborrowedbook(){
        for (Book book : books.values()) {
            book.printInfo();
            System.out.println("borrowed on - " + book.borrowTime());
        }
    }
    // Getters and setters for private fields (if needed)
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Other methods and getters/setters as needed
}

