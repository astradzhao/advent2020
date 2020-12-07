import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day5prob1 
{
    public static void main (String[] args) throws IOException
    {
        //reads file
        FileReader fileReader = new FileReader("day5input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();

        Set<Integer> vals = new HashSet<>(lines.size());

        //converts all codes to decimal numbers
        for(String l : lines)
        {
            vals.add(Integer.parseInt(l.replaceAll("[FL]", "0").replaceAll("[BR]", "1"), 2));
        }

        //part 1
        int max = 0;
        for(int val : vals)
        {
            if(val > max)
            {
                max = val;
            }
        }
        System.out.println(max); 

        //part 2
        for(int myID = 0; myID < 1024; myID++)
        {
            if(!vals.contains(myID) && vals.contains(myID + 1) && vals.contains(myID - 1))
            {
                System.out.println(myID);
            }
        }
    }
}
