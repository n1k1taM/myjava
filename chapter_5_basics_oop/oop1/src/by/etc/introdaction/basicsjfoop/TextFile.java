//Создать объект класса Текстовый файл, используя классы Файл, Директория.
// Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
package by.etc.introdaction.basicsjfoop;

import java.io.IOException;

public class TextFile extends File {

    public TextFile(Directory directory, String nameFile) throws IOException, InvalidFileExtentionException {
        super(directory, nameFile, ".txt");
    }
}
