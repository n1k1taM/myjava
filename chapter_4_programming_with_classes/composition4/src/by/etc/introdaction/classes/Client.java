package by.etc.introdaction.classes;

import java.util.*;

final public class Client {
    private static Set<String> uniqueNumberOfPasport = new TreeSet<String>();
    private long id;
    private static long idd = 0;
    private String name;
    private String surname;
    private String patronymic;
    private String numberOfPassport;

    Client(String name, String surname, String patronymic, String numberOfPassport) throws PassportException {
        if (uniqueNumberOfPasport.contains(numberOfPassport)) {
            throw new PassportException("Two person can't have same number of passport");
        } else {
            uniqueNumberOfPasport.add(numberOfPassport);
            this.id = idd++;
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.numberOfPassport = numberOfPassport;
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getNumberOfPassport() {
        return numberOfPassport;
    }

    class PassportException extends Exception {
        public PassportException(String message) {
            super(message);
        }
    }
}
