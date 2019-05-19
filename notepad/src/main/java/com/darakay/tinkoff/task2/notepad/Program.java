package com.darakay.tinkoff.task2.notepad;

import com.darakay.tinkoff.task2.notepad.storage.SimpleStorage;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Notepad notepad = new Notepad(new SimpleStorage());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input note name:");
        String entryName = scanner.nextLine();

        System.out.println("Input note text:");
        String text = scanner.nextLine();

        notepad.addEntry(entryName, text);
        System.out.println("Note was saved.");

    }
}
