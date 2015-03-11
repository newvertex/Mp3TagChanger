package com.newvertex.mp3tagchanger.util;

import com.newvertex.mp3tagchanger.Mp3TagChanger;
import com.newvertex.mp3tagchanger.model.Tags;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyAdapter;
import net.contentobjects.jnotify.JNotifyException;

public class Watcher {

    public static void watchCreate(String path, Tags tags) {
        int mask = JNotify.FILE_CREATED;
        boolean watchSubTree = true;

        try {
            int watchId = JNotify.addWatch(path, mask, watchSubTree, new CreateListener(tags));
        } catch (JNotifyException ex) {
            Logger.getLogger(Mp3TagChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class CreateListener extends JNotifyAdapter {

        Tags tags;

        private CreateListener(Tags tags) {
            this.tags = tags;
        }

        @Override
        public void fileCreated(int wd, String rootPath, String name) {
            File file = new File(rootPath + name);
            if (file.isFile() && name.toLowerCase().endsWith(".mp3")) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
                }
                TagChanger.changeTag(file, tags);
            }

        }
    }

}
