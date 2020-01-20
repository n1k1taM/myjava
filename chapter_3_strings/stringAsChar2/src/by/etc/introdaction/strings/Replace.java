package by.etc.introdaction.strings;
//Замените в строке все вхождения 'word' на 'letter'.
public class Replace {

    public static void main(String[] args){

        String str="WordArt wordbook wordless wordpad sword";
        char[] array=str.toCharArray();

        char[] newArray=new char[newLength(array)];
        change(array,newArray);
        System.out.println(str);
        System.out.println(newArray);
    }

   static int newLength( char[] arr){
        int count=0;//number of occurrences of 'word'
        for (int i=0;i<arr.length;i++) {
            char c=arr[i];
            if(((c=='w')||(c=='W'))&&((i+1)<arr.length)){
                c=arr[i+1];
                if(((c=='o')||(c=='O'))&&((i+2)<arr.length)){
                    c=arr[i+2];
                    if(((c=='r')||(c=='R'))&&((i+3)<arr.length)){
                        c=arr[i+3];
                        if ((c=='d')||(c=='D')) {
                            count++;
                        }
                    }
                }
            }
        }
        return arr.length-count*4+count*6; //length new array
    }

    static void change(char[] oldArr, char[] newArr){
        int j=0; //index array new_
        for (int i=0;i<oldArr.length;i++) {
            char c=oldArr[i];
            if(((c=='w')||(c=='W'))&&((i+1)<oldArr.length)){
                c=oldArr[i+1];
                if(((c=='o')||(c=='O'))&&((i+2)<oldArr.length)){
                    c=oldArr[i+2];
                    if(((c=='r')||(c=='R'))&&((i+3)<oldArr.length)){
                        c=oldArr[i+3];
                        if ((c=='d')||(c=='D')) {
                            newArr[j]='l';
                            j++;
                            newArr[j]='e';
                            j++;
                            newArr[j]='t';
                            j++;
                            newArr[j]='t';
                            j++;
                            newArr[j]='e';
                            j++;
                            newArr[j]='r';
                            j++;
                            i+=3;
                        }
                    }
                }
            }else {
                newArr[j]=oldArr[i];
                j++;
            }
        }

    }
}
