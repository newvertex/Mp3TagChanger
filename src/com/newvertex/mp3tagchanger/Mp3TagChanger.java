package com.newvertex.mp3tagchanger;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyAdapter;
import net.contentobjects.jnotify.JNotifyException;

public class Mp3TagChanger {

    public static void main(String[] args) {

        new Mp3TagChanger().watchCreate(getPath());

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

    private void watchCreate(String path) {
        int mask = JNotify.FILE_CREATED;
        boolean watchSubTree = true;

        try {
            int watchId = JNotify.addWatch(path, mask, watchSubTree, new Listener());
        } catch (JNotifyException ex) {
            Logger.getLogger(Mp3TagChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class Listener extends JNotifyAdapter {

        @Override
        public void fileCreated(int wd, String rootPath, String name) {
            System.out.println("Created: " + rootPath + name);
        }

    }

}
