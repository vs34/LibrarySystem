package library;

public class LibraryMain {
    public static void main(String[] args) {
        // Create an Admin instance
        Admin admin = new Admin();

        // Add members and books
        admin.addMember("John Doe", 25, 1);
        admin.addMember("Jane Smith", 30, 2);
        admin.addBook("The Great Gatsby", "F. Scott Fitzgerald", 5);

        // Perform actions using Student and Book instances
        Student student1 = admin.member_login("John Doe", 0, 1); // Use 0 as a placeholder for the phone number
        if (student1 != null) {
            student1.borrowBook(admin.book_from_id(1)); // Borrow the book by book ID
            student1.printInfo(); // Print student's info
        }

        // Perform more actions...

        // Print members and books
        admin.printMembers();
        admin.printBooks();
    }
}

