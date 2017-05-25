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

//        for (String s : getInput(System.in)) {
//            System.out.println(s);
//        }
        try {
            File file = writeToTempFile(System.in);
            System.out.println(file.exists());
            System.out.println(file.getName());
        } catch (IOException e) {
            e.printStackTrace();
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
                    if (str.length() <= 1)
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

    public static String getInputSingleLine(InputStream input) {
        int i;
        try {
            StringBuilder str = new StringBuilder();

            while ((i = input.read()) != -1) {
                char c = (char) i;
                if (c == '\n') {
                    return str.toString();
                }
                str.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean writeToFile(InputStream inputStream, String filename) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024]; //1 meg buffer
            int read;

            while ((read = inputStream.read(buffer, 0, buffer.length)) != -1) {
                byteArrayOutputStream.write(buffer, 0, read);
            }
            try (OutputStream outputStream = new FileOutputStream(filename)) {
                byteArrayOutputStream.writeTo(outputStream);
            }
            return true; //if write was successful

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static File writeToTempFile(InputStream inputStream) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File file;
        try (OutputStream outputStream = new FileOutputStream(file = File.createTempFile("temp", ".tmp"))) {
            byteArrayOutputStream.write(inputStream.read());
            byteArrayOutputStream.writeTo(outputStream);
        }
        return file;
    }
}
