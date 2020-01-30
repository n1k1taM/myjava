package by.etc.introdaction.tasks.views;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notebook {
    private static ArrayList<Note> notes;

    public Notebook(){
        notes=new ArrayList<>();
        fillInFromFile();
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    private void fillInFromFile()  {
        List<String> listOfNotes=new ArrayList<>();
        Path path = Paths.get("d:\\ListOfNotes.txt");
        try{
            //check if listOfNotes file exists
            if (!Files.exists(path)) {
                path = Files.createFile(path);
            }
            listOfNotes= Files.readAllLines(Paths.get("d:\\ListOfNotes.txt"), Charset.forName("UTF-8"));
        }catch(IOException e){
            e.printStackTrace();
        }
        String[] array;
        Note note;
        for (String noteAsString:listOfNotes) {
            array=noteAsString.split("%");
            note=new Note(array[0],array[1],array[2]);
            note.setDateOfCreating((array[3]));
            notes.add(note);
        }
    }
}
