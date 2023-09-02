package library;

import java.time.Duration;
import java.time.LocalTime;

public class Book {
    private String title;
    private String author;
    private int bookId;
    private Student borrower;
    private LocalTime borrowTime;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void issue(Student student) {
        if (student.getFine() != 0) {
            System.out.println("Please pay the remaining fine of " + student.getFine());
        } else if (borrower == null) {
            borrower = student;
            borrowTime = LocalTime.now();
            System.out.println("Book '" + title + "' issued to " + borrower.getName() + " on " + borrowTime);
        } else {
            System.out.println("This book is already borrowed.");
        }
    }

    public void returnBook(Student student) {
        if (borrower == null || student.getId() != borrower.getId()) {
            System.out.println("You never borrowed this book.");
        } else {
            Duration timeDifference = Duration.between(borrowTime, LocalTime.now());
            long minutesLate = timeDifference.toMinutes();
            if (minutesLate < 10) {
                borrower = null;
                borrowTime = null;
                System.out.println("Book returned.");
            } else {
                int fine = (int) (minutesLate - 10) * 10;
                student.setFine(student.getFine() + fine);
                System.out.println("Late return fine of " + fine + " added. Total fine: " + student.getFine());
            }
        }
    }
    public void printInfo(){
        System.out.println("Book ID - " + this.bookId);
        System.out.println("Name - " + this.title);
        System.out.println("Author - " + this.author);
    } 
    // Getters and setters for private fields
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Other methods and getters/setters as needed
}



