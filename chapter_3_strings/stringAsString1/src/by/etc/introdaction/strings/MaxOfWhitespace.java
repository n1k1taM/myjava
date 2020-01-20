package by.etc.introdaction.strings;

//Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
public class MaxOfWhitespace {
    public static void main(String[] args){

        String str="Hello world   hello    world";
        System.out.println(str);
        StringBuilder sb = new StringBuilder();
        sb.setLength(str.length());
        for (int j=0;j<sb.length();j++) {
            sb.setCharAt(j,' ');
        }
      for(int i=0;i<str.length();i++){
          if(str.contains(sb.toString())){
              System.out.println(sb.length());
              break;
          }else{
              sb.setLength(sb.length()-1);
          }
      }


    }
}
