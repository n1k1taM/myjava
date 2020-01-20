package by.etc.introdaction.algoritmization;
/**
Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
которых число 5 встречается три и более раз.
 */
public class ArrayArray11 {
    public static void main(String[] args) {
        
         int t=0;
          
         //создаем и инициализируем двумерный массив и выводим его на консоль
        int[][] arr=new int[10][20];
        for(int i=0;i<10;i++){
           for(int j=0;j<20;j++){
              arr[i][j]=(int)(Math.random()*16);
              System.out.print(arr[i][j]+"     ");
           }
           System.out.println();
        }
       System.out.println("**********************************");
       
       for(int i=0;i<10;i++){
          for(int j=0;j<20;j++){
              //если элемент в строке = 5, то инкрементируем t
             if(arr[i][j]==5){
                t++;
             }
          }
          // если t >= 3, то выводим номер текущей строки
          if(t>=3){
             System.out.print(" №"+i);
          }
          //обнуляем t (для каждой строки подсчет начинается с 0)
          t=0;
       }
    }
}
