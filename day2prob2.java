import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2prob2 {
    public static void main(String[] args)
    {
        try
        {
            File file = new File("day2input.txt");
            Scanner reader = new Scanner(file);

            int answer = 0;
            while(reader.hasNextLine())
            {
                String rangeStr = reader.next();
                String[] arrOfRange = rangeStr.split("-");
                int lowCheck = Integer.parseInt(arrOfRange[0]);
                int highCheck = Integer.parseInt(arrOfRange[1]);
                char key = reader.next().charAt(0);
                String password = reader.next();

                int count = 0;
                if(password.charAt(lowCheck-1) == key)
                {
                    count++;
                }
                if(password.charAt(highCheck-1) == key)
                {
                    count++;
                }
                if(count == 1)
                {
                    answer++;
                }
            }
            System.out.println(answer);
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }
}
