import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Number of an odd dimension n...
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an odd number for a length: ");
        int length = scanner.nextInt();
        
        //Rotate a square clockwise by (0x0°, 1x90°, 2x90°, 3x90°)...
        System.out.print("Enter rotation of a square, (0=0°, 1=90°, 2=180°, 3=270°): ");
        int rotation = scanner.nextInt();

        if ((length % 2 != 0) && (rotation >= 0 && rotation <= 3)){
            //Square with length x length dimension of numbers...
            int [][] numbers = new int [length][length];

            //Declare and create an object...
            Square square = new Square(length, numbers, rotation);
            System.out.println();
            System.out.println("___ "+ length +" x "+ length +" Magic Square ___");
            System.out.println();

            //Generate a magic square than is (n x n) and rotate in degrees...
            square.generateSquare(length);
            System.out.println();
            System.out.println("The sum of each row, column and diagonal is "+square.sum);
            System.out.println("___ END ___");

        }else{
            throw new RuntimeException("length must be an odd length !!!");
        }
    }
}