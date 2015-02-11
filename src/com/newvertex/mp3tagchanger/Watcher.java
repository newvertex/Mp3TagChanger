package com.newvertex.mp3tagchanger;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyAdapter;
import net.contentobjects.jnotify.JNotifyException;

public class Watcher {

    public static void watchCreate(String path) {
        int mask = JNotify.FILE_CREATED;
        boolean watchSubTree = true;

        try {
            int watchId = JNotify.addWatch(path, mask, watchSubTree, new CreateListener());
        } catch (JNotifyException ex) {
            Logger.getLogger(Mp3TagChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class CreateListener extends JNotifyAdapter {

        @Override
        public void fileCreated(int wd, String rootPath, String name) {
            System.out.println("Created: " + rootPath + name);
        }

    }

}
