package com.newvertex.mp3tagchanger;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetAllFiles {

    private static ArrayList<Path> files;

    public static ArrayList<Path> getFiles(String dir) {
        files = new ArrayList<>();
        Path path = Paths.get(dir);
        try {
            Files.walkFileTree(path, new FileVisited());
        } catch (IOException ex) {
            Logger.getLogger(GetAllFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return files;
    }

    private static class FileVisited extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("FileVisited: " + file);
            files.add(file);
            return FileVisitResult.CONTINUE;
        }

    }
}
