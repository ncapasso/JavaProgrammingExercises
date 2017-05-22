package utilities;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ncapasso on 5/17/2017.
 */
public class IOUtils {

    /**
     * Returns the retrieved input from the console.
     * Entering an empty string exits the method.
     *
     * @return stringArrayList  An ArrayList of strings that returns all input retrieved.
     */

    public static void main(String[] args) {

        for (String s : getInput(System.in)) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> getInput(InputStream input) {
        ArrayList<String> retArray = new ArrayList<>();
        int i;
        try {
            StringBuilder str = new StringBuilder();

            while ((i = input.read()) != -1) {
                char c = (char) i;
                if (c == '\n') {
                    if(str.length() <= 1)
                        break;  //checks to see if the input was an empty line.
                    retArray.add(str.toString());
                    str = new StringBuilder();
                    continue;
                }
                str.append(c);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retArray;
    }
}
