package by.etc.introdaction.algoritmization;

/**
Сортировка вставками. Дана последовательность чисел n a1, a2...an . Требуется переставить числа в порядке
возрастания. Делается это следующим образом. Пусть a1,a2...ai - упорядоченная последовательность, т. е.
a1<=a2<=a3 . Берется следующее число ai+1  и вставляется в последовательность так, чтобы новая
последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */
public class Sort5 {
    
  static int mid;
   
    public static void main(String[] args) {

        int buf=0;
        int buf2=0;
        int index=0;
        
        int[]arr={10,5,3,7,23,67,45,4,8};
        
         for(int t=0;t<arr.length;t++){
           System.out.print(arr[t]+"  ");
        }
        
        System.out.println();
        
        //в цикле проходим по каждому элементу
        for(int i=0;i<arr.length-1;i++){
            //если arr[i]>arr[i+1], то ищем индекс куда вставить элемент arr[i+1]
           if(arr[i]>arr[i+1]){
             index=Sort5.binSearch(i+1, arr, 0, i);

               buf=arr[index];
               arr[index]=arr[i+1];
               for(int x= index+1;x<=i+1;x++){
                   buf2=arr[x];
                   arr[x]=buf;
                   buf=buf2;
               }
           }
        }
         for(int t=0;t<arr.length;t++){
           System.out.print(arr[t]+"  ");
        }
        
    }
    
    public static int binSearch(int number,int[]array,int left,int right){
       
        mid=left+(right-left)/2;
        if(array[number]<array[mid]){
            // выполняем mid!=0 чтобы не выйти за пределы массива -> array[mid-1]
            if(mid!=0){
              if(array[number]>=array[mid-1]){
                  //это значит что наше число должно быть между mid и mid-1 индексами
                 return mid;
              }else{
                   return binSearch(number,array,left,mid-1);
              }
            }else{
                 return mid;
            }
        }else if(array[number]>array[mid]){

            if(array[number]<=array[mid+1]){
                //это значит что наше число должно быть между mid и mid-1 индексами
               return mid+1;
            }else{
                 return binSearch(number,array,mid+1,right);
            }
        }else{
             return mid; 
        }
    }
}
