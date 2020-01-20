package by.etc.introdaction.tasks.books;

public class EBook extends Book {

   private String location;

    public EBook(String name, String author, String publishingHouse, int year, String description, String url){
        super(name,author,publishingHouse,year,description,url);
        this.location=url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
