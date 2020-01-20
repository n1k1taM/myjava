package by.etc.introdaction.tasks.person;

import java.io.FileNotFoundException;
import java.util.Objects;

public abstract class Person {
   private String name;
   private String surname;
   private String patronymic;
   private String eMail;
   private String password;

   public Person(String name,String surname,String patronymic,String eMail, String password){
       this.name=name;
       this.surname=surname;
       this.patronymic=patronymic;
       this.eMail=eMail;
       this.password=password;
   }

    public Person(String name, String surname, String patronymic, String eMail) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    abstract public boolean addPerson() throws FileNotFoundException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(patronymic, person.patronymic) &&
                Objects.equals(eMail, person.eMail) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic);
    }
}
