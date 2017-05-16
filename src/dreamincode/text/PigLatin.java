package dreamincode.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class PigLatin {
    public static void main(String[] args) {
        PigLatin pi = new PigLatin();
        pi.pigLatinize(pi.getInput());
    }

    private ArrayList<String> getInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("Enter any number of sentences. Empty input exits.");
        String input;
        try {
            while((input = br.readLine()) != null && !input.isEmpty()){
                stringArrayList.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArrayList;
    }

    private void pigLatinize(ArrayList<String> strings){
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
