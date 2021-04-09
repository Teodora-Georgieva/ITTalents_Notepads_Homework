package notepads;

import java.util.Scanner;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice{
    private boolean isStarted;

    public ElectronicSecuredNotepad(int numberOfPages, String owner, String password) throws Exception {
        super(numberOfPages, owner, password);
        this.isStarted = false;
    }

    @Override
    public void start() {
        System.out.println("Turning the device on...");
        this.isStarted = true;
    }

    @Override
    public void stop() {
        enterPassword();
        if(this.isStarted) {
            System.out.println("Turning the device off...");
            this.isStarted = false;
        }
        else {
            this.turnOnDeviceIfYouWant();
        }
    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }

    public void addCaptionTo() {
        if (this.isStarted()) {
            super.addCaptionTo();
        }
        else {
            this.turnOnDeviceIfYouWant();
        }
    }

    public void addTextTo() {
        if(this.isStarted()){
            super.addTextTo();
        }
        else{
            this.turnOnDeviceIfYouWant();
        }
    }

    @Override
    public void replaceText() {
        if(this.isStarted()){
            super.replaceText();
        }
        else{
            this.turnOnDeviceIfYouWant();
        }
    }

    @Override
    public void deleteTextFrom() {
        if(this.isStarted()){
            super.deleteTextFrom();
        }
        else{
            this.turnOnDeviceIfYouWant();
        }
    }

    @Override
    public void viewAllPages() {
        if(this.isStarted()){
            super.viewAllPages();
        }
        else{
            this.turnOnDeviceIfYouWant();
        }
    }

    public void searchWord(){
        if(this.isStarted()){
            super.searchWord();
        }
        else{
            this.turnOnDeviceIfYouWant();
        }
    }

    public void printAllPagesWithDigits(){
        if(this.isStarted()){
            super.printAllPagesWithDigits();
        }
        else{
            this.turnOnDeviceIfYouWant();
        }
    }

    public void viewPage(){
        if(this.isStarted()){
            super.viewPage();
        }
        else{
            this.turnOnDeviceIfYouWant();
        }
    }

    public String getTypeOfNotepad(){
        return "electronic secured notepad";
    }

    private boolean turnOnDeviceIfYouWant(){
        System.out.print("Sorry, the device is off! Press 1, if you want to turn it on, and 0, if you do not: ");
        Scanner sc = new Scanner(System.in);
        int toBeTurnedOn = sc.nextInt();
        if(toBeTurnedOn == 1) {
            this.start();
            return true;
        }

        return false;
    }

    public void showMenu(){
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1 - add caption to a page");
        System.out.println("2 - add text to a page");
        System.out.println("3 - replace text on a page");
        System.out.println("4 - delete text from a page");
        System.out.println("5 - view given page");
        System.out.println("6 - view all pages");
        System.out.println("7 - search word");
        System.out.println("8 - print all pages with digits");
        System.out.println("9 - stop the device");

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter a number from 1 to 8, or 0 if you want to exit: ");
            choice = sc.nextInt();
        } while(choice < 0 || choice > 9);

        switch (choice){
            case 0: return;
            case 1: this.addCaptionTo();
                    break;
            case 2: this.addTextTo();
                    break;
            case 3: this.replaceText();
                    break;
            case 4: this.deleteTextFrom();
                    break;
            case 5: this.viewPage();
                    break;
            case 6: this.viewAllPages();
                    break;
            case 7: this.searchWord();
                    break;
            case 8: this.printAllPagesWithDigits();
                    break;
            case 9: this.stop();
                    return;
        }
    }

    @Override
    public void work() {
        if(!isStarted){
            boolean turnedOn = turnOnDeviceIfYouWant();
            if(turnedOn){
                super.work();
            }
        }
    }
}