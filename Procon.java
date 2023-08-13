import java.util.ArrayList;
import java.util.List;
public class Procon {
    public static void main(String[] args) {
        int n = 100;
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
        System.out.println("Hang Chan: ");
        for (Integer integer : listHC) {
            System.out.println(integer);
        }
        System.out.println("Hang le: ");
        for (Integer integer : listHL) {
            System.out.println(integer);
        }
    }
}