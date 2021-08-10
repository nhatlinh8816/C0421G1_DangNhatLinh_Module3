import java.security.NoSuchAlgorithmException;

public class Quadratic {
    public static void main(String[] args) {

    }


    public static double result1 (double a, double b, double c) throws NoSuchAlgorithmException {
        double delta = b*b - 4*a*c;
        if (delta<0){
            throw new NoSuchAlgorithmException();
        }
        return (-b + Math.sqrt(delta))/(2*a);
    }

    public static double result2 (double a, double b, double c) throws NoSuchAlgorithmException {
        double delta = b*b - 4*a*c;
        if (delta<0){
            throw new NoSuchAlgorithmException();
        }
        return (-b - Math.sqrt(delta))/(2*a);
    }
}
