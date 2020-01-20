package by.etc.introdaction.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

//Создайте класс Train, содержащий поля: название пункта назначения,
// номер поезда, время отправления. Создайте данные в массив из пяти элементов типа Train,
// добавьте возможность сортировки элементов массива по номерам поездов.
// Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
// Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми
// пунктами назначения должны быть упорядочены по времени отправления.
public class Train implements Comparable<Train>, ActionListener {
    String piontDestination;
    int numberOfTrain;
    Date timeDeparture;

    static int baseDate = Integer.MAX_VALUE;
    private static String[] destination = {"Minsk", "London", "Moscow", "Minsk", "Kiev"};
    static Train[] array = new Train[5];
    JFrame frame;
    JPanel panel;
    JPanel panel1;
    JButton button1;
    JButton button2;
    JButton button3;
    JTextArea textArea1;
    JTextArea textArea2;

    public static void main(String[] args) {
//creating and filling array
        int twoHour = 7200000;
        for (int i = 0; i < 5; i++) {
            Train train = new Train();
            train.numberOfTrain = randomNumber();
            train.piontDestination = destination[i];
            train.timeDeparture = new Date(baseDate + twoHour);
            twoHour += 7200000;
            array[i] = train;
        }
        Train train = new Train();
        train.init();
    }

    //method for generating random number of train
    public static int randomNumber() {
        int max = 100;
        return (int) (Math.random() * (max) + 1);
    }

    //method for comparing on number of train
    @Override
    public int compareTo(Train o) {
        return this.numberOfTrain - o.numberOfTrain;
    }

    //method for comparing on pointDestination and timeDeparture
    class PointDestination implements Comparator<Train> {

        @Override
        public int compare(Train o1, Train o2) {
            if ((o1.piontDestination.compareToIgnoreCase(o2.piontDestination)) == 0) {
                return (int) (o1.timeDeparture.getTime() - o2.timeDeparture.getTime());
            }
            return o1.piontDestination.compareToIgnoreCase(o2.piontDestination);
        }
    }

    //creating GUI
    public void init() {
        frame = new JFrame("Train");
        button1 = new JButton("Сортировка по номеру поезда");
        button2 = new JButton("Сортировка по пункту назначения");
        button3 = new JButton("Проверить поезд");
        textArea1 = new JTextArea(" ");
        for (Train t : array) {
            textArea1.append(t.numberOfTrain + " " + t.piontDestination + " " + t.timeDeparture + "\n");
        }
        JLabel label1 = new JLabel("Введите № поезда");
        textArea2 = new JTextArea("   ");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this::actionPerformed);

        panel = new JPanel();
        panel.add(label1);
        panel.add(textArea2);
        panel.add(button3);

        panel1 = new JPanel();
        panel1.add(button1);
        panel1.add(button2);

        frame.getContentPane().add(BorderLayout.CENTER, panel1);
        frame.getContentPane().add(BorderLayout.NORTH, textArea1);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setVisible(true);
    }

    //checking which button was pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton rb = (JButton) e.getSource();

        if ((rb.getText()).equals("Сортировка по номеру поезда")) {
            Collections.sort(Arrays.asList(array));
            textArea1.setText(" ");
            for (Train t : array) {
                textArea1.append(t.numberOfTrain + " " + t.piontDestination + " " + t.timeDeparture + "\n");
            }

        } else if ((rb.getText()).equals("Сортировка по пункту назначения")) {
            Comparator destination = new PointDestination();
            Collections.sort(Arrays.asList(array), destination);
            textArea1.setText(" ");
            for (Train t : array) {
                textArea1.append(t.numberOfTrain + " " + t.piontDestination + " " + t.timeDeparture + "\n");
            }
        } else if ((rb.getText()).equals("Проверить поезд")) {
            String i = textArea2.getText().trim();
            for (Train t : array) {
                if (i.equals((Integer.toString(t.numberOfTrain)).trim())) {
                    textArea1.setText(" ");
                    textArea1.setText(t.numberOfTrain + " " + t.piontDestination + " " + t.timeDeparture);

                }
            }
        }
    }
}
