package notepads;

import utils.Validator;

import java.util.Scanner;

public class SimpleNotepad implements INotepad{
    private Page[] pages;
    private int numberOfPages;
    private String owner;

    public SimpleNotepad(int numberOfPages, String owner){
        if(Validator.isValidString(owner)){
            this.owner = owner;
        }
        else{
            this.owner = "Maria";
        }

        if(numberOfPages > 0){
            this.numberOfPages = numberOfPages;
            pages = new Page[this.numberOfPages];
        }
        else{
            System.out.println("Sorry, invalid number of pages! Setting a default number of pages: 10");
            pages = new Page[10];
        }

        for (int i = 0; i < pages.length; i++) {
            pages[i] = new Page(i);
        }
    }

    public void addCaptionTo(){
        System.out.print("Enter a caption: ");
        Scanner sc = new Scanner(System.in);
        String caption = sc.nextLine();
        System.out.print("Enter the number of the page on which you want to add caption: ");
        int pageNumber = sc.nextInt();

        pageNumber-=1; //because we start numbering pages from 1, but in the array Page[] we start from 0
        if(Validator.isValidPageNumber(pageNumber, this.numberOfPages)){
            this.pages[pageNumber].addCaption(caption);
        }
        else{
            System.out.println("Invalid page number!");
        }

        this.showMenu();
    }

    @Override
    public void addTextTo() {
        System.out.print("Enter a text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.print("Enter the number of the page on which you want to add text: ");
        int pageNumber = sc.nextInt();

        pageNumber-=1;
        if(Validator.isValidPageNumber(pageNumber, this.numberOfPages)){
            this.pages[pageNumber].addText(text);
        }
        else{
            System.out.println("Invalid page number!");
        }

        this.showMenu();
    }

    @Override
    public void replaceText() {
        System.out.print("Enter the text which will replace the old text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.print("Enter the number of the page on which you want to replace text: ");
        int pageNumber = sc.nextInt();

        pageNumber-=1;
        if(Validator.isValidPageNumber(pageNumber, this.numberOfPages)){
            if(pages[pageNumber].isBlank()){
                System.out.println("Page number " + pageNumber + " is blank, so you cannot replace text. You can just " +
                                   "add text, if you want.");
                this.showMenu();
            }

            this.pages[pageNumber].deleteText();
            this.pages[pageNumber].addText(text);
        }
        else{
            System.out.println("Invalid page number!");
        }

        this.showMenu();
    }

    @Override
    public void deleteTextFrom() {
        System.out.print("Enter the number of the page from which you want to delete text: ");
        Scanner sc = new Scanner(System.in);
        int pageNumber = sc.nextInt();

        pageNumber-=1;
        if(Validator.isValidPageNumber(pageNumber, this.numberOfPages)){
            this.pages[pageNumber].deleteText();
        }
        else{
            System.out.println("Invalid page number!");
        }

        this.showMenu();
    }

    public void viewPage(){
        System.out.print("Enter the number of the page you want to be viewed: ");
        Scanner sc = new Scanner(System.in);
        int pageNumber = sc.nextInt();

        pageNumber-=1;
        if(Validator.isValidPageNumber(pageNumber, this.numberOfPages)){
            this.pages[pageNumber].viewPage();
        }
        else{
            System.out.println("Invalid page number!");
        }

        this.showMenu();
    }

    @Override
    public void viewAllPages() {
        System.out.println();
        System.out.println(this.owner + "'s " + this.getTypeOfNotepad());
        for (int i = 0; i < this.numberOfPages; i++) {
            this.pages[i].viewPage();
        }

        this.showMenu();
    }

    public void searchWord(){
        System.out.print("Enter the word you want to search for: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        for (int i = 0; i < this.pages.length; i++) {
            if(this.pages[i].searchWord(word)){
                System.out.println("The word " + word + " is found on page " + (i+1));
                break;
            }
        }

        this.showMenu();
    }

    public String getTypeOfNotepad(){
        return "simple notepad";
    }

    public void printAllPagesWithDigits(){
        for (int i = 0; i < this.pages.length; i++) {
            if(this.pages[i].containsDigits()){
                this.pages[i].viewPage();
            }
        }

        this.showMenu();
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

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter a number from 1 to 8, or 0 if you want to exit: ");
            choice = sc.nextInt();
        } while(choice < 0 || choice > 8);

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
        }
    }

    public void work(){
        System.out.println(this.owner + "'s " + this.getTypeOfNotepad());
        this.showMenu();
    }
}