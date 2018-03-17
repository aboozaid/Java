package projectClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tamer A.Yassen
 */
public class FileManger implements Serializable {

    public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }

    public ArrayList<Integer> read(String FilePath, int search) {
        // Scanner input = new Scanner(System.in);

        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        ArrayList<Integer> hour = new ArrayList<>();
        if (FilePath.equals("Hours.txt")) {
            while (Reader.hasNext()) {
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");
                if (seprated[0].equals(search)) {
                	hour.add(Integer.parseInt(seprated[1]));
                }
            }
        } 
        return (ArrayList<Integer>) hour;
    }

}
