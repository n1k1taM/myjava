package by.etc.introdaction.tasks.actions;

import by.etc.introdaction.tasks.books.Book;
import by.etc.introdaction.tasks.books.EBook;
import by.etc.introdaction.tasks.books.PaperBook;
import by.etc.introdaction.tasks.person.Person;
import by.etc.introdaction.tasks.views.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIActions implements ActionListener {
    static GUI gui;
    static CatalogAction catalogAction;
    private ArrayList<Book> listOfBookSearching;
    private Book currentBook;
    private int indexCurrentBook;

    public GUIActions(Person person) {
        gui = new GUI(person);
        gui.getSearchBook().addActionListener(this);
        gui.getRadio1().addActionListener(this);
        gui.getRadio2().addActionListener(this);
        gui.getPrev().addActionListener(this);
        gui.getNext().addActionListener(this);
        gui.getAddBook().addActionListener(this);
        gui.getDeliteBook().addActionListener(this);
        gui.getSuggestion().addActionListener(this);
        gui.getSendSuggest().addActionListener(this);
        catalogAction = new CatalogAction();
        listOfBookSearching = new ArrayList<>();
    }

    public void searchingBook() {
        listOfBookSearching = new ArrayList<>();
        boolean searchByName = gui.getRadio1().isSelected();
        if (searchByName) {
            String enteredName = gui.getSearchBook().getText().trim();
            for (Book book : catalogAction.getCatalog().getListOfBook()) {
                if (enteredName.equals(book.getName())) {
                    listOfBookSearching.add(book);
                }
            }
        } else {
            String enteredAuthor = gui.getSearchBook().getText().trim();
            for (Book book : catalogAction.getCatalog().getListOfBook()) {
                if (enteredAuthor.equals(book.getAuthor())) {
                    listOfBookSearching.add(book);
                }
            }
        }
        if (listOfBookSearching.size() != 0) {
            fillField(listOfBookSearching.get(0));
            currentBook = listOfBookSearching.get(0);
        }

    }

    private void fillField(Book book) {

        gui.setNameOfBook(book.getName());
        gui.setAuthorOfBook(book.getAuthor());
        gui.setPublishing(book.getPublishingHouse());
        gui.setYearOfRelease(book.getYear());
        gui.setBookLocation(book.getLocation());
        gui.setBookDescription(book.getDescription());
    }

    public void addBook() {

        String name = gui.getNameOfBook().getText();
        String author = gui.getAuthorOfBook().getText();
        String publishingHouse = gui.getPublishing().getText();
        int year = Integer.parseInt(gui.getYearOfRelease().getText());
        String location = gui.getBookLocation().getText();
        String description = gui.getBookDescription().getText();

        Book book;
        if (location.startsWith("http")) {
            book = new EBook(name, author, publishingHouse, year, description, location);
        } else {
            book = new PaperBook(name, author, publishingHouse, year, description, location);
        }
        String email = gui.getPerson().geteMail();
        // Диалоговое окно ввода данных
        String password = JOptionPane.showInputDialog(gui.getFrame(),
                new String[]{"Введите пароль от вашего eMail",
                        ""},
                "Авторизация",
                JOptionPane.QUESTION_MESSAGE);

        catalogAction.addBook(book, email, password);

        gui.getNameOfBook().setText("");
        gui.getAuthorOfBook().setText("");
        gui.getPublishing().setText("");
        gui.getYearOfRelease().setText("");
        gui.getBookLocation().setText("");
        gui.getBookDescription().setText("");
    }

    public void deliteBook() {

        String name = gui.getNameOfBook().getText();
        String author = gui.getAuthorOfBook().getText();
        String publishingHouse = gui.getPublishing().getText();
        int year = Integer.parseInt(gui.getYearOfRelease().getText());
        String location = gui.getBookLocation().getText();
        String description = gui.getBookDescription().getText();

        Book book;
        if (location.startsWith("http")) {
            book = new EBook(name, author, publishingHouse, year, description, location);
        } else {
            book = new PaperBook(name, author, publishingHouse, year, description, location);
        }
        catalogAction.deliteBook(book);

        gui.getNameOfBook().setText("");
        gui.getAuthorOfBook().setText("");
        gui.getPublishing().setText("");
        gui.getYearOfRelease().setText("");
        gui.getBookLocation().setText("");
        gui.getBookDescription().setText("");

    }

    private void nextBook() {
        indexCurrentBook = listOfBookSearching.indexOf(currentBook);
        if (indexCurrentBook != -1 && indexCurrentBook + 1 < listOfBookSearching.size()) {
            indexCurrentBook++;
            currentBook = listOfBookSearching.get(indexCurrentBook);
            fillField(currentBook);
        } else {
            indexCurrentBook = catalogAction.getCatalog().getListOfBook().indexOf(currentBook);
            if (indexCurrentBook != -1 && indexCurrentBook + 1 < catalogAction.getCatalog().getListOfBook().size()) {
                indexCurrentBook++;
                currentBook = catalogAction.getCatalog().getListOfBook().get(indexCurrentBook);
                fillField(currentBook);
            } else {
                indexCurrentBook = 0;
                currentBook = catalogAction.getCatalog().getListOfBook().get(indexCurrentBook);
                fillField(currentBook);
            }
        }
    }

    private void prevBook() {
        indexCurrentBook = listOfBookSearching.indexOf(currentBook);
        if (indexCurrentBook != -1 && indexCurrentBook - 1 >= 0) {
            indexCurrentBook--;
            currentBook = listOfBookSearching.get(indexCurrentBook);
            fillField(currentBook);
        } else {
            indexCurrentBook = catalogAction.getCatalog().getListOfBook().indexOf(currentBook);
            if (indexCurrentBook != -1 && indexCurrentBook - 1 >= 0) {
                indexCurrentBook--;
                currentBook = catalogAction.getCatalog().getListOfBook().get(indexCurrentBook);
                fillField(currentBook);
            } else {
                indexCurrentBook = 0;
                currentBook = catalogAction.getCatalog().getListOfBook().get(indexCurrentBook);
                fillField(currentBook);
            }
        }
    }

    private void userSuggestion() {
        gui.getSearchBook().setEnabled(false);
        gui.getPrev().setEnabled(false);
        gui.getNext().setEnabled(false);
        gui.getRadio1().setEnabled(false);
        gui.getRadio2().setEnabled(false);
        gui.getSuggestion().setEnabled(false);

        gui.getNameOfBook().setEnabled(true);
        gui.getAuthorOfBook().setEnabled(true);
        gui.getPublishing().setEnabled(true);
        gui.getYearOfRelease().setEnabled(true);
        gui.getBookLocation().setEnabled(true);
        gui.getBookDescription().setEnabled(true);
        gui.getSendSuggest().setEnabled(true);

        gui.getNameOfBook().setText("");
        gui.getAuthorOfBook().setText("");
        gui.getPublishing().setText("");
        gui.getYearOfRelease().setText("");
        gui.getBookLocation().setText("");
        gui.getBookDescription().setText("");
    }

    private void userNormalState() {
        gui.getSearchBook().setEnabled(true);
        gui.getPrev().setEnabled(true);
        gui.getNext().setEnabled(true);
        gui.getRadio1().setEnabled(true);
        gui.getRadio2().setEnabled(true);
        gui.getSuggestion().setEnabled(true);

        gui.getNameOfBook().setEnabled(false);
        gui.getAuthorOfBook().setEnabled(false);
        gui.getPublishing().setEnabled(false);
        gui.getYearOfRelease().setEnabled(false);
        gui.getBookLocation().setEnabled(false);
        gui.getBookDescription().setEnabled(false);
        gui.getSendSuggest().setEnabled(false);

        gui.getSearchBook().setText("");
        gui.getNameOfBook().setText("");
        gui.getAuthorOfBook().setText("");
        gui.getPublishing().setText("");
        gui.getYearOfRelease().setText("");
        gui.getBookLocation().setText("");
        gui.getBookDescription().setText("");
    }

    private void userSendSuggestion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name of book: " + gui.getNameOfBook().getText() + "\n");
        sb.append("Author: " + gui.getAuthorOfBook().getText() + "\n");
        sb.append("Description: " + gui.getBookDescription().getText() + "\n");

        String email = gui.getPerson().geteMail();
        // Диалоговое окно ввода данных
        String password = JOptionPane.showInputDialog(gui.getFrame(),
                new String[]{"Введите пароль от вашего eMail",
                        ""},
                "Авторизация",
                JOptionPane.QUESTION_MESSAGE);
        sendingToAdmins(email, password, sb.toString());
        userNormalState();

    }

    private void sendingToAdmins(String fromEmail, String password, String suggestion) {
        List<String> listEmail = catalogAction.getListEmailOfUserOrAdmin(CatalogAction.ADMINEMAIL);
        catalogAction.sendEmail(listEmail, suggestion, "Предложение!", fromEmail, password);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JTextField) {
            System.out.print("Searching");
            this.searchingBook();
        } else if (e.getSource() instanceof JButton) {
            if (((JButton) e.getSource()).getText().equalsIgnoreCase(gui.getPrev().getText())) {
                this.prevBook();
            } else if (((JButton) e.getSource()).getText().equalsIgnoreCase(gui.getNext().getText())) {
                this.nextBook();
            } else if (((JButton) e.getSource()).getText().equalsIgnoreCase(gui.getAddBook().getText())) {
                this.addBook();
            } else if (((JButton) e.getSource()).getText().equalsIgnoreCase(gui.getDeliteBook().getText())) {
                this.deliteBook();
            } else if (((JButton) e.getSource()).getText().equalsIgnoreCase(gui.getSuggestion().getText())) {
                this.userSuggestion();
            } else if (((JButton) e.getSource()).getText().equalsIgnoreCase(gui.getSendSuggest().getText())) {
                this.userSendSuggestion();
            }
        }
    }
}
