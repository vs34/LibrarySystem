package library;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private final long phoneNumber;
    private final String name;
    private final int age;
    private final long studentId;
    private int fine;
    private final Map<Integer, Book> borrowedBooks = new HashMap<>();

    public Student(long studentId, String name, int age, long phoneNumber) {
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
            int totalFine = calculateFine();
            System.out.println("Total fine of " + totalFine + " paid.");
            this.fine = 0;
            for (Book book : borrowedBooks.values()) {
                book.refresh_borrower_time();
            }
        }
    }

    public void borrowBook(Book book) {
        int bookId = book.getBookId();
        int currentFine = calculateFine();
        
        if (currentFine > 0) {
            System.out.println("Pay the fine first of " + currentFine);
        } else if (!borrowedBooks.containsKey(bookId) && book.getBorrower() == null) {
            borrowedBooks.put(bookId, book);
            System.out.println("Book '" + book.getTitle() + "' borrowed.");
            book.issue(this);
        } else {
            System.out.println("You already borrowed this book or the book is not available.");
        }
    }

    public void returnBook(Book book) {
        int bookId = book.getBookId();
        if (borrowedBooks.containsKey(bookId)) {
            borrowedBooks.remove(bookId);
            book.returnBook(this);
            System.out.println("Book '" + book.getTitle() + "' returned.");
        } else {
            System.out.println("You never borrowed this book.");
        }
    }

    public int calculateFine() {
        int totalFine = fine;
        for (Book book : borrowedBooks.values()) {
            totalFine += book.currFine();
        }
        return totalFine;
    }

    public void printInfo() {
        System.out.println("Member ID - " + this.studentId);
        System.out.println("Name - " + this.name);
        System.out.println("Fine - " + calculateFine());
        System.out.println("Books:");
        printBorrowedBooks();
    }

    public void printBorrowedBooks() {
        for (Book book : borrowedBooks.values()) {
            book.printInfo();
            System.out.println("Borrowed on - " + book.getBorrowTime());
        }
    }

    // Getters and setters for private fields (if needed)
    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    public String getName() {
        return name;
    }

    public long getStudentId() {
        return studentId;
    }


}


