# Library Management System

## Introduction

The Library Management System is a simple Java project that helps manage a library's operations. It allows librarians to register members, add and remove books, and view member information. Members can list available books, borrow and return books, and pay fines.

## Project Structure

The project consists of the following Java classes:

- `LibraryMain.java`: The main class that contains the user interface for librarians and members.
- `Admin.java`: The Admin class that manages members and books.
- `Student.java`: The Student class representing library members.
- `Book.java`: The Book class representing library books.

## Features

- Register and remove library members.
- Add and remove library books.
- Issue and return books.
- Calculate fines for late returns.
- List available books.
- View member information.
- View book information.

## Usage

1. Compile the Java files in your preferred IDE or using the command line.

2. Run the `LibraryMain` class to start the Library Management System.

3. Follow the on-screen instructions to perform various library operations as a librarian or member.

## Dependencies

This project uses standard Java libraries and does not require any additional dependencies.

## Project Assumptions and Rules

1. **Member ID Unique**: In this library system, the Member ID is equivalent to the Member's Phone Number. Therefore, it is assumed that no two members will have the same phone number. The system enforces uniqueness to ensure identification.

2. **Borrowing Limit**: Each member is allowed to borrow a maximum of 5 books at a time. If a member attempts to borrow more than this limit, the system will prevent it.

3. **Fine Payment Requirement**: Before a member can borrow any new books, it is mandatory for them to clear any outstanding fines they may have. This rule ensures that members fulfill their financial obligations to the library.

These assumptions and rules are integral to the functioning of the library management system and are designed to maintain fairness, accountability, and efficient management of resources.

## Library Management System - `LibraryMain` Class

The `LibraryMain` class is the central component of the Library Management System. It acts as the entry point for both librarians and members, allowing them to interact with the library's functions.

### Librarian Menu

Librarians can access the following functions:

1. **Register a Member**: Librarians can register a new member by providing their name, age, and phone number. The system ensures that no two members have the same phone number.

2. **Remove a Member**: Librarians can remove a member from the system by entering their ID (phone number).

3. **Add a Book**: Librarians can add books to the library's inventory by specifying the title, author, and the number of copies to add.

4. **Remove a Book**: Librarians can remove a book from the library's inventory by entering its ID.

5. **View Members**: Librarians can view a list of all registered members, along with their borrowed books and any fines they need to pay.

6. **View Books**: Librarians can view a list of all books in the library's inventory.

### Member Menu

Members can access the following functions:

1. **List Available Books**: Members can see a list of books available for borrowing.

2. **List My Books**: Members can view the books they have borrowed.

3. **Issue a Book**: Members can borrow a book by entering its ID. The system checks if they have any outstanding fines before allowing them to borrow.

4. **Return a Book**: Members can return a book by entering its ID. If returned within 10 seconds, there is no fine; otherwise, a late return fine is calculated.

5. **Pay Fine**: Members can pay their fines if they have any.

Please note that the system enforces borrowing limits, ensures unique member IDs (phone numbers), and requires fine payment before borrowing new books.

The `LibraryMain` class provides a user-friendly interface for both librarians and members, making it easy to manage library operations efficiently.

## Admin Class - Library Management

The `Admin` class is a critical component of the Library Management System, responsible for managing library members, books, and various operations related to library administration.

### Member Management

1. **Add Member**: The `addMember` method allows administrators to register new members in the library. It checks if a member with the same Student ID (phone number) already exists. If not, a new member is registered with their name, age, and Student ID.

2. **Remove Member**: The `removeMember` method enables administrators to remove a member from the library system. If the member has borrowed books, it checks and informs the administrator about the number of borrowed books before removal.

### Book Management

3. **Add Book**: With the `addBook` method, administrators can add books to the library's inventory. They provide the title, author, and the number of copies to be added. Multiple copies of a book are assigned unique IDs.

4. **Remove Book**: The `removeBook` method allows administrators to remove a book from the library's inventory by specifying its unique ID.

### Printing Information

5. **Print Members**: The `printMembers` method prints a list of all registered members in the library, including their details.

6. **Member Login**: The `member_login` method allows administrators to verify the existence of a member by providing their name, phone number, and Student ID. If the member exists and the provided information matches, the method returns the member object; otherwise, it displays an error message.

7. **Print Books**: The `printBooks` method prints a list of all books in the library's inventory, including their details.

8. **Print Available Books**: The `printABooks` method prints a list of available books in the library, i.e., books that are not currently borrowed by any member.

The `Admin` class serves as the backbone for administrators to manage the library efficiently. It ensures data integrity by preventing duplicate members and provides essential functions for managing both members and books in the library.

## Student Class - Library Member

The `Student` class represents a library member in the Library Management System. Each member has unique attributes and can perform various actions related to borrowing and returning books.

### Attributes

