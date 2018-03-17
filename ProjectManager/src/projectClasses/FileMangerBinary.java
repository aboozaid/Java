package projectClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileMangerBinary implements Serializable {
    // Write in binaryFile
    public boolean write(String FilePath, Object data) {

        try {
            System.out.print("\n Writting in: " + FilePath);
            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));
            writter.writeObject(data);
            System.out.println(" Done :) ");
            writter.close();
            return true;

        } catch (IOException e) {
            System.out.println(" Can't write :( \n" + e);
        }

        return false;
    }
    // Read from binaryFile
    public Object read(String FilePath) {
        Object result = null;
        try {
            System.out.println("Reading From: " + FilePath);
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(FilePath));
            result = reader.readObject();
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileMangerBinary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    // End of FileMangerBinary
}
