import java.util.Scanner;
import java.lang.Math;
public class math {

    int a,b;
    public static int leastCommonMultiplier(int a,int b){
        if (a == 0 || b == 0) {
            return 0;
        }
        int absa = Math.abs(a);
        int absb = Math.abs(b);
        int absHigherNumber = Math.max(absa, absb);
        int absLowerNumber = Math.min(absa, absb);
        int result = absHigherNumber;
        while (result % absLowerNumber != 0) {
            result += absHigherNumber;
        }

        return result;
    }

    public static int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int wrongInput = 0;

        while(true){
            System.out.println("------------------------------");
            System.out.println("What do you want to find?");
            System.out.println("1. Least Common Multiplier");
            System.out.println("2. Greatest Common Divisor");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            if (scan.hasNextInt()) {
            int opt = scan.nextInt();
            System.out.print("\n");
            switch (opt) {
                case 1:
                    while(wrongInput != 3){
                        System.out.print("Enter integer number a: ");
                        if (scan.hasNextInt()) {
                            int a = scan.nextInt();
                            System.out.print("\nEnter integer number b: ");
                            if (scan.hasNextInt()) {
                                int b = scan.nextInt();
                                System.out.println("\nResult: " + leastCommonMultiplier(a,b));
                            }else{
                                scan.next();
                                wrongInput++;
                                System.out.println("Wrong input!");
                            }
                        }else{
                            scan.next();
                            wrongInput++;
                            System.out.println("Wrong input!");
                        }
                        break;
                    }
                    break;
                case 2:
                    while(wrongInput != 3){
                        System.out.print("Enter integer number a: ");
                        if (scan.hasNextInt()) {
                            int a = scan.nextInt();
                            System.out.print("\nEnter integer number b: ");
                            if (scan.hasNextInt()) {
                                int b = scan.nextInt();
                                System.out.println("\nResult: " + greatestCommonDivisor(a,b));
                            }else{
                                scan.next();
                                wrongInput++;
                                System.out.println("Wrong input!");
                            }
                        }else{
                            scan.next();
                            wrongInput++;
                            System.out.println("Wrong input!");
                        }
                        break;
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("There is no option for this number \n");
            }
        }else{
                scan.next();
                System.out.println("Wrong input!!! Only 1, 2 or 3");
            }
        }

//        System.out.println(leastCommonMultiplier(12,18));
//        System.out.println(greatestCommonDivisor(6,3));
//        System.out.println(greatestCommonDivisor(14,35));
//        System.out.println(greatestCommonDivisor(5,10));

    }
}
