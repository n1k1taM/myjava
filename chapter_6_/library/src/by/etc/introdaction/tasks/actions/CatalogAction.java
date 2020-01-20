package by.etc.introdaction.tasks.actions;

import by.etc.introdaction.tasks.books.Book;
import by.etc.introdaction.tasks.person.AdminPerson;
import by.etc.introdaction.tasks.person.Person;
import by.etc.introdaction.tasks.person.UserPerson;
import by.etc.introdaction.tasks.views.Catalog;
import by.etc.introdaction.tasks.books.EBook;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CatalogAction {
    private Catalog catalog;
    protected static final int USEREMAIL = 1;
    protected static final int ADMINEMAIL = 2;

    public CatalogAction() {
        catalog = new Catalog();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public boolean addBook(Book book, String adminEmail, String passwordEmail) {

        catalog.getListOfBook().add(book);
        addInFile(book);

        List<String> emails = getListEmailOfUserOrAdmin(CatalogAction.USEREMAIL);
        sendEmail(emails, book.getDescription(), "Новая книга!", adminEmail, passwordEmail);
        return true;

    }

    public boolean deliteBook(Book book) {
        Book book1;
        for (int i = 0; i < catalog.getListOfBook().size(); i++) {
            book1 = catalog.getListOfBook().get(i);
            if (book1.equals(book)) {
                Book bookDelite = catalog.getListOfBook().get(i);
                deliteFromFile(book);
                catalog.getListOfBook().remove(i);
                return true;
            }
        }
        return false;
    }

    public Book searchBook(Book book) {
        for (Book b : catalog.getListOfBook()) {
            if (b.getName().equalsIgnoreCase(book.getName())) {
                return b;
            }
        }
        return null;
    }

    private int binarySearch(List<Book> listOfBook, String nameOfBook, int first, int last) {
        if (listOfBook.size() == 0) {
            return 0;
        }
        if (first > last) {
            return -1;
        }
        int mid = first + (last - first) / 2;
        if (nameOfBook.compareToIgnoreCase(listOfBook.get(mid).getName()) < 0) {
            return binarySearch(listOfBook, nameOfBook, first, mid - 1);
        } else if (nameOfBook.compareToIgnoreCase(listOfBook.get(mid).getName()) > 0) {
            return binarySearch(listOfBook, nameOfBook, mid + 1, last);
        } else {
            return mid;
        }
    }

    private boolean addInFile(Book book) {
        Path path = Paths.get("d:\\ListOfBook.txt");
        try {
            if (!Files.exists(path)) {
                path = Files.createFile(path);
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        StringBuilder sb;
        if (book instanceof EBook) {
            sb = new StringBuilder("eBook: %");
        } else {
            sb = new StringBuilder("Paper Book: %");
        }

        try (FileOutputStream fileStream = new FileOutputStream(new File(path.toString()), true); OutputStreamWriter writer = new OutputStreamWriter(fileStream, "UTF-8");) {

            sb.append(book.getName() + "%");
            sb.append(book.getAuthor() + "%");
            sb.append(book.getPublishingHouse() + "%");
            sb.append(book.getYear() + "%");
            sb.append(book.getLocation() + "%");
            sb.append(book.getDescription() + "_\n");
            writer.write(sb.toString());
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    private boolean deliteFromFile(Book book) {
        Path path = Paths.get("d:\\ListOfBook.txt");
        try {
            if (!Files.exists(path)) {
                path = Files.createFile(path);

            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        StringBuilder allListAsString = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\ListOfBook.txt"))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                allListAsString.append(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        StringBuilder sb;
        if (book instanceof EBook) {
            sb = new StringBuilder("eBook: %");
        } else {
            sb = new StringBuilder("Paper Book: %");
        }
        sb.append(book.getName() + "%");
        sb.append(book.getAuthor() + "%");
        sb.append(book.getPublishingHouse() + "%");
        sb.append(book.getYear() + "%");
        sb.append(book.getDescription() + "%");
        sb.append(book.getLocation() + "_");

        if (allListAsString.toString().contains(sb.toString())) {
            int position = allListAsString.indexOf(sb.toString());
            int size = sb.toString().length();
            allListAsString.delete(position, position + size);
            writeInFile(allListAsString.toString());
            return true;
        } else {
            return false;
        }
    }

    private void writeInFile(String string) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:\\ListOfBook.txt"))) {
            bufferedWriter.write(string, 0, string.length());
            bufferedWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    protected List<String> getListEmailOfUserOrAdmin(int userOrAdmin) {
        ArrayList<String> listEmails = new ArrayList<>();
        if (userOrAdmin == 1) {
            List<Person> persons = catalog.getListOfPerson();
            for (Person person : persons) {
                if (person instanceof UserPerson) {
                    listEmails.add(person.geteMail());
                }
            }
        } else if (userOrAdmin == 2) {
            List<Person> persons = catalog.getListOfPerson();
            for (Person person : persons) {
                if (person instanceof AdminPerson) {
                    listEmails.add(person.geteMail());
                }
            }
        } else {
            List<Person> persons = catalog.getListOfPerson();
            for (Person person : persons) {
                listEmails.add(person.geteMail());
            }
        }
        return listEmails;
    }

    protected void sendEmail(List<String> emails, String description, String theme, String username, String password) {
        Address[] addresses = new Address[emails.size()];
        for (int i = 0; i < emails.size(); i++) {
            try {
                addresses[i] = new InternetAddress(emails.get(i));
            } catch (AddressException ae) {
                ae.printStackTrace();
            }
        }
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.sendpartial", "true");
        Session session = Session.getDefaultInstance(props);
        //создаем сообщение
        MimeMessage message = new MimeMessage(session);
        try {
            //устанавливаем тему письма
            message.setSubject(theme);
//добавляем текст письма
            message.setText(description);
//указываем получателя
            message.addRecipients(Message.RecipientType.TO, addresses);
//авторизуемся на сервере:
            Transport transport = session.getTransport();
            transport.connect("smtp.gmail.com", 465, username, password);
//отправляем сообщение:
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


}
