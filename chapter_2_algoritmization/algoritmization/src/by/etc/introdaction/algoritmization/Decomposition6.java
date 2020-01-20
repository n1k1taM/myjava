package by.etc.introdaction.algoritmization;

/**
Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми
 */
public class Decomposition6 {

    static int minNum;
    static int count;
    
    public static void main(String[] args) {
        
         int[]arr={7,5,9};
        
        System.out.println(gcd3(arr));
      
    }
    
    public static String gcd3(int[] array){
        
        if(array[0]==0||array[1]==0||array[2]==0){
           return "Ноль не является натуральным числом";
        }else if(array[0]==1||array[1]==1||array[2]==1){
              return "Числа являются взаимно простыми";
        }
        while(true){
            //присваиваем переменной минимальное число в массиве
            minNum=minNumber(array);
            count=0;
            //все числа должны делиться без остатка на minNum -> count будет=3 ->НОД найден
            //если нет, то уменьшаем все числа на minNum, кроме самого число minNum
            //обнуляем count и находим новое минимальное число
             for(int i=0;i<array.length;i++){
                if(array[i]%minNum==0){
                   count++;
                }
             }
             if(count==3){
                 if(minNum==1){
                     return "Числа являются взаимно простыми";
                 }else{
                       return "НОД:"+minNum;
                 }
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
