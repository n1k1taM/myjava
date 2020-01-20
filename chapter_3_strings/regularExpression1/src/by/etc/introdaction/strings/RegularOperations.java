package by.etc.introdaction.strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
алфавиту.
 */
public class RegularOperations implements ActionListener {
    JFrame frame;
    JPanel panel;
    JPanel panel1;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JRadioButton radioButton3;
    JRadioButton radioButton0;
    JTextArea textArea1;
    JTextArea textArea2;
    JLabel hint;
    static String str = "";
    Pattern pattern;
    Matcher matcher;
    StringBuilder sb;
    ArrayList<String> arrayList;

    public static void main(String[] args) {
        str = " This is how I tried to split a paragraph into a sentence. But, there is a problem." +
                " My paragraph includes dates like Jan.13, 2014 , words like U.S and numbers like 2.2." +
                " They all got split by the above code.\n It is second paragraph. It has 2 sentense. ";
        RegularOperations reg = new RegularOperations();
        reg.init();
    }

    public void init() {
        frame = new JFrame("RegularOperations");
        radioButton0 = new JRadioButton("Исходный текст");
        radioButton1 = new JRadioButton("Сортировка обзацев по количеству предложений");
        radioButton2 = new JRadioButton("Сортировка слов по длине в предложениях");
        radioButton3 = new JRadioButton("Сортировка лексем в предложении по убыванию заданного символа");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);
        bg.add(radioButton0);
        textArea1 = new JTextArea(str);
        textArea1.setFont(new Font("monospaced", Font.ITALIC, 18));
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea2 = new JTextArea("    ");
        hint = new JLabel();
        JLabel label = new JLabel("Введите символ");
        radioButton0.addActionListener(this);
        radioButton1.addActionListener(this);
        radioButton2.addActionListener(this);
        radioButton3.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(radioButton0);
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

        panel1 = new JPanel();
        panel1.add(label);
        panel1.add(textArea2);

        panel.add(panel1);
        panel.add(hint);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, textArea1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton rb = (JRadioButton) e.getSource();
        sb = new StringBuilder();
        arrayList = new ArrayList<String>();
        if ((rb.getText()).equals("Сортировка обзацев по количеству предложений")) {
            sortParagraph();
            hint.setText("");
        } else if ((rb.getText()).equals("Сортировка слов по длине в предложениях")) {
            sortWords(str);
            hint.setText("");
        } else if ((rb.getText()).equals("Сортировка лексем в предложении по убыванию заданного символа")) {
            sortOfNumberSymbol();
        } else if ((rb.getText()).equals("Исходный текст")) {
            textArea1.setText(str);
            hint.setText("");
        }
    }

    public void sortParagraph() {
        int count = 0;
        String[] array = str.split("\\n");
        int[] numberSentence = new int[array.length];
        pattern = Pattern.compile("[^.!?\\s][^.!?]*([.!?](?!\\s|\\.|\\!|\\?)[^.!?]*)*", Pattern.MULTILINE | Pattern.COMMENTS);
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                count++;
            }
            numberSentence[i] = count;
            count = 0;
        }
        int buf = 0;
        String string = "";
        for (int n = 0; n < numberSentence.length; n++) {
            for (int m = 0; m < numberSentence.length - 1 - n; m++) {
                if (numberSentence[n] > numberSentence[n + 1]) {
                    buf = numberSentence[n];
                    numberSentence[n] = numberSentence[n + 1];
                    numberSentence[n + 1] = buf;
                    string = array[n];
                    array[n] = array[n + 1];
                    array[n + 1] = string;
                }
            }
        }
        for (String ss : array) {
            sb.append(ss);
            sb.append("\n");
        }
        textArea1.setText(sb.toString());
    }

    public void sortWords(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> al = new ArrayList<String>();
        pattern = Pattern.compile("[^.!?\\s][^.!?]*([.!?](?!\\s|\\.|\\!|\\?)[^.!?]*)*", Pattern.MULTILINE | Pattern.COMMENTS);
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            //каждое найденное совпадение (предложение) добавляем в ArrayList
            al.add(matcher.group());
        }
        //каждое предложение разбиваем на массив слов и применяем сортировку выбором к массиву
        for (String s : al) {
            String[] words = s.split(" ");
            int min = Integer.MAX_VALUE;
            StringBuilder minStr = new StringBuilder();
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i; j < words.length; j++) {
                    if (words[j].length() < min) {
                        min = words[j].length();
                        minStr = new StringBuilder(words[j]);
                        index = j;
                    }
                }
                words[index] = words[i];
                words[i] = minStr.toString();
                min = Integer.MAX_VALUE;
            }
            for (int l = 0; l < words.length; l++) {
                stringBuilder.append(words[l] + " ");
            }
            stringBuilder.append(". ");
        }
        textArea1.setText(stringBuilder.toString());
    }

    public void sortOfNumberSymbol() {
        String strSymbol = textArea2.getText().trim();
        if (strSymbol.length() != 1) {
            hint.setText("Вы должны ввести только 1 символ");
        } else {
            hint.setText(" ");
        }
        char symbol = textArea2.getText().charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> al = new ArrayList<String>();
        pattern = Pattern.compile("[^.!?\\s][^.!?]*([.!?](?!\\s|\\.|\\!|\\?)[^.!?]*)*", Pattern.MULTILINE | Pattern.COMMENTS);
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            //каждое найденное совпадение (предложение) добавляем в ArrayList
            al.add(matcher.group());
        }
        //каждое предложение разбиваем на массив слов и применяем сортировку выбором к массиву
        for (String s : al) {
            String[] words = s.split(" ");
            int max = 0;
            int include = 0;
            StringBuilder maxSymbol = new StringBuilder();
            int index = 0;
            boolean change = false;
            for (int i = 0; i < words.length; i++) {
                for (int j = i; j < words.length; j++) {
                    pattern = Pattern.compile(strSymbol, Pattern.CASE_INSENSITIVE);
                    matcher = pattern.matcher(words[j]);
                    while (matcher.find()) {
                        include++;
                    }
                    if (include > max) {
                        max = include;
                        maxSymbol = new StringBuilder(words[j]);
                        index = j;
                        change = true;
                    }
                    if (include == max) {
                        //при равенстве символов -> сравнение по алфавиту
                        if (words[j].compareToIgnoreCase(maxSymbol.toString()) < 0) {
                            max = include;
                            maxSymbol = new StringBuilder(words[j]);
                            index = j;
                        }
                    }
                    include = 0;
                }
                if (change == true) {
                    words[index] = words[i];
                    words[i] = maxSymbol.toString();
                }
                max = 0;
                change = false;
            }
            for (int l = 0; l < words.length; l++) {
                stringBuilder.append(words[l] + " ");
            }
            stringBuilder.append(". ");
        }
        textArea1.setText(stringBuilder.toString());
    }
}

