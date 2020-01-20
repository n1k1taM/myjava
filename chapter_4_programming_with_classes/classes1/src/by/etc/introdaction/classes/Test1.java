package by.etc.introdaction.classes;
//Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
// Добавьте метод, который находит сумму значений этих переменных, и метод, который находит наибольшее
// значение из этих двух переменных.
public class Test1 {
    private int a;
    private int b;
    public static void main(String[] args){
        Test1 t=new Test1();
        t.setA(100);
        t.setB(50);
        t.show();

        int sum=t.sum();
        int more=t.greaterNumber();
        System.out.println("sum = "+sum+" more = "+more);

    }
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void show(){
        System.out.println("a= "+a+" b= "+b);
    }
    public int sum(){
        return a+b;
    }
    public int greaterNumber(){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }
}
