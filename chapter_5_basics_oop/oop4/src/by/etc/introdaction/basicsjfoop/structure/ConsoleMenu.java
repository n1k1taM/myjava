package by.etc.introdaction.basicsjfoop.structure;

import by.etc.introdaction.basicsjfoop.action.ConsoleMenuAction;

public class ConsoleMenu {
    ConsoleMenuAction consoleMenuAction = new ConsoleMenuAction();

    public void startMenu(Cave cave) {
        int choice;
        boolean isStopped = false;
        consoleMenuAction.printMenu();
        while (!isStopped) {
            choice = consoleMenuAction.selection();
            isStopped = consoleMenuAction.action(choice, cave);
        }
    }
}
