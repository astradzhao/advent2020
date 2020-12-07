import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day6prob2 
{
    public static int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }

        return count;
    }
    public static void main (String[] args) throws IOException
    {
        //read file and put it into respective groupings
        FileReader fileReader = new FileReader("day6input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> current = new ArrayList<String>();
        String line = null;
        int sum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if(line.isEmpty())
            {
                int size = current.size();
                String groupStr = "";
                int count = 0;
                for(String person : current)
                {
                    groupStr += person;
                }
                for(char alphabet = 'a'; alphabet <= 'z'; alphabet++)
                {
                    if (countChar(groupStr, alphabet) == size)
                    {
                        count++;
                    }
                }
                System.out.println(count);
                sum += count;
                current.clear();
            }
            else
            {
                current.add(line);
            }           
        }

        System.out.println(sum);
        bufferedReader.close();
    }
}
