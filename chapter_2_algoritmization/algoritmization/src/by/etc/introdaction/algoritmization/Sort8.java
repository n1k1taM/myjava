package by.etc.introdaction.algoritmization;

/**
 * Даны дроби p1/q1, p2/q2,... ( pi и qi - натуральные). Составить программу,
 * которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке
 * возрастания
 */
public class Sort8 {

    public static void main(String[] args) {

        int max = 0;
        int copyMax=0;
        int n=1;
        double buf=0;
        boolean bool = false;
        int[] arr1 = {1, 3, 2, 6, 9};// числители
        int[] arr2 = {2, 4, 5, 7, 10};// знаменатели

        //ищем наибольший знаменатель
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
            }
        }
        copyMax=max;
        // если макс. знам. делится на все без остатка -> то знаманатель найден
        while (bool == false) {
            max*=n;
            for (int i = 0; i < arr2.length; i++) {
                //если хотябы один знаменатель не делится без остатка на max, то
                //bool=false - чтобы снова войти в цикл и выходим из цикла for
                // увеличиваем n и снова выполняется while
                if (max % arr2[i] == 0) {
                    bool = true;
                } else {
                    bool=false;
                    break;
                }
            }
            if(bool==false){
               max=copyMax;
            }
            n++;
        }
       //если bool=false то max не является общим делителем
       System.out.print("Наименьший делитель равен:"+max+"\n");
       
       //умножаем числители
       for(int i=0;i<arr1.length;i++){
          arr1[i]=(max/arr2[i])*arr1[i];
       }
       //сортируем по возростанию
         for (int i = 1; i < arr1.length; i++) {
            for (int j = i; j >= 1; j--) {
                //еслт текущий элемент меньше предыдущего, то перестановка
                if (arr1[j] < arr1[j - 1]){
                    buf=arr1[j];
                    arr1[j]=arr1[j-1];
                    arr1[j-1]=(int)buf;
                } else{
                    break;
                }
            }
        }
       
        for(int i=0;i<arr1.length;i++){
          System.out.print(arr1[i]+"/"+max+"  ");
       }
    }
}
