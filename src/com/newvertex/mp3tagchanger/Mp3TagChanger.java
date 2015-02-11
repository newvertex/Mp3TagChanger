package com.newvertex.mp3tagchanger;

import java.io.File;
import java.util.Scanner;

public class Mp3TagChanger {

    public static void main(String[] args) {

        Watcher.watchCreate(getPath());

        mainLoop();
    }

    private static void mainLoop() {
        System.out.println("For close the program type: exit");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().toLowerCase().equals("exit")) {
                break;
            } else {
                System.out.println("For close the program type: exit");
            }
        }
    }

    private static String getPath() {
        System.out.println("Enter directory path:");
        String path = new Scanner(System.in).nextLine();
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        return path;
    }
}
