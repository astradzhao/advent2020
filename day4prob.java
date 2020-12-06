import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day4prob 
{
    public static ArrayList<String> keys = new ArrayList<String>(Arrays.asList("byr","eyr","iyr","hgt","hcl","ecl","pid","cid"));


    public static void main(String[] args)
    {

        //algorithm to find number of valid passports
        try {
            File file = new File("day4input.txt");
            Scanner reader = new Scanner(file);
            ArrayList<String> currentkeys = keys;
            int totalValid = 0;
            while(reader.hasNextLine())
            {
                String currentLine = reader.nextLine();
                if(currentLine.isEmpty())
                {
                    if(currentkeys.size() == 0)
                    {
                        totalValid++;
                    }
                    else if(currentkeys.size() == 1 && currentkeys.contains("cid"))
                    {
                        totalValid++;
                    }
                    currentkeys = new ArrayList<String>(Arrays.asList("byr","eyr","iyr","hgt","hcl","ecl","pid","cid"));
                }
                else
                {
                    String[] lineArray = currentLine.split(" ");
                    for(int i = 0; i < lineArray.length; i++)
                    {
                        String ckey = lineArray[i].split(":")[0];
                        currentkeys.remove(ckey);
                    }
                }
            }
            reader.close();

            System.out.println(totalValid);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    
}
