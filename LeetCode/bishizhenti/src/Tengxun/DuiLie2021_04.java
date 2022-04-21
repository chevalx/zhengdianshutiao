package Tengxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DuiLie2021_04 {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++) {
            MyQueue queue = new MyQueue();
            int operationNum = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < operationNum; j++) {
                String command = scanner.nextLine().trim();
                if (command.startsWith("PUSH")) {
                    String[] strings = command.split(" ");
                    queue.push(Integer.parseInt(strings[1]));
                } else if (command.startsWith("TOP")) {
                    res.add(String.valueOf(queue.peek()));
                } else if (command.startsWith("POP")) {
                    int polled = queue.poll();
                    if (polled == -1) {
                        res.add(String.valueOf(polled));
                    }
                } else if (command.startsWith("SIZE")) {
                    res.add(String.valueOf(queue.size()));
                } else {
                    queue = new MyQueue();
                }
            }
        }

        for (String re : res) {
            System.out.println(re);
        }
    }
}

class MyQueue {
    int LENGTH = 2000;
    int[] buffer = new int[LENGTH];
    int head = 0;
    int tail = 0;
    int count = 0;

    public void push(int x) {
        buffer[tail] = x;
        tail = (tail + 1) % LENGTH;
        count++;
    }

    public int peek() {
        if (count <= 0) {
            return -1;
        }
        return buffer[head];
    }

    public int poll() {
        if (count <= 0) {
            count--;
            return -1;
        }
        int ret = buffer[head];
        head = (head + 1) % LENGTH;
        count--;
        return ret;
    }

    public int size() {
        return count;
    }

    public void clear() {
        Arrays.fill(buffer, -1);
    }
}