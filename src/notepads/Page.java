package notepads;

import utils.Validator;

public class Page {
    private String caption;
    private String text;
    private int pageNumber;

    public Page(int pageNumber){
        if(pageNumber >= 0){
            this.pageNumber = pageNumber;
        }
        else{
            this.pageNumber = 0;
        }
    }

    void addCaption(String caption){
        if(this.caption == null) {
            if (Validator.isValidString(caption)) {
                this.caption = caption;
                System.out.println("A caption is successfully added to page number " + (this.pageNumber + 1));
            } else {
                System.out.println("Sorry, invalid caption!");
            }
        }
        else{
            System.out.println("Sorry, page number " + (this.pageNumber + 1)  +" already has a caption");
        }
    }

    void addText(String text){
        if(Validator.isValidString(text)){
            if(this.text == null){
                this.text = text;
            }
            else{
                this.text += '\n';
                this.text+= text;
            }

            System.out.println("New text is successfully added to page number " + (this.pageNumber + 1));
        }
        else{
            System.out.println("Sorry, invalid text!");
        }
    }

    void deleteText(){
        if(this.text == null){
            System.out.println("There is no text on page number " + (this.pageNumber + 1) + ", so you cannot delete!");
            return;
        }

        this.text = null;
        System.out.println("The text on page number " + (this.pageNumber + 1) + " is successfully deleted!");
    }

    void viewPage(){
        if(this.isBlank()){
            System.out.println("Page number " + (this.pageNumber + 1) + " is blank.");
            return;
        }

        System.out.println("Page number " + (this.pageNumber + 1) + ":");
        System.out.println("               " + this.caption);
        System.out.println(this.text);
        System.out.println();
        System.out.println();
    }

    boolean isBlank(){
        return this.caption == null && this.text == null;
    }

    boolean searchWord(String word){
        if(this.text == null){
            return false;
        }

        return this.text.contains(word);
    }

    boolean containsDigits(){
        if(this.text == null){
            return false;
        }

        return Validator.containsDigit(this.text);
    }
}