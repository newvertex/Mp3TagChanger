package com.newvertex.mp3tagchanger;

import java.io.File;
import java.util.Scanner;
import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyAdapter;
import net.contentobjects.jnotify.JNotifyException;

public class Mp3TagChanger {

    public static void main(String[] args) {

        System.out.println("Enter directory path:");
        String path = new Scanner(System.in).nextLine();
        
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }

    }

    private void watchCreate(String path) throws JNotifyException {
        int mask = JNotify.FILE_CREATED;
        boolean watchSubTree = true;

        int watchId = JNotify.addWatch(path, mask, watchSubTree, new Listener());
    }

    private class Listener extends JNotifyAdapter {

        @Override
        public void fileCreated(int wd, String rootPath, String name) {
            System.out.println("Created: " + rootPath + name);
        }

    }

}
