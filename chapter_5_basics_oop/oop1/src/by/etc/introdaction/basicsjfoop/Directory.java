package by.etc.introdaction.basicsjfoop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Directory {
   private String folder;
   private Path pathDirectory;
   private Matcher matcher;
   private Pattern pattern=Pattern.compile("([a-zA-Z])((:)((\\)([^\\/:*?<>|]*))*))");

    public Directory(String folder) throws InvalidDirectoryException, IOException {
        matcher=pattern.matcher(folder);
        if(matcher.find()){
            this.folder=folder;
            Path path = Paths.get(this.folder);
            if(Files.exists(path)){
                System.out.println("Directory already exists");
            }else{
                this.pathDirectory=Files.createDirectory(path);
            }

        }else {
            throw new InvalidDirectoryException("Invalid path");
        }
    }

    public String getFolder() {
        return folder;
    }
}
