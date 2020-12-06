import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2prob1 {
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
                int lowRange = Integer.parseInt(arrOfRange[0]);
                int highRange = Integer.parseInt(arrOfRange[1]);
                char key = reader.next().charAt(0);
                String password = reader.next();

                int countofChar = 0;
                for(int i = 0; i < password.length(); i++)
                {
                    if(password.charAt(i) == key)
                    {
                        countofChar++;
                    }
                }
                
                if(lowRange <= countofChar && countofChar <= highRange)
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
