package by.etc.introdaction.strings;

//Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
//def", то должно быть выведено "abcdef".
public class RemoveReplication {
    public static void main(String[] args) {

        String str = "remove all copy";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) != ' ') && (!(sb.toString().contains(str.substring(i, i + 1))))) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
