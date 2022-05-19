import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Huawei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();  // 芯片数量
        int n = scanner.nextInt();  // 业务数量
        int[] cores = new int[m];   // 每个元素最大值为4，0代表未占用
        int pointer = 0;            // 指向最新的被分配的芯片
        String[] yewus = new String[n];
        for (int i = 0;i<n;i++) {
            yewus[i] = scanner.next();
        }
        for (int i = 0; i<n;i++) {
            String curYewu = yewus[i];    //  当前业务
            int core = 0;
            int resource = 0;
            if (curYewu.equals("A")) {         // 当前业务是A
                int foundA = -1;
                for(int j = 0; j<=pointer; j++) {    // 从前往后找第一个符合的芯片
                    if (cores[j] < 4) {
                        foundA = j;break;          // 找到了
                    }
                }
                if (foundA != -1) {             // 找到了
                    cores[foundA]++;           // 分配到cores[foundA]上
                    core = foundA + 1;
                    resource = cores[foundA];
                } else {                         // 没找到
                    pointer++;                    // 新分配一个芯片
                    if (pointer>=m) {
                        pointer--;
                        core = 0;
                        resource = 0;
                    } else {
                        cores[pointer]++;
                        core = pointer + 1;
                        resource = cores[pointer];
                    }
                }
            } else {                    // 当前业务是B
                pointer++;                    // B的话必须新分配一个芯片
                if (pointer>=m) {        // 没法再分配了
                    pointer--;
                    core = 0;
                    resource = 0;
                } else{
                    cores[pointer] = 4;
                    core = pointer + 1;
                    resource = 1;
                }
            }
            if (i == n-1) {
                System.out.println(core);
                System.out.println(resource);
            }
        }
    }
}
