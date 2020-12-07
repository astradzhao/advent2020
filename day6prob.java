import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day6prob 
{
    public static long countUniqueCharacters(String input) {
        return input.chars().distinct().count();
    }

    public static void main (String[] args) throws IOException
    {
        //read file and put it into respective groupings
        FileReader fileReader = new FileReader("day6input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> answers = new ArrayList<String>();
        String cAns = "";
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if(line.isEmpty())
            {
                answers.add(cAns);
                cAns = "";
            }
            else
            {
                cAns = cAns + line;
            }           
        }
        bufferedReader.close();

        long sum = 0;
        for(String group : answers)
        {
            sum += countUniqueCharacters(group);
        }

        System.out.println(sum);
    }
}
