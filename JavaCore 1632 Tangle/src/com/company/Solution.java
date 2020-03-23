package com.company;

/*

1632 Tangle

1. Create 5 different threads with a different type from Thread:
1.1. Thread 1 must run endlessly;
1.2. Thread 2 should throw an "InterruptedException" when an InterruptedException occurs;
1.3. Thread 3 should output “Hurray” every half second;
1.4. Thread 4 must implement the Message interface; when the showWarning method is called, the thread must stop;
1.5. Thread 5 should read from the console of the number until the word "N" is entered, and then display the sum of
the numbers entered into the console.
2. In the static block, add your threads to the List <Thread> threads in the listed order.
3. Threads should not start automatically.
Hint:
Thread 4 can be checked using the isAlive () method

Requirements:
1. The static block of the Solution class should create and add 5 threads to the threads list.
2. Threads from the threads list should not start automatically.
3. Thread 1 from the threads list should run indefinitely.
4. Thread 2 from the list of threads should throw an "InterruptedException" when an InterruptedException is thrown.
5. Thread 3 from the list of threads should output "Hurray" every half second.
6. Thread 4 from the list of threads should implement the Message interface; when the showWarning method is called,
the thread should stop.
7. Thread 5 from the list of threads should read from the number console until the word "N" is entered, and then
display the sum of the numbers entered into the console.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new One());
        threads.add(new Two());
        threads.add(new Three());
        threads.add(new Four());
        threads.add(new Five());
    }

    public static void main(String[] args) {
    }
}

class One extends Thread {
    @Override
    public void run() {
        while (true) {}
    }
}

class Two extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
}

class Three extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Four extends Thread implements Five.Message {

    @Override
    public void run() {
        while (!isInterrupted()) {}
    }

    @Override
    public void showWarning() {
        interrupt();
    }
}

class Five extends Thread {

    @Override
    public void run() {
        String line;
        int result = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(line = reader.readLine()).equals("N")) {
                result += Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    interface Message {
        void showWarning();
    }
}





