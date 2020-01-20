package by.etc.introdaction.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private String value;

    //object of class Word should contain one word
    public Word(String value) {
        String p = "[^.!?\\s]+";
        //   String p="([^.?!\\d\\s]*(\\D)*)";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            this.value = matcher.group();
        } else {
            this.value = "null";
        }
    }

    public String getValue() {
        return value;
    }
}
