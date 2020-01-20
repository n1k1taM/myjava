package by.etc.introdaction.classes;

//Туристические путевки. Сформировать набор предложений клиенту
// по выбору туристической путевки различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.)
// для оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней.
// Реализовать выбор и сортировку путевок
public class ExampleVoucher {
    public static void main(String[] args) {

        GeneratorVouchers generator = new GeneratorVouchers();
        generator.generate();
        //sorting by purpose
        TravelVoucher.sorting(generator.vouchers, TravelVoucher.PURPOSE);
        System.out.println("\n");
        //sorting by destination
        TravelVoucher.sorting(generator.vouchers, TravelVoucher.DESTINATION);
        System.out.println("\n");
        //sorting by number of days
        TravelVoucher.sorting(generator.vouchers, TravelVoucher.DAYSOFWEEK);
        System.out.println("\n");
        //selection of voucher
        TravelVoucher.voucherSelection(generator.vouchers);
    }
}
