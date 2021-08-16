package model.service.commons;

public class Validate {
    public static String validateName(String name) {
        String message = null;
        String regex = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        if (!name.matches(regex)) {
            message = "Not OK. Student name invalid";
        }
        return message;
    }
    public static String validatePoint(int point) {
        String message = null;
        if (point < 0 || point > 100) {
            message = "Not OK. Student point invalid";
        }
        return message;
    }
    public static boolean validateNumber(String num) {
        String regex = "^\\d$";
        return num.matches(regex);
    }
}
