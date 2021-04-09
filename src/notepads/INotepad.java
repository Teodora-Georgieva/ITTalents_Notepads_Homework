package notepads;

public interface INotepad {
    void addCaptionTo();
    void addTextTo();
    void replaceText();
    void deleteTextFrom();
    void viewAllPages();
    void searchWord();
    void printAllPagesWithDigits();
    String getTypeOfNotepad();
    void work();
}