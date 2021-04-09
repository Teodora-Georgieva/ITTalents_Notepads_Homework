package main;

import notepads.ElectronicSecuredNotepad;
import notepads.INotepad;
import notepads.SecuredNotepad;
import notepads.SimpleNotepad;

import java.util.Scanner;

public class NotepadDemo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int numOfPages;
        do {
            System.out.print("Enter the number of pages: ");
            numOfPages = sc.nextInt();
        } while(numOfPages < 0);

        sc.nextLine();
        String owner, password;
        INotepad notepad;

        System.out.println("------ DEMO SIMPLE NOTEPAD --------");
        System.out.print("Enter owner's name: ");
        owner = sc.nextLine();
        notepad = new SimpleNotepad(numOfPages, owner);
        notepad.work();
        /////////////////////////////////////////////////////////////////////////

        System.out.println("------ DEMO SECURED NOTEPAD --------");
        System.out.print("Enter owner's name: ");
        owner = sc.nextLine();
        System.out.print("Enter password for secured notepad: ");
        password = sc.nextLine();
        notepad = new SecuredNotepad(numOfPages, owner, password);
        notepad.work();
        //////////////////////////////////////////////////////////////////////////

        System.out.println("------ DEMO ELECTRONIC SECURED NOTEPAD --------");
        System.out.print("Enter owner's name: ");
        owner = sc.nextLine();
        System.out.print("Enter password for electronic secured notepad: ");
        password = sc.nextLine();
        notepad = new ElectronicSecuredNotepad(numOfPages, owner, password);
        notepad.work();
    }
}