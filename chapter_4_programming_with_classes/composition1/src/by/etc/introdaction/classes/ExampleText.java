package by.etc.introdaction.classes;

public class ExampleText {
    public static void main(String[] args) {
        Word[] words = new Word[5];
        words[0] = new Word("Java");
        words[1] = new Word("!is");
        words[2] = new Word("most?");
        words[3] = new Word("popular");
        words[4] = new Word("language");

        Sentence sentence = new Sentence(words, '!');

        Text text = new Text("JAVA", sentence);

        text.showText();

        words[0] = new Word("Is");
        words[1] = new Word("Java-Script");

        text.appendText(new Sentence(words, '?'));
        text.setHeader("Java-Script");

        text.showText();
    }
}
