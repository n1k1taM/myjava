package by.etc.introdaction.tasks.person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserPerson extends Person {
    public UserPerson(String name, String surname, String patronymic, String eMail,String password) {
        super(name, surname, patronymic, eMail,password);

    }

    @Override
   public boolean addPerson(){
        Path path= Paths.get("d:\\ListOfPerson.txt");
        try {
            if(!Files.exists(path)){
               path = Files.createFile(path);

            }
        }catch (IOException ioex){
            System.out.println(ioex.getMessage());
        }

       try(FileWriter fos=new FileWriter(path.toString(),true)){
           StringBuilder sb=new StringBuilder("User ");
           sb.append(this.getName()+" ");
           sb.append(this.getSurname()+" ");
           sb.append(this.getPatronymic()+" ");
           sb.append(this.geteMail()+" ");
           sb.append(this.getPassword().hashCode());
           sb.append("\n");
           fos.write(sb.toString());
           fos.flush();
        }catch(Exception ex){
           System.out.println(ex.getMessage());
        }


        return false;
    }

}
