package com.newvertex.mp3tagchanger;

import com.newvertex.mp3tagchanger.model.Tags;
import com.newvertex.mp3tagchanger.util.Watcher;
import com.newvertex.mp3tagchanger.util.GetAllFiles;
import com.newvertex.mp3tagchanger.util.TagChanger;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Mp3TagChanger {

    private static Tags tags;

    public static void main(String[] args) {
        new Mp3TagChanger().mainMenu();
    }

    private void mainMenu() {
        while (true) {
            System.out.println("1. Watching for new file and change tag.\n"
                    + "2. Change all files tag.\n"
                    + "3. Set tsgs.\n"
                    + "4. Exit.");
            System.out.print("$ ");
            String item = new Scanner(System.in).nextLine();
            switch (item) {
                case "1":
                    watching();
                    break;
                case "2":
                    ArrayList<Path> files = GetAllFiles.getFiles(getPath());
                    TagChanger.ChangeTags(files, tags);
                    break;
                case "3":
                    System.out.println("TODO: Set Tags Section...");
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
            }
        }
    }

    private static void watching() {
        String path = getPath();
        Watcher.watchCreate(path, tags);
        System.out.println("Watching: " + path);
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
