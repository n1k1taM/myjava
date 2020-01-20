package by.etc.introdaction.strings;

import java.util.Scanner;

//Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
public class NumberOfOverlap {
    public static void main(String[] args){

        int j=0;
        String str=new String();
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the string: ");
            if(sc.hasNext()){
                str=sc.nextLine();
            }
        }catch (NumberFormatException e){
            System.out.println("You entered invalid characters");
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'){
                j++;
            }
        }
        System.out.println(j);
    }
}
