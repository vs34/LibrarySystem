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
