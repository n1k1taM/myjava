package by.etc.introdaction.strings;

//В строке вставить после каждого символа 'a' символ 'b'.
public class BAfterA {
    public static void main(String[] args) {
        int j = 0;// difference between indexes in String str and StringBuilder sb
        char c = ' ';
        String str = "Java 1.0, - was released only on January 21, 1996";
        System.out.println(str);

        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if ((c == 'a') || (c == 'A')) {
                sb.insert(i + 1 + j, 'b');// paste in the next position relative to the current
                j++;
            }
        }
        System.out.println(sb);
    }
}
