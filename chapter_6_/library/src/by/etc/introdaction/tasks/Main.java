package by.etc.introdaction.tasks;

import by.etc.introdaction.tasks.actions.GUIActions;
import by.etc.introdaction.tasks.person.AdminPerson;
import by.etc.introdaction.tasks.person.Person;
import by.etc.introdaction.tasks.views.GUI;
import by.etc.introdaction.tasks.person.UserPerson;

import java.io.IOException;

/*создать консольное приложение “Учет книг в домашней библиотеке”.
Общие требования к заданию:
• Система учитывает книги как в электронном, так и в бумажном варианте.
• Существующие роли: пользователь, администратор.
• Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
• Администратор может модифицировать каталог.
• *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям
• **При просмотре каталога желательно реализовать постраничный просмотр
• ***Пользователь может предложить добавить книгу в библиотеку, переслав её администратору на e-mail.
• Каталог книг хранится в текстовом файле.
• Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде

 */
public class Main {

    public static void main(String[] args) {

        try {

            Person admin = new AdminPerson("Веко", "Павел", "Владимирович", "pvtwobox28@gmail.com", "qwerty");
           admin.addPerson();
            Person user=new UserPerson("Иванов","Иван","Иванович","pavelveka100@gmail.com","password");
            user.addPerson();
            GUIActions guiActions=new GUIActions(user);

        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }



}
}
