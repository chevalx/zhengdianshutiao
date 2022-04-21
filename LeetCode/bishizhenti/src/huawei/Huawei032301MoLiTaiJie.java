package huawei;

import java.util.*;

public class Huawei032301MoLiTaiJie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawData = scanner.nextLine().trim();
        int tagNum = scanner.nextInt();
        Deque<Integer> tags = new LinkedList<>();
        for (int i = 0; i < tagNum; i++) {
            tags.offerLast(scanner.nextInt());
        }
        int pointer = 0;
        while (pointer <= rawData.length() - 1) {
            int curTag = Integer.parseInt(rawData.substring(pointer, pointer + 2), 16);
            pointer += 2;
            int length = Integer.parseInt(rawData.substring(pointer, pointer + 2), 16);
            pointer += 2;
            int offset = pointer / 2; // ?
            pointer += (length * 2);
            if (pointer <= rawData.length() - 1) {
                while (!tags.isEmpty() && tags.peekFirst() != curTag) {
                    tags.pollFirst();
                    System.out.println("0 0");
                }
                if (tags.isEmpty()) {
                    return;
                }
                tags.pollFirst();
                System.out.println(length + " " + offset);
            } else {
                System.out.println("0 0");
                return;
            }
        }
    }
}
