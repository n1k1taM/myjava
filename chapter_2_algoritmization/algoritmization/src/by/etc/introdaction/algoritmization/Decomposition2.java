package by.etc.introdaction.algoritmization;
/**
Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел
 */
public class Decomposition2 {

    public static void main(String[] args) {
        
        int[]arr={30,75,30,30};
        
        System.out.println(gcd4(arr));
        
    }
    
    public static int gcd4(int[] array){
       
        int minNum;
        int count;
        while(true){
            //присваиваем переменной минимальное число в массиве
            minNum=minNumber(array);
            count=0;
            //все числа должны делиться без остатка на minNum -> count будет=4 ->return
            //если нет, то уменьшаем все числа на minNum, кроме самого число minNum
            //обнуляем count и находим новое минимальное число
             for(int i=0;i<array.length;i++){
                if(array[i]%minNum==0){
                   count++;
                }
             }
             if(count==4){
                return minNum;
             }else{
                   for(int i=0;i<array.length;i++){
                       //неизменным остается только minNum в массиве
                       if(array[i]==minNum){
                       }else{
                             array[i]=array[i]-minNum;
                       }
                   }
             }
        }
    }
    
    //находим минимальное число из массива
    public static int minNumber(int[]array_){
        
       int min=array_[0];
       for(int i=0;i<array_.length;i++){
          if(min>array_[i]){
             min=array_[i];
          }
       }
       return min;
    }
    
}
