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
            this.borrower = student;
            this.borrowTime = LocalTime.now();
            System.out.println("Book '" + title + "' issued to " + borrower.getName() + " on " + borrowTime);
        } else {
            System.out.println("This book is already borrowed.");
        }
    }

    public double currFine() {
        Duration timeDifference = Duration.between(borrowTime, LocalTime.now());
        double secondsLate = timeDifference.getSeconds(); // Time difference in seconds

        if (secondsLate < 600) { // 10 minutes converted to seconds
            return 0;
        }

        return (secondsLate - 600) * 10; // Fine calculation in seconds
    }

    public void returnBook(Student student) {
        if (borrower == null || student.getStudentId() != borrower.getStudentId()) {
            System.out.println("You never borrowed this book.");
        } else {
            Duration timeDifference = Duration.between(borrowTime, LocalTime.now());
            double secondsLate = timeDifference.getSeconds(); // Time difference in seconds

            if (secondsLate < 600) { // 10 minutes converted to seconds
                this.borrower = null;
                this.borrowTime = null;
                System.out.println("Book returned.");
            } else {
                double fine = (secondsLate - 600) * 10; // Fine calculation in seconds
                student.setFine((int) (student.getFine() + fine));
                System.out.println("Late return fine of " + fine + " added. Total fine: " + student.getFine());
            }
        }
    }

    public void refresh_borrower_time() {
        this.borrowTime = LocalTime.now();
    }

    public void printInfo() {
        System.out.println("Book ID - " + this.bookId);
        System.out.println("Name - " + this.title);
        System.out.println("Author - " + this.author);
    }

    // Getters and setters for private fields
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookId() {
        return bookId;
    }



    public Student getBorrower() {
        return borrower;
    }

    public LocalTime getBorrowTime() {
        return borrowTime;
    } 
}

