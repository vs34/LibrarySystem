package library;

import library.Admin;
import library.Student;

import java.util.Scanner;

public class LibraryMain {
    private static Scanner scanner = new Scanner(System.in);

    public static void


    main(String[] args) {
        Admin admin = new Admin();

        int choice;
        boolean exit = false;

        System.out.println("Library Portal Initialized…");
        while (!exit) {
            System.out.println("---------------------------------");
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    libMenu(admin);
                    break;
                case 2:
                    // Register a member
                    System.out.print("Enter member's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member's phone number: ");
                    long phoneNumber = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character
                    Student mem = admin.member_login(name, phoneNumber, phoneNumber);
                    if (mem != null) {
                        memberMenu(mem, admin);
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting Library Portal.");
    }

    private static void libMenu(Admin admin) {
        int choice;
        boolean back = false;
        String name, title, author;
        int age;
        long phoneNumber, num_of_books, bookId;

        while (!back) {
            System.out.println("---------------------------------");
            System.out.println("1. Register a member");
            System.out.println("2. Remove a member");
            System.out.println("3. Add a book");
            System.out.println("4. Remove a book");
            System.out.println("5. View all members along with their books and fines to be paid");
            System.out.println("6. View all books");
            System.out.println("7. Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Register a member
                    System.out.print("Enter member's name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter member's age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter member's phone number: ");
                    phoneNumber = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character

                    // Add the member to the library
                    admin.addMember(name, age, phoneNumber);

                    System.out.println("Member Successfully Registered!");
                    break;
                case 2:
                    System.out.print("Enter member's ID to remove: ");
                    long studentid = scanner.nextLong();
                    admin.removeMember(studentid);
                    break;
                case 3:
                    System.out.print("Enter book's title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book's author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter number of books: ");
                    num_of_books = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character

                    admin.addBook(title, author, (int)num_of_books);
                    break;
                case 4:
                    System.out.print("Enter book's ID to remove: ");
                    long bookd = scanner.nextLong();
                    admin.removeBook((int) bookd);
                    break;
                case 5:
                    admin.printMembers();
                    break;
                case 6:
                    admin.printBooks();
                    break;
                case 7:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void memberMenu(Student mem, Admin admin) {
        int choice;
        boolean back = false;
        int bookId;

        while (!back) {
            System.out.println("---------------------------------");
            System.out.println("1. List Available Books");
            System.out.println("2. List My Books");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Pay Fine");
            System.out.println("6. Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    admin.printABooks();
                    break;
                case 2:
                    mem.printBorrowedBooks();
                    break;
                case 3:
                    System.out.print("Enter book's ID: ");
                    bookId = scanner.nextInt();
                    mem.borrowBook(admin.book_from_id(bookId));
                    break;
                case 4:
                    System.out.print("Enter book's ID: ");
                    bookId = scanner.nextInt();
                    mem.returnBook(admin.book_from_id(bookId));
                    break;
                case 5:
                    mem.payFine();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
