package by.etc.introdaction.classes;

//Создать объект класса Текст, используя классы Предложение, Слово. Методы:
// дополнить текст, вывести на консоль текст, заголовок текста.
public class Text {
    private StringBuilder textValue = new StringBuilder();
    private String header;

    Text(String header, Sentence phrase) {
        this.textValue.append(phrase.getValue());
        this.header = header;
    }

    Text(String header, Sentence[] phrases) {
        this.header = header;
        for (Sentence s : phrases) {
            this.textValue.append(s.getValue() + " ");
        }
    }

    public String getTextValue() {
        return textValue.toString();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void appendText(Word word) {
        textValue.append(" " + word.getValue());
    }

    public void appendText(Sentence sentence) {
        textValue.append(" " + sentence.getValue());
    }

    public void showText() {
        System.out.println(header);
        System.out.println(textValue);
    }
}
