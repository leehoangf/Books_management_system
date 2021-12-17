
package Books_management_system.controllers;

import Books_management_system.models.Books;
import Books_management_system.services.BooksDataService;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BooksManager {

    private List<Books> list;
    private final String pathFileToInput; // "./resources/student-input.txt"
    private BooksDataService service;

    public BooksManager(String pathFileToInput) {

        this.pathFileToInput = pathFileToInput;

        this.service = new BooksDataService();

        try {

            this.list = service.read(pathFileToInput);

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }




    public void sortByName() {

        Collections.sort(
                list,
                (s1, s2) -> s1.getName().compareTo(s2.getName())
        );

    }

    public void sortById() {

        Collections.sort(
                list,
                (s1, s2) -> Integer.compare(s1.getId(), s2.getId())
        );

    }

    public Books findByName(String name) {

        for (Books s: list) {

            if (s.getName().equals(name)) {
                return s;
            }
        }

        return null;
    }

    public Books findById(int id) {

        for (Books s: list) {

            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public void addStudent(Scanner sc) {

        list.add(new Books().input(sc));
    }

    public void editStudent(Scanner sc) {

        System.out.println("Enter id: ");

        int id = sc.nextInt();
        sc.nextLine();// ignore new line

        Books student = findById(id);
        student.edit(sc);
    }

    public void deleteStudent(Scanner sc) {

        System.out.println("Enter id: ");

        int id = sc.nextInt();
        sc.nextLine();

        Books student = findById(id);
        list.remove(student);
    }

    public void showAll() {

        for (Books s: list) {
            System.out.println(s.toString());
        }
    }


}
