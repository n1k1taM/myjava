package by.etc.introdaction.strings;

import java.util.Scanner;
//Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
//буквы.
public class LettersUpLower {
    public static void main(String[] args){

        int lowerCase=0;
        int upperCase=0;
        char c=' ';
        String str=new String();
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the string");
            str=sc.nextLine();
        }catch (Exception e){
            System.out.println("You entered invalid symbols");
        }
        for (int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                c=str.charAt(i);
                if ((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')) {
                    if(Character.isLowerCase(c)){
                        lowerCase++;
                    }else{
                        upperCase++;
                    }
                }

            }
        }
        System.out.println("Number of lowercase letters = "+lowerCase+"; Number of uppercase letters = "+upperCase);
    }
}
