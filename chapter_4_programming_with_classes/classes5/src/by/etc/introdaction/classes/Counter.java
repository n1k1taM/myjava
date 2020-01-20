package by.etc.introdaction.classes;

import java.util.Scanner;

//Опишите класс, реализующий десятичный счетчик,
// который может увеличивать или уменьшать свое значение на единицу в заданном диапазоне.
// Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
// Счетчик имеет методы увеличения и уменьшения состояния,
// и метод позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
public class Counter {
    private int currentValue;
    private int minValue;
    private int maxValue;

    Counter(int currentValue, int minValue, int maxValue) {
        this.currentValue = currentValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    Counter() {
        this.currentValue = 10;
        this.minValue = 5;
        this.maxValue = 15;
    }

    public int increseCurrentValue() {
        if (currentValue < maxValue) {
            return ++currentValue;
        } else {
            System.out.println("Текущее значение достигло максимального");
        }
        return currentValue;
    }

    public int decreseCurrentValue() {
        if (currentValue > minValue) {
            return --currentValue;
        } else {
            System.out.println("Текущее значение достигло минимального");
        }
        return currentValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

}