1. **Student ID**: A unique identifier for each library member, which is the same as their phone number. No two members can have the same phone number.

2. **Name**: The name of the library member.

3. **Age**: The age of the library member.

4. **Phone Number**: The phone number of the library member, also serving as their unique identifier (Student ID).

5. **Fine**: The fine amount associated with the member, which is initially set to zero.

### Methods

6. **Pay Fine**: The `payFine` method allows members to pay any outstanding fines they may have accrued for late book returns. It calculates the total fine, resets it to zero, and updates the borrowed books' borrow time to the current time.

7. **Borrow Book**: Members can borrow books using the `borrowBook` method. It checks if the member has already borrowed the maximum allowed books (5 books) or if there are any outstanding fines to be paid. If conditions are met, the book is borrowed, and the book's borrower information is updated.

8. **Return Book**: Using the `returnBook` method, members can return books they've borrowed. It checks if the member has indeed borrowed the book and then marks it as returned, updating fine information if the book is returned late.

9. **Calculate Fine**: The `calculateFine` method calculates the total fine associated with the member, considering both the member's fine attribute and any fines associated with books they have borrowed.

10. **Print Info**: The `printInfo` method prints detailed information about the member, including their Student ID, name, total fine, and a list of borrowed books.

11. **Print Borrowed Books**: The `printBorrowedBooks` method prints a list of books currently borrowed by the member, including their details and the date and time they were borrowed.

### Constraints

Members have specific constraints they must adhere to:

- Members cannot borrow more than 5 books simultaneously.
- Members must pay any outstanding fines before borrowing new books.

The `Student` class encapsulates member information and actions, ensuring the smooth operation of the Library Management System.



## Book Class - Library Book

The `Book` class represents a book available in the library's collection. Each book has attributes related to its title, author, and availability status.

### Attributes

1. **Book ID**: A unique identifier for each book, assigned when the book is added to the library's collection.

2. **Title**: The title of the book.

3. **Author**: The author of the book.

4. **Borrower**: An instance of the `Student` class representing the member who has borrowed the book. It can be `null` if the book is available.

5. **Borrow Time**: A timestamp indicating when the book was borrowed.

### Methods

6. **Issue**: The `issue` method allows a member to borrow the book. It checks if the member has any outstanding fines and whether the book is currently borrowed. If conditions are met, the book is issued to the member, and the borrow time is recorded.

7. **Current Fine**: The `currFine` method calculates the fine associated with a late book return. It checks the time difference between the current time and the borrow time. If the book is returned within 10 seconds (adjustable), no fine is imposed; otherwise, a fine is calculated based on the duration of delay.

8. **Return Book**: Using the `returnBook` method, members can return books they've borrowed. It checks if the member has indeed borrowed the book and marks it as returned, updating fine information if the book is returned late.

9. **Refresh Borrower Time**: The `refresh_borrower_time` method updates the borrow time when the book is returned, ensuring accurate fine calculations for future returns.

10. **Print Info**: The `printInfo` method prints detailed information about the book, including its Book ID, title, and author.

### Constraints

Books have specific constraints and behaviors:

- Members cannot borrow books if they have outstanding fines.
- Books can only be borrowed by one member at a time.
- A fine is imposed if a book is returned late, with the threshold set at 10 seconds (adjustable).

The `Book` class encapsulates book information and actions, ensuring proper management of books within the Library Management System.

## Project Object Model (POM) - pom.xml

The `pom.xml` file is a configuration file used in Maven-based projects to define project settings, dependencies, and build instructions.

### Project Information

1. **Group ID**: `<groupId>` specifies a unique identifier for the project's group or organization. In your case, it's set to `org.example`, but you should replace this with your actual group or organization name.

2. **Artifact ID**: `<artifactId>` specifies the name of the project or artifact. It is set to `library` in this example, indicating that this Maven project is named "library."

3. **Version**: `<version>` defines the version number of the project. It is set to `1.0-SNAPSHOT` here but should be updated as you make changes and releases to your project.

### Project Properties

4. **Java Compiler Version**: `<maven.compiler.source>` and `<maven.compiler.target>` specify the source and target compatibility versions for the Java compiler used in the project. In this case, it's set to Java 11, which means the project is configured to work with Java 11 source code.

5. **Source Encoding**: `<project.build.sourceEncoding>` specifies the character encoding for the project's source files. It is set to UTF-8, which is a common encoding for handling various character sets.

### Dependencies (Not Included)

In a typical Maven project, you would also include dependencies within the `pom.xml` file. Dependencies are external libraries or modules that your project relies on. You would define them in the `<dependencies>` section of this file. However, since your provided `pom.xml` does not include any dependencies, you may need to add them as your project requires.

The `pom.xml` file plays a crucial role in managing your project's build process, including compilation, testing, packaging, and dependency management. It ensures that your project is built consistently and can be easily shared with others for collaboration or distribution.

