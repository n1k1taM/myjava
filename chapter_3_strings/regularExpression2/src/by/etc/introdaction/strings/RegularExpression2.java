package by.etc.introdaction.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Дана строка, содержащая следующий текст (xml-документ):
//<notes>
//<note id = "1">
//<to>Вася</to>
//<from>Света</from>
//<heading>Напоминание</heading>
//<body>Позвони мне завтра!</body>
//</note>
//<note id = "2">
//<to>Петя</to>
//<from>Маша</from>
//<heading>Важное напоминание</heading>
//<body/>
//</note>
//</notes>
//Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип
// (открывающий тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML
// для решения данной задачи нельзя.
public class RegularExpression2 {
    static Pattern pattern1;
    static Pattern pattern2;
    static Pattern pattern3;
    static Pattern pattern4;
    static Pattern pattern5;
    static Matcher matcher1;
    static Matcher matcher2;
    static Matcher matcher3;
    static Matcher matcher4;
    static Matcher matcher5;


    public static void main(String[] args) {

        String string = new String("<notes><note id =\"1\"><to>Вася</to><from>Света</from><heading>Напоминание</heading>" +
                "<body>Позвони мне завтра!</body></note><note id =\"2\"><to>Петя</to><from>Маша</from>" +
                "<heading>Важное напоминание</heading><body/></note></notes>");

        RegularExpression2.xmlParser(string);
    }

    //метод проверяет совпадает ли тот или иной шаблон с входящей строкой
    public static void xmlParser(String input) {
        //разбиваем строку на лексемы по разделителю ">"
        String[] elements = input.split(">");
        for (int i = 0; i < elements.length; i++) {
            //добавляем к каждой строке в конце символ ">"
            elements[i] = elements[i] + ">";
        }

        //создаем 5 шаблонов для поиска различных элементов xml
        pattern1 = Pattern.compile("<([^<>\\s/]+)>");//открывающий тег без атрибутов
        pattern2 = Pattern.compile("<([^/<>\\s]+)(\\s+[^><\\s]+\\s*=\\s*[^><\\s]+)+>");//открывающий тег с атрибутами
        pattern3 = Pattern.compile("([^<>]+)</([^<>\\s]+)>");//тело тега + закрывающий тег
        pattern4 = Pattern.compile("<([^/<>\\s]+)/>");//тег без тела
        pattern5 = Pattern.compile("(</([^/<>\\s]+)>)");//закрывающий тег


        for (int j = 0; j < elements.length; j++) {

            matcher1 = pattern1.matcher(elements[j]);
            matcher2 = pattern2.matcher(elements[j]);
            matcher3 = pattern3.matcher(elements[j]);
            matcher4 = pattern4.matcher(elements[j]);
            matcher5 = pattern5.matcher(elements[j]);

            if (matcher1.find()) {
                System.out.println("Откравающий тег: " + matcher1.group());
            } else if (matcher2.find()) {
                System.out.println("Откравающий тег: " + "<" + matcher2.group(1) + ">" + " Атрибуты: " + matcher2.group(2));
            } else if (matcher3.find()) {
                System.out.println("Тело тега: " + matcher3.group(1) + " Закрывающий тег: " + "</" + matcher3.group(2) + ">");
            } else if (matcher4.find()) {
                System.out.println("Тег без тела: " + matcher4.group());
            } else if (matcher5.find()) {
                System.out.println("Закрывающийся тег: " + matcher5.group(1));
            }
        }
    }
}
