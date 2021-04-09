package utils;

public abstract class Validator {
    public static boolean isValidString(String s){
        return s != null && s.length() > 0;
    }

    public static boolean isValidPageNumber(int pageNumber, int numberOfPages){
        return pageNumber >= 0 && pageNumber < numberOfPages;
    }

    public static boolean isStrongPassword(String password){
        return password.length() >= 5 && containsLowerCase(password) &&
                containsUpperCase(password) && containsDigit(password);
    }

    private static boolean containsLowerCase(String password){
        for (int i = 0; i < password.length(); i++) {
            if((password.charAt(i) >= 'a' && password.charAt(i) <= 'z') ||
                    (password.charAt(i) >= 'а' && password.charAt(i) <= 'я')){
                return true;
            }
        }

        return false;
    }

    private static boolean containsUpperCase(String password){
        for (int i = 0; i < password.length(); i++) {
            if((password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') ||
                    (password.charAt(i) >= 'А' && password.charAt(i) <= 'Я')){
                return true;
            }
        }

        return false;
    }

    public static boolean containsDigit(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                return true;
            }
        }

        return false;
    }
}