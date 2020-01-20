package by.etc.introdaction.classes;

/*
Счета. Клиент может иметь несколько счетов в банке.
 Учитывать возможность блокировки/разблокировки счета. Реализовать поиск и сортировку счетов.
 Вычисление общей суммы по счетам. Вычисление суммы по всем счетам,
 имеющим положительный и отрицательный балансы отдельно
 */
public class ExampleCount {
    public static void main(String[] args) {

        try {
            Client client1 = new Client("John", "Jonson", "Jonatan", "123456789");
            Client client2 = new Client("John", "Jonson", "Jonatan", "123456788");
            Client client3 = new Client("Mary", "Jonson", "Jonatan", "124556789");
            Client client4 = new Client("Piter", "Jonson", "Jonatan", "789456788");

            Count count1 = new Count(client1, "password123", 100);
            Count count2 = new Count(client2, "password123", 100);
            Count count3 = new Count(client3, "qwerty123", 50);
            Count count4 = new Count(client4, "Pas2806word", 360);
            Count count5 = new Count(client4, "pasword", -230);
            Count[] counts = new Count[]{count1, count2, count3, count4, count5};
            System.out.println("Example");

            //searching
            System.out.println("Searching by client");
            Count.searchingCounts(client4, counts);
            System.out.println();
            //sorting
            System.out.println("Sorting by client");
            Count.sorting(counts);
            System.out.println();
            //total summ

            Count.totalSumm(counts);
            System.out.println();
            Count.positiveTotalSumm(counts);
            System.out.println();
            Count.negativeTotalSumm(counts);
            System.out.println();
            //add balans if isn't blocked
            count5.add(550);
        } catch (Client.PassportException ps) {
            System.out.println(ps.getMessage());
        }


    }
}
