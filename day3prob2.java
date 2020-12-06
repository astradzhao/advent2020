import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day3prob2 {

    public static long getTrees(String[] grid, int right, int down)
    {
        int x = 0;
        int y = 0;
        int w = grid[0].length();
        int h = grid.length;
        char tree = '#';
        long count = 0;
        while (true) {
            x += right;
            y += down;
            if (x >= w) {
                x -= w;
            }
            if (y >= h) {
                break;
            }
            if (grid[y].charAt(x) == tree) {
                count++;
            }
        }
        return count;
    }

    // puts the file into an array/grid
    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public static void main (String[] args) throws IOException
    {
        String[] grid = readLines("day3input.txt");
        
        long a = getTrees(grid, 1, 1);
        long b = getTrees(grid, 3, 1);
        long c = getTrees(grid, 5, 1);
        long d = getTrees(grid, 7, 1);
        long e = getTrees(grid, 1, 2);

        System.out.println(a * b * c * d * e);
    }
}
