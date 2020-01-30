package by.etc.introdaction.tasks.views;

import java.util.Date;
import java.util.Objects;

public class Note implements Comparable<Note> {
    private String theme;
    private String eMail;
    private String message;
    private String dateOfCreating;

    public Note(String theme,String eMail,String message){
        this.theme=theme;
        this.eMail=eMail;
        this.message=message;
        this.dateOfCreating=String.format("%tc",new Date());
    }

    public String getTheme() {
        return theme;
    }

    public String geteMail() {
        return eMail;
    }

    public String getMessage() {
        return message;
    }

    public String getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(String dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null||o.getClass()!=this.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(theme, note.theme) &&
                Objects.equals(eMail, note.eMail) &&
                Objects.equals(message, note.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theme, eMail, message);
    }

    @Override
    public String toString() {
        return "Topic: " + theme + "\n" +
                "e-mail: " + eMail + "\n" +
                "Message: " + message + "\n" +
                "Date of creating: " + dateOfCreating.toString()+ "\n";
    }

    @Override
    public int compareTo(Note o) {
        return this.getDateOfCreating().compareTo(o.getDateOfCreating());
    }
}
