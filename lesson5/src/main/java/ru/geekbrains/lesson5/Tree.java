package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        int fileCounter = 0;
        for (File f : files) {
            if (f.isDirectory()) {
                subDirTotal++;
            } else if (f.isFile()) {
                fileCounter++;
            }
        }

        int subDirCounter = 0;
        int fileCounterInDir = 0;
        for (File f : files) {
            if (f.isDirectory()) {
                print(f, indent, subDirTotal == ++subDirCounter && fileCounter == 0);
            } else if (f.isFile()) {
                fileCounterInDir++;
                System.out.print(indent + "│   ");
                System.out.print(fileCounterInDir == fileCounter ? "└─" : "├─");
                System.out.println(f.getName());
            }
        }
    }
}
