import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Procon {
    public static void main(String[] args) {
	String fileName = "C:/Users/Admin/Desktop/Procon/question.txt";
        String outputFilePath = "C:/Users/Admin/Desktop/Procon/result.txt";

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {

            int n = Integer.parseInt(bufferedReader.readLine());
            String line;
            List<Integer> listRemove = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                listRemove.add(Integer.parseInt(line));
            }
            List<Integer> listHC = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                listHC.add(i);
            }
            int k = 0;
            for (int i = 2; i < 2 * n + 1; i = i + 2) {
                for (int j = i * n + i / 2; j <= (i + 1) * n + k; j++) {
                    listHC.add(j);
                }
                k += 1;
            }
            List<Integer> listHL = new ArrayList<>();
            int l = 0;
            for (int i = 1; i < 2 * n + 1; i += 2) {
                for (int j = i * n + l; j <= (i + 1) * n + l; j++) {
                    listHL.add(j);
                }
                l += 1;
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