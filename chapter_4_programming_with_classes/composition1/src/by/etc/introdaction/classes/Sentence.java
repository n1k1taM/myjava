package by.etc.introdaction.classes;

public class Sentence {
    private StringBuilder value = new StringBuilder();

    //Object of class Sentence should end with one of the characters (. ! ? ...). 'm' = "..."
    public Sentence(Word word, char symbolOfEnd) {
        this.value.append(word.getValue());
        if (symbolOfEnd == '.') {
            this.value.append('.');
        } else if (symbolOfEnd == 'm') {
            this.value.append("...");
        } else if (symbolOfEnd == '?') {
            this.value.append('?');
        } else if (symbolOfEnd == '!') {
            this.value.append('!');
        } else {
            this.value.append('.');
        }
    }

    public Sentence(Word[] words, char symbolOfEnd) {
        for (Word w : words) {
            this.value.append(w.getValue() + " ");
        }
        this.value.setLength(value.length() - 1);
        if (symbolOfEnd == '.') {
            this.value.append('.');
        } else if (symbolOfEnd == 'm') {
            this.value.append("...");
        } else if (symbolOfEnd == '?') {
            this.value.append('?');
        } else if (symbolOfEnd == '!') {
            this.value.append('!');
        } else {
            this.value.append('.');
        }
    }

    public void addValue(Word word, int position) {
        value.insert(position, word.getValue());
    }

    public String getValue() {
        return value.toString();
    }
}
