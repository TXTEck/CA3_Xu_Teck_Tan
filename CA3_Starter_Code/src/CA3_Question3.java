import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 *  Name: Xu Teck Tan
 *  Class Group: SD2b
 */

public class CA3_Question3 {

    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Map<String, List<Integer>> identifierMap = new HashMap<>();

        try (Scanner fileScanner = new Scanner(file)) {
            int lineNumber = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineNumber++;
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("[^A-Za-z0-9_]+");

                while (lineScanner.hasNext()) {
                    String identifier = lineScanner.next();
                    if (!identifierMap.containsKey(identifier)) {
                        identifierMap.put(identifier, new ArrayList<>());
                    }
                    identifierMap.get(identifier).add(lineNumber);
                }
                lineScanner.close();
            }
        }

        // Print the result
        for (Map.Entry<String, List<Integer>> entry : identifierMap.entrySet()) {
            System.out.println(entry.getKey() + " found in lines: " + entry.getValue());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("CA3_Starter_Code/src/CA3_Question1.java");
    }
}
