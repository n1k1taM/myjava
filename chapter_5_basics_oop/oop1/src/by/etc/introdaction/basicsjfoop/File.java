package by.etc.introdaction.basicsjfoop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File {
    private Directory directory;
    private String nameFile;
    private String fileExtention;
    private Path path;
    private Matcher matcher;
    private Pattern pattern = Pattern.compile("(\\.)(([a-z]){1,9})$");


    public File(Directory directory, String nameFile, String fileExtension) throws IOException, InvalidFileExtentionException {
        this.directory = directory;
        this.nameFile = nameFile;
        matcher = pattern.matcher(fileExtension);
        if (matcher.find()) {
            this.fileExtention = fileExtension;
            String fullPath = this.directory.getFolder() + "\\" + nameFile + fileExtension;
            path = Paths.get(fullPath);
        } else {
            throw new InvalidFileExtentionException("invalid file extension");
        }

    }

    public String getNameFile() {
        return nameFile;
    }

    public Path getPath() {
        return path;
    }

    public String getFileExtention() {
        return fileExtention;
    }

    @Override
    public String toString() {
        return "File{" +
                "path=" + path +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return path.equals(file.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    public Path createFile() throws IOException {
        if (Files.exists(path)) {
            System.out.println("File already exists");
        } else {
            this.path = Files.createFile(path);
        }
        return this.path;
    }

    public boolean rename(String newName) {
        if (Files.exists(this.path)) {
            java.io.File old = new java.io.File(this.path.toString());
            String track = old.getParent();
            java.io.File newFile = new java.io.File(track + "\\" + newName + this.fileExtention);
            this.path = Paths.get(newFile.toString());
            return old.renameTo(newFile);
        } else {

            return false;
        }
    }

    public void showContent() {
        if (Files.exists(this.path)) {
            try (FileInputStream fis = new FileInputStream(this.path.toString())) {
                int i = -1;
                while ((i = fis.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exists");
        }
    }

    public boolean add(String text) {
        if (Files.exists(this.path)) {
            try (FileOutputStream fos = new FileOutputStream(this.path.toString(), true)) {
                byte[] buf = text.getBytes();
                fos.write(buf, 0, buf.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
        return false;
    }

    public boolean deliteFile() {
        if (Files.exists(this.path)) {
            try {
                return Files.deleteIfExists(this.path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exists");
            return false;
        }
        return false;
    }
}
