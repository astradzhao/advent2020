import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3prob1 {
    public static void main(String[] args) {
        try {
            File file = new File("day3input.txt");
            Scanner reader = new Scanner(file);

            int treeCount = 0;
            int where = 0;
            while (reader.hasNextLine()) {
                String grid = reader.nextLine();
                
                if (grid.charAt(where % grid.length()) == '#') {
                    treeCount++;
                }
                where += 3;
            }
            System.out.println(treeCount);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
