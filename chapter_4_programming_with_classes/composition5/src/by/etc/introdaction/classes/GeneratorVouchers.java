package by.etc.introdaction.classes;

public class GeneratorVouchers {
    TravelVoucher[] vouchers = new TravelVoucher[100];
    String[] purposes = new String[]{"Лечение", "Отдых", "Экскурсия", "Шопинг", "Круиз"};
    String[] destinations = new String[]{"Турция", "Греция", "Грузия", "Египет", "Болгария", "Англия", "Италия", "Франция", "Германия", "Голландия"};
    String[] foodInclude = new String[]{"Да", "Нет"};
    String[] transport = new String[]{"Поезд", "Автобус", "Самолет"};

    public void generate() {
        for (int i = 0; i < vouchers.length; i++) {
            int max = 4;
            int a = (int) (Math.random() * ++max);

            max = 9;
            int b = (int) (Math.random() * ++max);

            int c = (int) (Math.random() * 2);

            max = 2;
            int d = (int) (Math.random() * ++max);

            int min = 6;
            max = 18;
            max = max - min;
            int e = (int) (Math.random() * ++max) + min;

            double cost = 100 * e;
            vouchers[i] = new TravelVoucher(purposes[a], destinations[b], e, cost, foodInclude[c], transport[d]);
        }
    }
}
