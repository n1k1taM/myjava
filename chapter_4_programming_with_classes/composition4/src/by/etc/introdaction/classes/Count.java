package by.etc.introdaction.classes;

import java.util.*;

final public class Count implements Comparable<Count> {
    private static Set<Long> uniqueSequences = new TreeSet<Long>();
    private long idClient;
    private double balans;
    private String password;
    private long numberOfCount;
    private boolean blockedCount;
    Random random = new Random();
    private Client client;

    Count(Client client, String password, double balans) {

        this.idClient = client.getId();
        this.password = password;
        this.balans = balans;
        this.client = client;

        numberOfCount = Math.abs(random.nextLong());
        while (uniqueSequences.contains(numberOfCount)) {
            numberOfCount = Math.abs(random.nextLong());
        }
        uniqueSequences.add(numberOfCount);
    }

    public long getNumberOfCount() {
        return numberOfCount;
    }

    public boolean isBlockedCount() {
        return blockedCount;
    }

    public void setBlockedCount(boolean blockedCount) {
        this.blockedCount = blockedCount;
    }

    static void searchingCounts(Client client, Count... counts) {
        for (Count count : counts) {
            if (client.getId() == count.idClient) {
                System.out.println("Surname: " + client.getSurname() + " Name: " + client.getName() + " Patronymic: " + client.getPatronymic() +
                        " Number of count: " + count.numberOfCount + " Balans: " + count.balans);
            }
        }
    }

    @Override
    public int compareTo(Count o) {
        return (this.client.getSurname() + this.client.getName() + this.client.getPatronymic()).compareTo(o.client.getSurname() + o.client.getName()
                + o.client.getPatronymic());
    }

    static double totalSumm(Count... counts) {
        double sum = 0;
        for (Count c : counts) {
            sum += c.balans;
        }
        System.out.println("Total summ: " + sum);
        return sum;
    }

    static double positiveTotalSumm(Count... counts) {
        double sum = 0;
        for (Count c : counts) {
            if (c.balans > 0) {
                sum += c.balans;
            }
        }
        System.out.println("Total summ of positive count : " + sum);
        return sum;
    }

    static double negativeTotalSumm(Count... counts) {
        double sum = 0;
        for (Count c : counts) {
            if (c.balans < 0) {
                sum += c.balans;
            }
        }
        System.out.println("Total summ of negative count : " + sum);
        return sum;
    }

    static void sorting(Count... counts) {
        Collections.sort(Arrays.asList(counts));
        for (Count c : counts) {
            System.out.println("Surname: " + c.client.getSurname() + " Name: " + c.client.getName() + " Patronymic: " + c.client.getPatronymic() +
                    " Number of count: " + c.numberOfCount + " Balans: " + c.balans);
        }
    }

    public boolean add(double addSumm) {
        if (!this.isBlockedCount()) {
            System.out.println(this.client.getSurname() + " " + this.client.getName() + " " + this.client.getPatronymic() +
                    " Number of count: " + this.numberOfCount);
            System.out.println("old balance: " + this.balans);
            this.balans += addSumm;
            System.out.println("new balans: " + this.balans);
            return true;
        } else {
            System.out.println("this count is blocked");
        }
        return false;
    }
}
