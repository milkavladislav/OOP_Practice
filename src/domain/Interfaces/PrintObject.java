package domain.Interfaces;
import java.io.*;

public interface PrintObject {
    final  String nameOfFile = "note.txt";

    default void printInFile(){
        try(FileWriter writer = new FileWriter( nameOfFile, true))
        {
            writer.write(this.toString() + "\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
