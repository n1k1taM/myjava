package by.etc.introdaction.tasks.views;

import by.etc.introdaction.tasks.actions.GUIActions;
import by.etc.introdaction.tasks.person.AdminPerson;
import by.etc.introdaction.tasks.person.Person;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JLabel typeOfUser = new JLabel();
    private JLabel name = new JLabel("user or admin");
    private JLabel bookName = new JLabel("Name: ");
    private JLabel authorBook = new JLabel("Author: ");
    private JLabel publishingHouse = new JLabel("Publishing house: ");
    private JLabel year = new JLabel("Year: ");
    private JLabel location = new JLabel("Location: ");
    private JLabel description = new JLabel("Short description: ");
    private JLabel search = new JLabel("Search: ");
    private JLabel searchResult = new JLabel("Result of searching: ");

    private JTextField nameOfBook = new JTextField(20);
    private JTextField authorOfBook = new JTextField(20);
    private JTextField publishing = new JTextField(20);
    private JTextField yearOfRelease = new JTextField(20);
    private JTextField bookLocation = new JTextField(20);
    private JTextArea bookDescription = new JTextArea(5, 20);
    private JTextField searchBook = new JTextField(20);
    private JTextField resultSearching = new JTextField(20);

    private JButton next = new JButton("Next");
    private JButton prev = new JButton("Prev");
    private JButton sendSuggest = new JButton("Send");
    private JButton suggestion = new JButton("Suggestion");
    private JButton addBook = new JButton("Add book");
    private JButton deliteBook = new JButton("Delite book");

    private JRadioButton radio1 = new JRadioButton("Searching by name");
    private JRadioButton radio2 = new JRadioButton("Searching by author");

    ButtonGroup radioGroup = new ButtonGroup();


    JFrame frame = new JFrame("Catalog of books");
    JPanel mainPanel = new JPanel();
    JPanel left = new JPanel();
    JPanel right = new JPanel();

    JPanel searchPanel = new JPanel();
    JPanel radioGroupPanel = new JPanel();
    JPanel namePanel = new JPanel();
    JPanel authorPanel = new JPanel();
    JPanel publishPanel = new JPanel();
    JPanel yearPanel = new JPanel();
    JPanel locationPanel = new JPanel();
    JPanel descriptionPanel = new JPanel();

    JPanel adminOrUserPanel = new JPanel();
    private Person person;

    public GUI(Person person) {
        this.person = person;
        guiInit(person);

    }

    public void guiInit(Person person) {
        String personAsString = person.getSurname() + " " + person.getName() + " " + person.getPatronymic();
        commonInit(personAsString);
        if (person instanceof AdminPerson) {
            adminInit();
        } else {
            userInit();
        }
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(BorderLayout.SOUTH, adminOrUserPanel);
        frame.setSize(600, 400);
        frame.setVisible(true);


    }

    private void commonInit(String personAsString) {
        bookDescription.setLineWrap(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        name.setText(personAsString);
        frame.getContentPane().add(BorderLayout.NORTH, name);
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        searchPanel.add(search);
        searchPanel.add(searchBook);
        search.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
        mainPanel.add(searchPanel);

        radioGroup.add(radio1);
        radioGroup.add(radio2);
        radio1.setSelected(true);
        mainPanel.add(radio1);
        mainPanel.add(radio2);

        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        bookName.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 80));
        nameOfBook.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        namePanel.add(bookName);
        namePanel.add(nameOfBook);
        namePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        namePanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        mainPanel.add(namePanel);

        authorPanel.setLayout(new BoxLayout(authorPanel, BoxLayout.X_AXIS));
        authorPanel.add(authorBook);
        authorBook.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 73));
        authorPanel.add(authorOfBook);
        authorOfBook.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        authorPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        authorPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        mainPanel.add(authorPanel);

        publishPanel.setLayout(new BoxLayout(publishPanel, BoxLayout.X_AXIS));
        publishPanel.add(publishingHouse);
        publishingHouse.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 16));
        publishPanel.add(publishing);
        publishing.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        publishPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        publishPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        mainPanel.add(publishPanel);

        yearPanel.setLayout(new BoxLayout(yearPanel, BoxLayout.X_AXIS));
        yearPanel.add(year);
        year.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 86));
        yearPanel.add(yearOfRelease);
        yearOfRelease.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        yearPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        yearPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        mainPanel.add(yearPanel);

        locationPanel.setLayout(new BoxLayout(locationPanel, BoxLayout.X_AXIS));
        locationPanel.add(location);
        location.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 67));
        locationPanel.add(bookLocation);
        bookLocation.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        locationPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        locationPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        mainPanel.add(locationPanel);

        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.add(description);
        descriptionPanel.add(bookDescription);
        bookDescription.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 20));
        descriptionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        mainPanel.add(descriptionPanel);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        adminOrUserPanel.setLayout(new BoxLayout(adminOrUserPanel, BoxLayout.X_AXIS));

        adminOrUserPanel.add(prev);
        adminOrUserPanel.add(next);


    }

    private void adminInit() {
        adminOrUserPanel.add(addBook);
        adminOrUserPanel.add(deliteBook);
    }

    private void userInit() {

        adminOrUserPanel.add(suggestion);
        adminOrUserPanel.add(sendSuggest);
        sendSuggest.setEnabled(false);

        nameOfBook.setEnabled(false);
        authorOfBook.setEnabled(false);
        publishing.setEnabled(false);
        yearOfRelease.setEnabled(false);
        bookLocation.setEnabled(false);
        bookDescription.setEnabled(false);
    }

    public JLabel getTypeOfUser() {
        return typeOfUser;
    }

    public JTextField getNameOfBook() {
        return nameOfBook;
    }

    public JTextField getAuthorOfBook() {
        return authorOfBook;
    }

    public JTextField getPublishing() {
        return publishing;
    }

    public JTextField getYearOfRelease() {
        return yearOfRelease;
    }

    public JTextField getBookLocation() {
        return bookLocation;
    }

    public JTextArea getBookDescription() {
        return bookDescription;
    }

    public JTextField getSearchBook() {
        return searchBook;
    }

    public JRadioButton getRadio1() {
        return radio1;
    }

    public JRadioButton getRadio2() {
        return radio2;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook.setText(nameOfBook);
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook.setText(authorOfBook);
    }

    public void setPublishing(String publishing) {
        this.publishing.setText(publishing);
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease.setText(Integer.toString(yearOfRelease));
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation.setText(bookLocation);
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription.setText(bookDescription);
    }

    public JLabel getName() {
        return name;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getPrev() {
        return prev;
    }

    public JButton getSendSuggest() {
        return sendSuggest;
    }

    public JButton getSuggestion() {
        return suggestion;
    }

    public JButton getAddBook() {
        return addBook;
    }

    public JButton getDeliteBook() {
        return deliteBook;
    }

    public Person getPerson() {
        return person;
    }

    public JFrame getFrame() {
        return frame;
    }

    public ButtonGroup getRadioGroup() {
        return radioGroup;
    }
}
