package Books_management_system;

import Books_management_system.controllers.BookManager;
import Books_management_system.models.Book;
import Books_management_system.services.BooksDataService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BooksDataService service = new BooksDataService();

        List<Books> books = service.read("./resources/book-input.txt");

        String choose = null;
        boolean exit = false;
        BookManager studentManager = new StudentManager("./resources/book-input.txt");

        showMenu();

        while (true) {
            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    System.out.println("Add book: ");
                    studentManager.addStudent(scanner);
                    break;
                case "2":
                    System.out.println("Edit book: ");
                    studentManager.editStudent(scanner);
                    break;
                case "3":
                    System.out.println("Delete book: ");
                    studentManager.deleteStudent(scanner);
                    break;
                case "4":
                    System.out.println("Sort books by id ");
                    studentManager.sortById();
                    break;
                case "5":
                    System.out.println("Sort books by name ");
                    studentManager.sortByName();
                    break;
                case "6":
                    System.out.println("books");
                    studentManager.showAll();
                    break;
                case "0":
                    System.out.println("Exit");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }

            if (exit) {
                break;
            }

            showMenu();
        }


    }

    public static void showMenu() {
        System.out.println("-----------------Menu------------------");
        System.out.println("1. Add book");
        System.out.println("2. Edit book");
        System.out.println("3. Delete book");
        System.out.println("4. Sort books by id");
        System.out.println("5. Sort books by name");
        System.out.println("6. Show all books");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------");
        System.out.println("Please choose: ");
    }

}
