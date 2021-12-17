package Books_management_system.services;

import Books_management_system.models.Books;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BooksDataService {



    public List<Books> read(String path) throws IOException {

        List<Books> students = new ArrayList<>();

        //Path pathFileToRead = Paths.get("./resources/books-input.txt");
        Path pathFileToRead = Paths.get(path);

        List<String> allLines = Files.readAllLines(pathFileToRead);

        for (int i = 0; i < allLines.size(); ++i) {

            String line = allLines.get(i);
            String[] data = line.split(",");

            Books book
                    = new Books(Integer.parseInt(data[0]) , data[1].trim(), data[2].trim(), data[3].trim());

            students.add(book);
        }

        return students;

    }


    public void write(String path, List<Books> books) throws IOException {

        // List<Student> => List<String>
        List<String> list = new ArrayList<>();

        for (int i = 0; i < books.size(); ++i) {

            Books student = books.get(i);

            list.add(student.toString());
        }

        // print to file
        Path pathFileToWrite = Paths.get(path);

        Files.write(pathFileToWrite, list);

    }

}