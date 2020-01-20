package by.etc.introdaction.strings;

import java.util.Arrays;

/**
 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */
public class StringAsChars1 {

    public static void main(String[] args) {
        String[] camelCase = {"camelCase", "upperCase", "lowerCase", "stringAsChars", "charAt"};
        String[] snakeCase = toSnakeCase(camelCase);

        System.out.println(String.join(", ", camelCase));
        System.out.println(String.join(", ", snakeCase));
    }

    private static String[] toSnakeCase(String[] camelCase) {
        String[] snakeCase = new String[camelCase.length];
        for (int i = 0; i < snakeCase.length; i++) {
            StringBuilder strBuilder = new StringBuilder();
            for (int j = 0; j < camelCase[i].length(); j++) {
                char letter = camelCase[i].toCharArray()[j];
                if (Character.isLowerCase(letter)) {
                    strBuilder.append(letter);
                } else {
                    strBuilder.append("_");
                    strBuilder.append(Character.toLowerCase(letter));
                }
            }
            snakeCase[i] = strBuilder.toString();
        }
        return snakeCase;
    }
}