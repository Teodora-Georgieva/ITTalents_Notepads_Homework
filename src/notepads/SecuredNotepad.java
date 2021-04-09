package notepads;

import utils.Validator;
import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad{
    private String password;

    public SecuredNotepad(int numberOfPages, String owner, String password) throws Exception {
        super(numberOfPages, owner);
        if(!Validator.isStrongPassword(password)){
            throw new Exception("The password is not strong enough!");
        }
        else{
            this.password = password;
        }
    }

    public void addCaptionTo(){
        enterPassword();
        super.addCaptionTo();
    }

    public void addTextTo() {
        enterPassword();
        super.addTextTo();
    }

    @Override
    public void replaceText() {
        enterPassword();
        super.replaceText();
    }

    @Override
    public void deleteTextFrom() {
        enterPassword();
        super.deleteTextFrom();
    }

    @Override
    public void viewAllPages() {
        enterPassword();
        super.viewAllPages();
    }

    void enterPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter your password: ");
        String password = sc.nextLine();
        if(this.isValidPassword(password)){
            return;
        }

        System.out.println("Sorry, wrong password!");
        enterPassword();
    }

    boolean isValidPassword(String password){
        return this.password.equals(password);
    }

    public void searchWord(){
        enterPassword();
        super.searchWord();
    }

    public void printAllPagesWithDigits(){
        enterPassword();
        super.printAllPagesWithDigits();
    }

    public void viewPage(){
        enterPassword();
        super.viewPage();
    }

    public String getTypeOfNotepad(){
        return "secured notepad";
    }

    @Override
    public void work() {
        enterPassword();
        super.work();
    }
}