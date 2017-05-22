package dreamincode.text;

import utilities.IOUtils;

import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class PigLatin {
    public static void main(String[] args) {
        System.out.println("Please enter a phrase to pig-latinize. Empty input exits.");
        pigLatinize(IOUtils.getInput(System.in));
    }

    private static void pigLatinize(ArrayList<String> strings){
        for(String s : strings){
            String[] sArr = s.split(" ");
            String temp;
            for(int i = 0; i<sArr.length; i++){
                temp = sArr[i];
                System.out.print(temp.substring(1) + "-" + temp.charAt(0) + "ay" + " ");
            }
            System.out.println();
        }
    }
}
