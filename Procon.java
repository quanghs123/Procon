import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Procon {
    public static void main(String[] args) {
	String input = args[0];
	String fileName = input + ".txt";
        String outputFilePath = "output.txt";

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {

            int n = Integer.parseInt(bufferedReader.readLine());
            String line;
            List<Integer> listHC = new ArrayList<>();
            int k = 0;
            for (int i = 2; i < 2 * n + 1; i = i + 2) {
                for (int j = i * n + i / 2; j <= (i + 1) * n + k; j++) {
                    listHC.add(j);
                }
                k += 1;
            }
            for (Integer number : listHC) {
                bufferedWriter.write(number.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}