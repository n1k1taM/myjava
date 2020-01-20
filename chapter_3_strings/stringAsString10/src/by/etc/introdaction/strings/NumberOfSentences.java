package by.etc.introdaction.strings;

//Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
//знаком. Определить количество предложений в строке X.
public class NumberOfSentences {
    public static void main(String[] args) {

        char c = ' ';
        int number = 0;
        boolean b = true;
        String str = "I work. You work! She works... They worked?";
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if ((c == '.') || (c == '!') || (c == '?')) {
                if (b == true) {
                    number++;
                    b = false;
                }
            } else {
                b = true;
            }
        }
        System.out.println("Number of sentences = " + number);
    }
}
