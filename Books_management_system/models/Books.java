package Books_management_system.models;

import java.util.Scanner;

public class Books {

    // fields
    private int id;
    private String name;
    private String author;
    private String address;

    // constructors
    public Books() {

    }

    public Books(int id, String name, String author, String languge, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.language = language;
        this.price = price;
    }

    public Books input(Scanner sc) {

        System.out.println("Enter student id: ");
        int id = sc.nextInt();
        sc.nextLine(); // ignore new line

        System.out.println("Enter name of book: ");
        String name = sc.nextLine();

        System.out.println("Enter name of author: ");
        String author = sc.nextLine();

        System.out.println("Enter language of book: ");
        String language = sc.nextLine();

        System.out.println("Enter price of book: ");
        String price = sc.nextInt();

        return new Books(id, name, author, language, price);
    }

    public void edit(Scanner sc) {

        System.out.println("Enter new name: ");
        this.name = sc.nextLine();

        System.out.println("Enter new author: ");
        this.author = sc.nextLine();

        System.out.println("Enter new address: ");
        this.address = sc.nextLine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    @Override
    public String toString() {
        return id + ", " + name + ", " + author + ", " + language + "," + price;
    }




}