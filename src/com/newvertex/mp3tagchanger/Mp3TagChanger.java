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
                    + "3. Exit.\n"
                    + "$ ");
            String item = new Scanner(System.in).nextLine();
            switch (item) {
                case "1":
                    setTagsText();
                    watching();
                    break;
                case "2":
                    setTagsText();
                    ArrayList<Path> files = GetAllFiles.getFiles(getPath());
                    TagChanger.ChangeTags(files, tags);
                    break;
                case "3":
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

    private void setTagsText() {
        tags = new Tags();
        System.out.println("The default Tags is empty string.\n"
                + "1. Title tag for all.\n"
                + "2. Each tag separately.\n"
                + "$ ");
        String item = new Scanner(System.in).nextLine();
        switch (item) {
            case "1":
                System.out.print("Enter the title:$ ");
                item = new Scanner(System.in).nextLine();
                tags = new Tags(item);
                break;
            case "2":
                System.out.print("Enter the Title:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setTitle(item);

                System.out.print("Enter the SubTitle:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setSubTitle(item);

                System.out.print("Enter the Comment:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setComment(item);

                System.out.print("Enter the Composer:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setComposer(item);

                System.out.print("Enter the Album:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setAlbum(item);

                System.out.print("Enter the AlbumArtist:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setAlbumArtist(item);

                System.out.print("Enter the Artist:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setArtist(item);

                System.out.print("Enter the Artists:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setArtists(item);
                
                System.out.print("Enter the Genre:$ ");
                item = new Scanner(System.in).nextLine();
                tags.setGenre(item);
                break;
            default:
        }
    }
}
