package by.etc.introdaction.strings;

import java.util.Scanner;

//Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
// заменить на одиночные пробелы. Крайние пробелы в строке удалить.
public class BlankDelite {
    static int begin = 0;
    static int end = 0;

    public static void main(String[] args) {
        String str = new String();

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the string:");
            str = sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("You entered invalid characters");
            System.exit(0);
        }

        char[] forNewString = new char[countWhitespace(str)];// создаем новый массив нужного размера
        System.out.println(forNewString.length);// выводим размер массива
        System.out.println(deliteWhitespace(str, forNewString));//выводим новую строку

    }

    // метод заполняет переданный ему массив символами с переданной строки согласно с условием
    private static char[] deliteWhitespace(String s, char[] forNewString_) {
        boolean flag = false;
        int num = 0;
        char[] original = s.toCharArray();

        for (int i = begin; i <= end; i++) {
            if (!Character.isWhitespace(original[i])) {// если символ, то добавляем в массив forNewString
                // и ставим флаг true
                if (num < forNewString_.length) {
                    forNewString_[num] = original[i];
                    num++;
                    flag = true;
                }
            } else {
                //пробел. Если пробел после символа, то флаг true и добавляем
                // в массив один пробел, флаг в false
                if ((flag == true) && (num < forNewString_.length)) {
                    forNewString_[num] = ' ';
                    num++;
                }
                flag = false;
            }
        }
        return forNewString_;
    }

    //method return count simbol, which should attend in new string
    private static int countWhitespace(String s) {
        int beginIndex = 0;
        int endIndex = 0;
        int lengthArr = 0;
        char c = ' ';
        boolean flag = false;
        char[] charString = s.toCharArray();

        for (int j = 0; j < charString.length; j++) {
            c = charString[j];
            //если символ, то запоминаем начальный индекс и выходим из цикла
            if (!Character.isWhitespace(c)) {
                beginIndex = j;//begin index
                break;
            }
        }
        for (int j = charString.length - 1; j >= 0; j--) {
            c = charString[j];
            //если символ, то запоминаем конечный индекс и выходим из цикла
            if (!Character.isWhitespace(c)) {
                endIndex = j;//end index
                break;
            }
        }
        //считаем от начального до конечного индекса исключая пробелы
        //считаем и пробел, если есть переход с пробела на символ
        begin = beginIndex;
        end = endIndex;
        for (int j = beginIndex; j <= endIndex; j++) {
            c = charString[j];

            if (!Character.isWhitespace(c)) {
                lengthArr++;
                if (flag == true) {
                    lengthArr++;
                    flag = false;
                }
            } else {
                flag = true;
            }
        }
        return lengthArr;
    }
}