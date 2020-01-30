package by.etc.introdaction.tasks.actions;

import by.etc.introdaction.tasks.views.Note;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleActions {
    NotebookActions notebookActions = new NotebookActions();
    private Scanner scanner = new Scanner(System.in);
    private final String[] fieldsNote=new String[]{"Enter the theme: ","Enter the email:  ","Enter the message: "};

    public void printMenu() {
        System.out.print("Enter one of next number for choosing action: \n" +
                "1 - find note(s); \n" +
                "2 - add note; \n" +
                "3 - close application; \n");
    }

    public void printSearchMenu() {
        System.out.print("Enter one of next number for choosing action: \n" +
                "1 - searching by theme; \n" +
                "2 - searching by email; \n" +
                "3 - searching by word(s) in message; \n");
    }

    public int makeChoosing() {
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 3 || choice < 1) {
                System.out.println("There is no such option. Repeat entry.\n");
                printMenu();
            } else {
                return choice;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.\n");
           // printMenu();
        }
        return -1;
    }

    public boolean processingOperation(int choice) {

        switch (choice) {
            case 1:
                System.out.println("You have chosen finding the note(s)");
                printSearchMenu();
                typeOfSearching(makeChoosing());
                break;
            case 2:
                System.out.println("You have chosen adding the note(s)");
                Note note=enterFieldsNote();
                if(notebookActions.addNote(note)){
                    System.out.println("Note is added! \n");
                }else{
                    System.out.println("Note isn't added! \n");
                }
                break;
            case 3:
                System.out.println("The work is completed.\nGoodbye");
                return true;
        }
        return false;
    }

    private void typeOfSearching(int numberOfType) {
        ArrayList<Note> notes=new ArrayList<>();
        switch (numberOfType){
            case 1:
                System.out.println("Enter the theme: \n");
                while (!scanner.hasNextLine()){
                    scanner.next();
                }
                String enteredTheme=scanner.nextLine();
               notes= notebookActions.searchByTheme(enteredTheme);
               printSelectedNotes(notes);
               break;
            case 2:
                System.out.println("Enter the email: \n");
                while (!scanner.hasNextLine()){
                    scanner.next();
                }
                String enteredEmail=scanner.nextLine();
                notes= notebookActions.searchByEmail(enteredEmail);
                printSelectedNotes(notes);
                break;
            case 3:
                System.out.println("Enter the word: \n");
                while (!scanner.hasNextLine()){
                    scanner.next();
                }
                String enteredWord=scanner.nextLine();
                notes= notebookActions.searchByWord(enteredWord);
                printSelectedNotes(notes);
                break;
        }
    }
    private void printSelectedNotes(ArrayList<Note>notes){
        for (Note note:notes) {
            System.out.println(note);
        }
    }

    private Note enterFieldsNote(){
        String theme="";
        String email="";
        String message="";
        for (int i=0;i<fieldsNote.length;i++) {
           if(i==0){
               theme=getEnteredText(fieldsNote[i]);
           }else if(i==1){
               email=getEnteredText(fieldsNote[i]);
           }else{
               message=getEnteredText(fieldsNote[i]);
           }
        }

        return new Note(theme,email,message);
    }

    private String getEnteredText(String query){
        System.out.println(query);
        while (scanner.hasNextLine()==false){
            scanner.next();
        }
        String enteredText=scanner.nextLine();
        return enteredText;
    }
}
