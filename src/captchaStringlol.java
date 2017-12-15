import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class captchaStringlol {

    public static void main(String[] args) {

        System.out.println("This challenge from advent of code 2017 was to decode a certain \n" +
                            "data string and produce a sum based on certain rules. For example\n" +
                            "if 1122 is encountered, a sum of (1 + 2) is added to the running total.\n" +
                            "If 111222 is encountered a sum of (2 + 4) is added to the running total.\n" +
                            "In other words, if a sequence of matching numbers of the same value is encountered,\n" +
                            "then the (value of the number) x (length of the sequence - 1) is added to\n" +
                            "the total sum. The data set is circular and so the last and first values can \n" +
                            "be a part of a matching sequence.");

        // The name of the file to open.
        String fileName = "dataString";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();

            int[] array = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                array[i] = Integer.parseInt(String.valueOf(line.charAt(i)));
            }

            System.out.println("\nINPUT STRING (with new lines inserted only for readability)");
            int j = 0;
            for (int i = 0 ; i < array.length; i++) {
                if (j > 40) {
                    System.out.print("\n");
                    j = 0;
                }
                System.out.print(array[i] + " ");
                j++;
            }

            int sum = 0;
            int currentDigit = 0;
            boolean inASeq = false;
            for (int i = 0; i < array.length; i++) {
                currentDigit = array[i];
                if (i < array.length - 1 && currentDigit == array[i + 1]) {
                    sum += currentDigit;
                }
                else if (i >= array.length - 1) {
                    if (currentDigit == array[0]) {
                        sum += currentDigit;
                    }
                }
            }
            System.out.println("\n\nResult = " + sum);

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
