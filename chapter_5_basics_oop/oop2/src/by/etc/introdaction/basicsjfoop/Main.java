package by.etc.introdaction.basicsjfoop;
/*Создать класс Payment с внутренним классом,
с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
	// write your code here
        try {
            Payment payment1=new Payment("Purchase number 1");
            payment1.setPayment();
            payment1.showListProducts();

            Payment payment2=new Payment("Purchase number 2");
            payment2.setPayment();
            payment2.showListProducts();
        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }

    }
}
