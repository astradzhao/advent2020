import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class day1prob1 {
    public static void main(String[] args) {
        try {
            File file = new File("day1input1.txt");
            Scanner reader = new Scanner(file);
            List<Integer> data = new ArrayList<>();
            while (reader.hasNextInt()) {
                int number = reader.nextInt();
                data.add(number);
            }
            int a = 0;
            int b = 0;
            int c = 0;
            for (int i = 0; i < data.size(); i++) {
                for (int j = i + 1; j < data.size(); j++) {
                    for (int k = j + 1; k < data.size(); k++)
                    {
                        if (data.get(i) + data.get(j) + data.get(k) == 2020) {
                            a = data.get(i);
                            b = data.get(j);
                            c = data.get(k);
                            break;
                        }
                    }
                }
            }
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

}
