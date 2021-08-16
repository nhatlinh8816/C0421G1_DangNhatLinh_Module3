package service;

public class Validate {
    public static String validateName(String name){
        String msg = null;
        String regex = "^\\D*\\s\\D*$";
        if (!name.matches(regex)){
            msg = "Not OK. Please retry";
        }
        return msg;
    }
}
