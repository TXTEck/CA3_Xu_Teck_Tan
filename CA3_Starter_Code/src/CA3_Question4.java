import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Xu Teck Tan
 *  Class Group: SD2b
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        Stack<String> tags = new Stack<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tag = line.split(" ");

            for(String t: tag) {
                if (t.startsWith("<")) {
                    if (t.startsWith("</")) {
                        if (tags.isEmpty()) {
                            return false;
                        }
                        String openingTag = tags.pop();
                        if (!openingTag.equals(t.substring(2, t.length() - 1))) {
                            return false;
                        }
                    } else {
                        tags.push(t.substring(1, t.length() - 1));
                    }
                }
            }
        }
        return tags.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"CA3_Starter_Code/tags_valid.txt", "CA3_Starter_Code/tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
