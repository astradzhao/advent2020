import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day4prob2 
{
    public static ArrayList<String> keys = new ArrayList<String>(Arrays.asList("byr","eyr","iyr","hgt","hcl","ecl","pid","cid"));

    public static boolean keyCheck(String[] ckey)
    {
        boolean returnValue = false;
        String keyType = ckey[0];
        ArrayList<Character> numberChars = new ArrayList<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        switch (keyType)
        {
            case "byr": 
                String byrString = ckey[1];
                boolean isitNumber = true;
                for(int i = 0; i < byrString.length(); i++)
                {
                    if(!numberChars.contains(byrString.charAt(i)))
                    {
                        isitNumber = false;
                    }
                }
                if(isitNumber)
                {
                    int byear = Integer.parseInt(byrString);
                    if(byear <= 2002 && byear >= 1920)
                    {
                        returnValue = true;
                    }
                }     
                break;
            
            case "iyr":
                String issString = ckey[1];
                boolean isitNumber2 = true;
                for(int i = 0; i < issString.length(); i++)
                {
                    if(!numberChars.contains(issString.charAt(i)))
                    {
                        isitNumber2 = false;
                    }
                }
                if(isitNumber2)
                {
                    int iyear = Integer.parseInt(issString);
                    if(iyear <= 2020 && iyear >= 2010)
                    {
                        returnValue = true;
                    }
                }     
                break;

            case "eyr":
                String expString = ckey[1];
                boolean isitNumber3 = true;
                for(int i = 0; i < expString.length(); i++)
                {
                    if(!numberChars.contains(expString.charAt(i)))
                    {
                        isitNumber3 = false;
                    }
                }
                if(isitNumber3)
                {
                    int eyear = Integer.parseInt(expString);
                    if(eyear <= 2030 && eyear >= 2020)
                    {
                        returnValue = true;
                    }
                }     
                break;

            case "hgt":
                String height = ckey[1];
                if(height.contains("cm"))
                {
                    int heightVal = Integer.parseInt(height.replace("cm", ""));
                    if(heightVal <= 193 && heightVal >= 150)
                    {
                        returnValue = true;
                    }
                }
                else if (height.contains("in"))
                {
                    int heightVal = Integer.parseInt(height.replace("in", ""));
                    if(heightVal <= 76 && heightVal >= 59)
                    {
                        returnValue = true;
                    }
                }
                break;
            
            case "hcl":
                String hcolor = ckey[1];
                if(hcolor.contains("#") && hcolor.length() == 7)
                {
                    ArrayList<Character> allowed = new ArrayList<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'));
                    returnValue = true;
                    for(int i = 1; i < hcolor.length(); i++)
                    {
                        if(!allowed.contains(hcolor.charAt(i)))
                        {
                            returnValue = false;
                        }
                    }
                }
                break;

            case "ecl":
                String ecolor = ckey[1];
                ArrayList<String> colors = new ArrayList<String>(Arrays.asList("amb","blu","brn","gry","grn","hzl","oth"));
                if(colors.contains(ecolor))
                {
                    returnValue = true;
                }
                break;
            
            case "pid":
                String passID = ckey[1];
                boolean isitNumber4 = true;
                for(int i = 0; i < passID.length(); i++)
                {
                    if(!numberChars.contains(passID.charAt(i)))
                    {
                        isitNumber4 = false;
                    }
                }
                if(isitNumber4)
                {
                    if(passID.length() == 9)
                    {
                        returnValue = true;
                    }
                }
                break;

            case "cid":
                returnValue = true;
                break;
                
        }
        return returnValue;
    }

    public static void main(String[] args)
    {
        //creating the arraylist of keys
        

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
                        String[] ckeyArray = lineArray[i].split(":");
                        if(keyCheck(ckeyArray))
                        {
                            String ckey = ckeyArray[0];
                            currentkeys.remove(ckey);
                        }
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
