package by.etc.introdaction.tasks.books;

import java.util.Objects;

public abstract class Book  {
    private String name;
    private String author;
    private String publishingHouse;
    private int year;
    private String description;
    private String location;

    public Book(String name, String author, String publishingHouse, int year, String description,String location){
        this.name=name;
        this.author=author;
        this.publishingHouse=publishingHouse;
        this.year=year;
        this.description=description;
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return name.equals(((Book) o).getName())&&author.equals(((Book) o).getAuthor())&&
                publishingHouse.equals(((Book) o).getPublishingHouse())&&location.equals(((Book) o).getLocation())&&
                description.equals(((Book) o).getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash( author);
    }
}
