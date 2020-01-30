package by.etc.introdaction.tasks.actions;

import by.etc.introdaction.tasks.views.Note;
import by.etc.introdaction.tasks.views.Notebook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class NotebookActions {
    private final String THEME_PATTERN="^([a-zA-Z0-9]{1,18}[\\s,]?[\\s-]?[\\s]?){1,5}[\\.!?]?$";
    private final String EMAIL_PATTERN="^([a-zA-Z0-9_-]){1,15}@([a-zA-Z0-9]){1,15}\\.(com|ru|org)$";
    private final String MESSAGE_PATTERN="^((([a-zA-Z0-9-]{1,18})([\\s\\.,!?-]*))+)$";

    private Notebook notebook;

    public NotebookActions(){
        notebook=new Notebook();
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public boolean addNote(Note note){
        //нужно ли проверяьб на null ?
        if(cheackNote(note)){
            notebook.getNotes().add(note);
            if(addInFile(note)){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }

    }

    public ArrayList<Note> searchByTheme(String theme){
        ArrayList<Note>searched=new ArrayList<>();
        for (Note note:notebook.getNotes()) {
            if(note.getTheme().equals(theme.trim())){
                searched.add(note);
            }
        }
        Collections.sort(searched);
        return searched;
    }

    public ArrayList<Note> searchByEmail(String email){
        ArrayList<Note>searched=new ArrayList<>();
        for (Note note:notebook.getNotes()) {
            if(note.geteMail().equals(email.trim())){
                searched.add(note);
            }
        }
        Collections.sort(searched);
        return searched;
    }

    public ArrayList<Note> searchByWord(String word){
        ArrayList<Note>searched=new ArrayList<>();
        for (Note note:notebook.getNotes()) {
            if(note.getMessage().contains(word)){
                searched.add(note);
            }
        }
        Collections.sort(searched);
        return searched;
    }

    private boolean addInFile(Note note) {
        Path path = Paths.get("d:\\ListOfNotes.txt");
        try {
            if (!Files.exists(path)) {
                path = Files.createFile(path);
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
            return false;
        }
        StringBuilder sb=new StringBuilder();

        try (FileOutputStream fileStream = new FileOutputStream(new File(path.toString()), true); OutputStreamWriter writer = new OutputStreamWriter(fileStream, "UTF-8");) {

            sb.append(note.getTheme() + "%");
            sb.append(note.geteMail() + "%");
            sb.append(note.getMessage() + "%");
            sb.append(note.getDateOfCreating() + "\n");
            writer.write(sb.toString());
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    private boolean cheackNote(Note note){
        if(!Pattern.matches(THEME_PATTERN,note.getTheme())){
            return false;
        }
        if(!Pattern.matches(MESSAGE_PATTERN,note.getMessage())){
            return false;
        }
        if(!Pattern.matches(EMAIL_PATTERN,note.geteMail())){
            return false;
        }

        return true;
    }
}
