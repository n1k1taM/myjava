package by.etc.introdaction.algoritmization;

/**
 Даны две последовательности а1<a2...<an и b1<b2...<bn . Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
 */
public class Sort2 {

    public static void main(String[] args) {
       
        int index1=0;
        int index2=0;
        
        //инициализируем две возростающие последовательности
        int[]arr1={1,3,5,7,9,11,13,15,17,19};
        int[]arr2={2,4,6,8,10,12,14,16,18,20};
       
        //цикл с числом итераций =число элементов массива*2
        for(int i=0;i<arr1.length*2;i++){
            //если index1 или index2 достигли arr1.length, то 
            //элементы из соответствующего массива уже вставлены в последовательность
           if((index1<arr1.length)&&(index2<arr1.length)){
              if(arr1[index1]<arr2[index2]){
                   System.out.print(arr1[index1]+"  ");
                   index1++;
                }else if(arr1[index1]==arr2[index2]){
                         System.out.print(arr1[index1]+"  "+arr2[index2]+"  ");
                         index1++;
                         index2++;
                }else{
                      System.out.print(arr2[index2]+"  ");
                      index2++;
                }
           }else if(index1<arr1.length){
                     System.out.print(arr1[index1]+"  ");
                     index1++;
             }else if(index2<arr1.length){
                     System.out.print(arr2[index2]+"  ");
                     index2++;
             }
        }
 
    }
    
}
