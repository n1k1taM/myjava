package by.etc.introdaction.basicsjfoop;
import java.io.IOException;

public class TextFileExample {
    public static void main(String[] args)  {
        try {
            Directory directory=new Directory("c:\\javaExample");
            File file =new TextFile(directory, "TextFile1");
            file.createFile();

            file.add("Hello");
            file.add("good");
            file.add("read");

            file.rename("SuperFile");

            file.add("Bye");

            System.out.println(file.getNameFile());
            System.out.println(file.getPath());
            System.out.println(file.hashCode());
            System.out.println(file.hashCode());
            System.out.println(file.toString());
        //    System.out.println(file.deliteFile());

        } catch (InvalidDirectoryException e) {
            e.printStackTrace();
        } catch (InvalidFileExtentionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
