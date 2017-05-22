package dreamincode.text;

import utilities.IOUtils;

import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class StringReverse {
    public static void main(String[] args) {
        System.out.println("Please enter any number of words to reverse. Empty input exits.");
        ArrayList<String> inputStrings = IOUtils.getInput(System.in);
        inputStrings.forEach(s -> System.out.println(reverse(s)));
//        inputStrings.forEach(StringReverse::foo); //good for many statements/complex logic. Style choice as well.
//        inputStrings.forEach(new Bar()); //if you want to create a new class
    }

    private static String reverse(String string) {
        if (string.isEmpty()) {
            System.out.println("No words were entered. Exiting.");
            return "";
        }
        byte[] bArr = string.getBytes();
        byte[] strRev = new byte[bArr.length];
        for (int i = bArr.length - 1; i >= 0; i--) {
            strRev[bArr.length - 1 - i] = bArr[i];
        }
        return new String(strRev);

    }
//    private static void foo(String s){
//        System.out.println(reverse(s));
//    }
//    private static class Bar implements Consumer<String>{
//
//        @Override
//        public void accept(String s) {
//            System.out.println(reverse(s));
//        }
//    }
}
