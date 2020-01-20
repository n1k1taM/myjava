package by.etc.introdaction.algoritmization;

/**
На плоскости заданы своими координатами n точек. Написать метод(методы),
* определяющие, между какими из пар точек самое большое расстояние. 
* Указание. Координаты точек занести в массив.
 */
public class Decomposition4 {

    public static void main(String[] args) {
       
        double[] x={5, 5, 7.5, 4.5, 4};
        double[] y={5, 10, 7,7, 7, 8};
        
        distance(x,y);
    }
    
    public static void distance(double[] x_, double[]y_){
        double x1;
        double y1;
        double max=0;
        int n;//индекс первой точки
        int m;// индекс второй точки
        int count=1;//может быть несколько точес с максимальным расстоянием
        double[] arr;
        // перебор всех возможныч сочетаний пар точек
       for(int i=0;i<x_.length-1;i++){
          for(int j=i+1;j<x_.length;j++){
              //разность расстояний по осям
             x1=Math.abs(x_[i]-x_[j]);
             y1=Math.abs(y_[i]-y_[j]);
             
             if(max<hypotenuse(x1,y1)){
                max=hypotenuse(x1,y1);
                count=1;
                //если точек с одинаковым расстоянием >2
             }else if(max==hypotenuse(x1,y1)) {
                  count++;
             }
          }
       }
       //еще раз перебираем все варианты
       //если расстояние совпадает с max, то выводим точки на консоль
       
         for(int i=0;i<x_.length-1;i++){
          for(int j=i+1;j<x_.length;j++){
             x1=Math.abs(x_[i]-x_[j]);
             y1=Math.abs(y_[i]-y_[j]);
             
             if(max==hypotenuse(x1,y1)){
               System.out.println("Максимальное расстояние="+max+" между точкой с x="+x_[i]+" y="+y_[i]+" и точкой с x="+x_[j]+" y="+y_[j]);
               
             }
          }
       }
    }
    //расстоянием между двумя точками является гтпотенуза, где катетами являются
    //модуль разницы значений координат по x и по y
    public static double hypotenuse(double a, double b){
       double c=a*a+b*b;
       c=Math.sqrt(c);
       return c;
    }
}
