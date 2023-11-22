import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:/Users/Admin/Desktop/Procon/input.txt";

        try {
            //doc file
            List<Integer> listInput = readFile(fileName);

            //Do dai cua hinh vuong
            int n = listInput.get(0);

            //List bi loai bo
            List<Integer> listRemove = new ArrayList<>();
            int remove = 1;
            while (remove != listInput.size()) {
                listRemove.add(listInput.get(remove));
                remove++;
            }

            //Danh sach index cua cac que diem
            List<Integer> listIndex = fillIndex(n, listRemove);
            for (int i = 0; i < listIndex.size(); i++) {
                System.out.println(listIndex.get(i));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readFile(String fileName) throws IOException {
        List<Integer> listInput = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listInput.add(Integer.parseInt(line));
            }
        }
        return listInput;
    }

    //hàm đánh index cho các que diêm của hình vuông
    private static List<Integer> fillIndex(int squareSide, List<Integer> listRemove) {
        //index hang chan
        List<Integer> listHC = new ArrayList<>();
        for (int i = 0; i < squareSide; i++) {
            if (!listRemove.contains(i)) {
                listHC.add(i);
            }
        }
        int k = 0;
        for (int i = 2; i < 2 * squareSide + 1; i = i + 2) {
            for (int j = i * squareSide + i / 2; j <= (i + 1) * squareSide + k; j++) {
                if (!listRemove.contains(j)) {
                    listHC.add(j);
                }
            }
            k += 1;
        }

        //index hang le
        List<Integer> listHL = new ArrayList<>();
        int l = 0;
        for (int i = 1; i < 2 * squareSide + 1; i += 2) {
            for (int j = i * squareSide + l; j <= (i + 1) * squareSide + l; j++) {
                listHL.add(j);
            }
            l += 1;
        }

        //index cua ca hinh vuong
        List<Integer> listIndex = new ArrayList<>();
        listIndex.addAll(listHC);
        listIndex.addAll(listHL);
        Collections.sort(listIndex);
        return listIndex;
    }
}