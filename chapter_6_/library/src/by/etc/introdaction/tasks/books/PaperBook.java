package by.etc.introdaction.tasks.books;

public class PaperBook extends Book {

    private String location;

    public PaperBook(String name, String author, String publishingHouse, int year, String description, String location) {
        super(name, author, publishingHouse, year, description,location);
        this.location=location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
