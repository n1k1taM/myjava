package by.etc.introdaction.basicsjfoop;
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
import java.io.IOException;
import java.util.Scanner;

public class Payment {

    private String name;
    private double cost;
    private Product[] products;

    public Payment(String name) {
        this.name = name;
    }

    public void setPayment() throws IOException {
        this.cost = 0;
        Scanner br = new Scanner(System.in);
            System.out.print("Enter number of products, which you want to buy: ");
            try {
                int number = br.nextInt();
                products = new Product[number];
                for (int i = 0; i < number; i++) {
                    System.out.println("Product " + (i + 1) + ": ");
                    System.out.print("Name: ");
                    String productName = br.next();
                    System.out.print("Price: ");
                    double productCost = br.nextDouble();
                    products[i] = new Product(productName, productCost);
                    this.cost = this.cost + products[i].getCostOfProduct();
                }
            } catch (NumberFormatException e) {
                System.out.println("wrong format");
            } catch (NegativeArraySizeException e) {
                System.out.println("Array can't has size equals zero");
            } catch (NullPointerException e) {
                System.out.println();
                System.out.println("Array isn't created");
            }

    }


    private class Product {
        private  String nameOfProduct;
        private  double costOfProduct;

        Product(String nameOfProduct, double costOfProduct) {
            this.nameOfProduct = nameOfProduct;
            this.costOfProduct = costOfProduct;
        }

        public String getNameOfProduct() {
            return nameOfProduct;
        }

        public double getCostOfProduct() {
            return costOfProduct;
        }
    }

    public void showListProducts(){
        if(products.length>0){
            System.out.println(this.name);
            System.out.println("======================================");
            for(int i=0;i<products.length;i++){
                System.out.println(i+1+" product: "+products[i].getNameOfProduct()+", cost: "+products[i].getCostOfProduct());
            }
            System.out.println("======================================");
            System.out.println("Total cost: "+this.cost);
            System.out.println();
        }else{
            System.out.println("List of products isn't formed");
            return;
        }


    }
}
