package lesson03.BasicTasks;

import java.util.Scanner;
import java.util.ArrayList;

class Book {
    private static int isbnCounter = 0;
    private int isbn = 0;
    private final String name;
    private final String author;
    private final int year;
    private int status;

    private static ArrayList<Book> bookCollection = new ArrayList<>();

    Book (String name , String author , int year ) {
        ++isbnCounter;
        this.isbn = isbnCounter;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = 1;
    }

    public void getBookInfo () {
        System.out.println();
        System.out.println("Book information : ");
        System.out.println("Name : " + this.name);
        System.out.println("Year : " + this.year);
        System.out.println("Author : " + this.author);
        System.out.println("Isbn : " + this.isbn);
        if(status == 1) {
            System.out.println("Status : available");
        }else{
            System.out.println("Status : reserved");
        }
    }

    public void getBooks () {
        for(Book book : bookCollection){
            System.out.println();
            book.getBookInfo();
            System.out.println();
        }
    }

    public void addNewBook () {
        bookCollection.add(this);
    }

    public boolean reserveBook () {
        this.status = 2;
        boolean found = false;
        for(Book book : bookCollection) {
            if(book.isbn == this.isbn){
                book.status = 2;
                found = true;
            }
        }
        return found;
    }
}


class BookMain {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.print("Please enter the name of the book : ");
        String name = scanner.nextLine();

        System.out.print("Please enter the name of the author of the book : ");
        String author = scanner.nextLine();

        System.out.print("Please enter the year when the book was made : ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the name of the book 2 : ");
        String name_2 = scanner.nextLine();

        System.out.print("Please enter the name of the author of the book 2 : ");
        String author_2 = scanner.nextLine();

        System.out.print("Please enter the year when the \"book 2\" was made : ");
        int year_2 = scanner.nextInt();
        scanner.nextLine();

        if(year >= 0 && year_2 >= 0) {
            Book book = new Book (name,author,year);
            Book book_2 = new Book (name_2 , author_2 , year_2);

            book.reserveBook();
            book.getBookInfo();
            book.addNewBook();
            book_2.addNewBook();
            book.getBooks();

        }else{
            System.out.println("The year when the book was made can't be less than 0");
        }
    }
}