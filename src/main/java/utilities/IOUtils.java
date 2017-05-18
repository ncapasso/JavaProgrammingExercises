package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
     *
     */

    //look into input streams; make func that takes in one first so it can use files, console, etc.
    public static ArrayList<String> getInput(){
        String input;

        BufferedReader br = null;
        ArrayList<String> stringArrayList = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while((input = br.readLine()) != null && !input.isEmpty()){
                stringArrayList.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //when catch an exception, do something about it. Log and rethrow, just rethrow, etc. Maybe chain exceptions. Take a meaningful action
        }
        finally {
                if(br != null)
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

        }
        return stringArrayList;
    }

    public static String getSingleLineInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
