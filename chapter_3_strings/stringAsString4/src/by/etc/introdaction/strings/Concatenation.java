package by.etc.introdaction.strings;

//С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
public class Concatenation {
    public static void main(String[] args){
        String str=new String("информатика");
        String result=new String(str.substring(7,8));
        result=result.concat(str.substring(3,5));
        result=result.concat(str.substring(7,8));
        System.out.println(result);

    }
}
