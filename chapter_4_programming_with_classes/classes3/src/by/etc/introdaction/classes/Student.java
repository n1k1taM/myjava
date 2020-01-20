package by.etc.introdaction.classes;
import java.util.Arrays;

//Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив из пяти элементов).
// Создайте массив из десяти элементов такого типа.
// Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
public class Student {
    private String surnameAndInitials;
    private int numberOfGroup;
    private int[] academicPerformance=new int[5];


    private static String[] names={"Иванов В.М.","Петров И.С.","Ковалев В.М.","Королев К.М.","Давыдов А.М.",
            "Пархоменко О.В.", "Иванова Т.М.","Коваленко И.К.","Василенко А.Л.","Веко П.В."};

    public static void main(String[] args){
        Student[] students=new Student[10];
        Student s;
        for(int i=0;i<students.length;i++){
            s=new Student();
            s.setSurnameAndInitials(names[i]);
            s.setNumberOfGroup(randomGroup());
            s.setAcademicPerformance(randomPerformance());
            students[i]=s;
        }
        for(int i=0;i<students.length;i++){
            boolean goodMarks=true;
            for(int j=0;j<5;j++){
                int mark= students[i].getAcademicPerformance()[j];
                if(mark<8){
                    goodMarks=false;
                }
            }
            if(goodMarks){
                System.out.println(students[i].getSurnameAndInitials()+" Номер группы: "+students[i].getNumberOfGroup()+"  "+ Arrays.toString(students[i].getAcademicPerformance()) );
            }

        }


    }
//method return random mark from 7 to 10
    public static int randomMark(){
        int min=7;
        int max=10-min;
        return (int)(Math.random()*(++max)+min);
    }
    //method return random number of group from 1 to 5
    public static int randomGroup(){
        int max=5;
        return (int)(Math.random()*(max)+1);
    }
    //method return array, which consist from 5 random mark from 7 to 10
    public static int[] randomPerformance(){
        int[] performance=new int[5];
        for(int j=0;j<performance.length;j++){
            performance[j]=randomMark();
        }
        return performance;
    }

    public String getSurnameAndInitials() {
        return surnameAndInitials;
    }

    public void setSurnameAndInitials(String surnameAndInitials) {
        this.surnameAndInitials = surnameAndInitials;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public int[] getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(int[] academicPerformance) {
        this.academicPerformance = academicPerformance;
    }
}
