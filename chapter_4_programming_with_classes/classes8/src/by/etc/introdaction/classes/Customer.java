package by.etc.introdaction.classes;
//Создать класс Customer, спецификация которого приведена ниже.
// Определить конструкторы, set- и get- методы и метод toString().
// Создать второй класс, агрегирующий массив типа Customer, с подходящими
// конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
//Найти и вывести:
//a) список покупателей в алфавитном порядке;
//b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
public class Customer implements Comparable<Customer> {
    private static int idd=0;
    private static int numberCard=1000;
    private static int numberAccaunt=2000;

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String adress;
    private int creditCard;
    private int bankAccaunt;

    Customer(){
        id=idd++;
        name="Владимир";
        surname="Иванов";
        patronymic="Михайлович";
        adress="г. Минск";
        creditCard=numberCard++;
        bankAccaunt=numberAccaunt++;
    }

    Customer(String name,String surname,String patronymic,String adress){
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
        this.adress=adress;

        id=idd++;
        creditCard=numberCard++;
        bankAccaunt=numberAccaunt++;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Customer.idd = idd;
    }

    public static int getNumberCard() {
        return numberCard;
    }

    public static void setNumberCard(int numberCard) {
        Customer.numberCard = numberCard;
    }

    public static int getNumberAccaunt() {
        return numberAccaunt;
    }

    public static void setNumberAccaunt(int numberAccaunt) {
        Customer.numberAccaunt = numberAccaunt;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public int getBankAccaunt() {
        return bankAccaunt;
    }

    public void setBankAccaunt(int bankAccaunt) {
        this.bankAccaunt = bankAccaunt;
    }

    @Override
    public String toString(){
        return getId()+" "+getSurname()+" "+getName()+" "+getPatronymic()+" Адрес: "+getAdress()+" Номер кредитной карты: "+getCreditCard()+
                " Номер счета в банке: "+getBankAccaunt();
    }

    @Override
    public int compareTo(Customer o) {
        return (this.getSurname()+this.getName()+this.getPatronymic()).compareTo(o.getSurname()+o.getName()+o.getPatronymic());
    }
}
