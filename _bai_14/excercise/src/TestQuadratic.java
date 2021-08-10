import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class TestQuadratic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập các tham số của phương trình ax^2+bx+c=0");
        System.out.println("tham số a");
        double a = input.nextDouble();
        System.out.println("tham số b");
        double b = input.nextDouble();
        System.out.println("tham số c");
        double c = input.nextDouble();
        try {
            System.out.println("Nghiệm thứ nhất: "+Quadratic.result1(a,b,c));
            System.out.println("Nghiệm thứ hai: "+Quadratic.result2(a,b,c));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
