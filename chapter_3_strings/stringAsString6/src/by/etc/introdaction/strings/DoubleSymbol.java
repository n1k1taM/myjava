package by.etc.introdaction.strings;

//Из заданной строки получить новую, повторив каждый символ дважды
public class DoubleSymbol {
    public static void main(String[] args) {

        String str = "Java introdaction";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
                sb.append(str.charAt(i));
            } else {
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());
    }
}
