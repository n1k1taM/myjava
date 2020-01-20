package by.etc.introdaction.classes;

import java.util.Scanner;

public class ListOfBook {
    Book[] books;
    Book book;
    Scanner sc = new Scanner(System.in);

    //for example************************************************
    static String[] arrayName = {"Шантарам", "Граф Монте-Кристо", "Мартин Иден", "Унесенные ветром", "Война и мир"};
    static String[] arrayAuthors = {"Грегори Дэвид Робертс", "Александр Дюма (отец)", "Джек Лондон", "Маргарет Митчелл", "Лев Толстой"};
    static String[] arrayPublishing = {"Азбука", "Азбука", "АСТ", "Эксмо", "Азбука"};
    static String[] arrayBinding = {"Твердый переплет", "Твердый переплет", "Твердый переплет", "Мягкий переплет", "Твердый переплет"};
    static int[] arrayYear = {1997, 1846, 1909, 1936, 1869};
    static int[] arrayPages = {864, 1264, 416, 1536, 1408};
    static int[] arrayPrice = {25, 46, 20, 18, 15};
//*****************************************************************

    ListOfBook(int n) {
        books = new Book[Math.abs(n)];
    }

    public static void main(String[] args) {

        //create an object and fill it with book objects
        ListOfBook listOfBook = new ListOfBook(5);
        for (int i = 0; i < listOfBook.books.length; i++) {
            listOfBook.book = new Book(arrayName[i], arrayAuthors[i], arrayPublishing[i], arrayBinding[i], arrayYear[i], arrayPages[i],
                    arrayPrice[i]);
            listOfBook.books[i] = listOfBook.book;
        }
        //show list of books
        for (int i = 0; i < listOfBook.books.length; i++) {
            System.out.println(listOfBook.books[i]);
        }
        System.out.println();

        listOfBook.searchingByAythor();

        System.out.println();

        listOfBook.choosePublishing();

        System.out.println();

        listOfBook.booksAfterYear();

    }

    //method for seaching by author
    public void searchingByAythor() {
        System.out.println("Введите автора: ");
        String author;
        while (sc.hasNextLine() == false) {
            sc.next();
        }
        author = sc.nextLine();
        for (Book b : books) {
            if (author.trim().equalsIgnoreCase(b.getAuthor())) {
                System.out.println(b);
            }
        }
    }

    //method for searching by publishing house
    public void choosePublishing() {
        System.out.println("Введите издательство: ");
        String publishing;
        while (sc.hasNextLine() == false) {
            sc.next();
        }
        publishing = sc.nextLine();
        for (Book b : books) {
            if (publishing.trim().equalsIgnoreCase(b.getPublishingHouse())) {
                System.out.println(b);
            }
        }
    }

    //method for searching books after pointed year
    public void booksAfterYear() {
        System.out.println("Введите наименьший год: ");
        int leastYear;
        while (sc.hasNextInt() == false) {
            sc.next();
        }
        leastYear = sc.nextInt();
        for (Book b : books) {
            if (leastYear < (b.getYear())) {
                System.out.println(b);
            }
        }
    }
}
