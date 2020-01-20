package by.etc.introdaction.classes;
//Создать класс Book, спецификация которого приведена ниже.
// Определить конструкторы, set- и get- методы и метод toString().
// Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
// Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.
public class Book {

    private static int idd=0;

    private int id;
    private String name;
    private String author;
    private String publishingHouse;
    private int year;
    private int pages;
    private int price;
    private String binding;

    Book(String name,String author,String publishingHouse,String binding,int year, int pages,int price){
        this.id=idd++;
        this.name=name;
        this.author=author;
        this.publishingHouse=publishingHouse;
        this.binding=binding;
        this.year=year;
        this.pages=pages;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public String toString(){
        return getId()+" "+getAuthor()+" "+getName()+" Издательство: "+getPublishingHouse()+" "+getYear()+" "+getBinding()+
                " "+ ", количество страниц: "+getPages()+ " Стоимость: "+getPrice();
    }
}
