package library;

import java.util.HashMap;
import java.util.Map;

public class Admin {
    private Map<Integer, Student> members = new HashMap<>();
    private Map<Integer, Book> books = new HashMap<>();
    private int maxBookId = 0;

    public void addMember(String name, int age, int studentId) {
        if (!members.containsKey(studentId)) {
            Student student = new Student(studentId, name, age);
            members.put(studentId, student);
            System.out.println("Member Successfully Registered with Student ID: " + student.getStudentId());
        } else {
            System.out.println("Already Registered with Student ID: " + studentId);
        }
    }

    public void removeMember(int studentId) {
        if (members.containsKey(studentId)) {
            System.out.println("Member Successfully Removed with Student ID: " + studentId);
            members.remove(studentId);
        } else {
            System.out.println("No Member Registered with Student ID: " + studentId);
        }
    }

    public void addBook(String title, String author, int num_of_books) {
        for (int i = 0; i < num_of_books; i++) {
            Book book = new Book(maxBookId + i, title, author);
            books.put(book.getBookId(), book);
        }
        System.out.println(num_of_books + " Books Successfully added with IDs " + maxBookId + " to " + (maxBookId + num_of_books - 1));
        maxBookId += num_of_books;
    }

    public void removeBook(int bookId) {
        if (books.containsKey(bookId)) {
            System.out.println("Book Successfully Removed with ID " + bookId);
            books.remove(bookId);
        } else {
            System.out.println("No book with ID " + bookId);
        }
    }

    public void printMembers() {
        System.out.println("Members:");
        for (Student student : members.values()) {
            student.printInfo();
        }
    }
    public Student member_login(String name,int ph_no, int studentId){
    if (members[studentId].name == name){
      return members[studentId];
    }
    else{
      System.out.println("Member with Name:" + name " and Phone No: " + ph_no + "doesn't exist.");
      return null;
    }
  }
    public void printBooks() {
        System.out.println("Books:");
        for (Book book : books.values()) {
            book.printInfo();
        }
    }
}

