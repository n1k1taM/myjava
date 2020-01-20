package by.etc.introdaction.tasks.views;

import by.etc.introdaction.tasks.books.Book;
import by.etc.introdaction.tasks.books.EBook;
import by.etc.introdaction.tasks.books.PaperBook;
import by.etc.introdaction.tasks.person.AdminPerson;
import by.etc.introdaction.tasks.person.Person;
import by.etc.introdaction.tasks.person.UserPerson;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Catalog {
    private List<Book> listOfBook;
    private List<Person> listOfPerson;

    public Catalog() {
        listOfBook = new ArrayList<Book>();
        listOfPerson = new ArrayList<Person>();
        fillLists();

    }

    public List<Person> getListOfPerson() {
        return listOfPerson;
    }

    public List<Book> getListOfBook() {
        return listOfBook;
    }

    private void fillLists() {
        UserPerson userPerson;
        AdminPerson adminPerson;
        Book book;
        List<String> linesPerson = new ArrayList<>();
        List<String> linesBook = new ArrayList<>();
        byte[] arrayBytes = new byte[10];
        StringBuilder sBooks = new StringBuilder();

        try {
            linesPerson = Files.readAllLines(Paths.get("d:\\ListOfPerson.txt"), Charset.forName("UTF-8"));
            linesBook = Files.readAllLines(Paths.get("d:\\ListOfBook.txt"), Charset.forName("UTF-8"));
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        for (String s : linesPerson) {
            String[] array = s.split(" ");
            if (array[0].equals("User")) {
                userPerson = new UserPerson(array[1], array[2], array[3], array[4], array[5]);
                listOfPerson.add(userPerson);
            } else {
                adminPerson = new AdminPerson(array[1], array[2], array[3], array[4], array[5]);
                listOfPerson.add(adminPerson);
            }
        }
        for (String s:linesBook) {
            sBooks.append(s);
        }
        linesBook = Arrays.asList(sBooks.toString().split("_"));
        for (String s : linesBook) {
            String[] array = s.split("%");
            if (array.length < 6) {
                System.out.println("Books didn't find");
            } else {
                if (array[0].equals("eBook")) {
                    book = new EBook(array[1], array[2], array[3], Integer.parseInt(array[4]), array[5], array[6]);
                    listOfBook.add(book);
                } else {
                    book = new PaperBook(array[1], array[2], array[3], Integer.parseInt(array[4]), array[5], array[6]);
                    listOfBook.add(book);
                }
            }

        }

    }

}
