package domain;
import java.io.*;

public interface PrintObject {
    default void printInFile(){
        try(FileWriter writer = new FileWriter("note.txt", true))
        {
            writer.write(this.toString() + "\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
