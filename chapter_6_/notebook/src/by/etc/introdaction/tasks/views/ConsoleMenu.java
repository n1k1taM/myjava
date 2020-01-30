package by.etc.introdaction.tasks.views;

import by.etc.introdaction.tasks.actions.ConsoleActions;

import java.util.Scanner;

public class ConsoleMenu {
    private ConsoleActions consoleActions = new ConsoleActions();
    private Scanner scanner;


    public void startConsoleMenu() {
        int choice;
        boolean isStopped = false;
        consoleActions.printMenu();
        while (!isStopped) {
            System.out.println("Please enter the number of the operation. \nYour choice: ");
            choice = consoleActions.makeChoosing();
            isStopped = consoleActions.processingOperation(choice);
        }
    }
}