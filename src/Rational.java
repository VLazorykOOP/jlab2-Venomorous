import java.util.Scanner;

public class Rational {
    private int numerator;
    private int denominator;


    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        }

    public void setValues(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Rational add(Rational other) {
        int lcm = lcm(this.denominator, other.denominator);
        int numerator = (this.numerator * (lcm / this.denominator)) +
                (other.numerator * (lcm / other.denominator));
        return new Rational(numerator, lcm);
    }

    public Rational subtract(Rational other) {
        int lcm = lcm(this.denominator, other.denominator);
        int numerator = (this.numerator * (lcm / this.denominator)) -
                (other.numerator * (lcm / other.denominator));
        return new Rational(numerator, lcm);
    }

    public Rational multiply(Rational other) {
        int numerator = this.numerator * other.numerator;
        int denominator = this.denominator * other.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational other) {
        int numerator = this.numerator * other.denominator;
        int denominator = this.denominator * other.numerator;
        return new Rational(numerator, denominator);
    }

    public boolean equals(Rational other) {
        return this.numerator == other.numerator &&
                this.denominator == other.denominator;
    }

    public boolean isGreaterThan(Rational other) {
        int lcm = lcm(this.denominator, other.denominator);
        int thisNum = this.numerator * (lcm / this.denominator);
        int otherNum = other.numerator * (lcm / other.denominator);
        return thisNum > otherNum;
    }

    public boolean isLessThan(Rational other) {
        int lcm = lcm(this.denominator, other.denominator);
        int thisNum = this.numerator * (lcm / this.denominator);
        int otherNum = other.numerator * (lcm / other.denominator);
        return thisNum < otherNum;
    }

    private void reduce() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    public void print(){
        if(this.numerator != 0) {
            System.out.print(numerator + "/" + denominator);
        }else{
            System.out.println("0");
        }

    }

    public static void printAdd(Rational fraction1, Rational fraction2) {
        fraction1.print();
        System.out.print(" + ");
        fraction2.print();
        System.out.print(" = ");
        Rational result = fraction1.add(fraction2);
        result.print();
        System.out.println();
    }

    public static void printSub(Rational fraction1, Rational fraction2) {
        fraction1.print();
        System.out.print(" - ");
        fraction2.print();
        System.out.print(" = ");
        Rational result = fraction1.subtract(fraction2);
        result.print();
        System.out.println();
    }

    public static void printMult(Rational fraction1, Rational fraction2) {
        fraction1.print();
        System.out.print(" * ");
        fraction2.print();
        System.out.print(" = ");
        Rational result = fraction1.multiply(fraction2);
        result.print();
        System.out.println();
    }

    public static void printDiv(Rational fraction1, Rational fraction2) {
        fraction1.print();
        System.out.print(" / ");
        fraction2.print();
        System.out.print(" = ");
        Rational result = fraction1.divide(fraction2);
        result.print();
        System.out.println();
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Rational fraction1 = new Rational(1,1);
        Rational fraction2 = new Rational(1,1);

        int a =0, b = 0;

        int badInput=0;

        while(badInput!=3){
            System.out.println("------------------------------");
            System.out.println("1. Subtract one number from another");
            System.out.println("2. Add one number to another");
            System.out.println("3. Multiply one number by another");
            System.out.println("4. Divide one number by another");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");
            int opt = scan.nextInt();
            switch (opt) {
                case 1:
                    badInput = 0;
                    System.out.println("Enter a numerator and a denominator for the first number:");
                        if(scan.hasNextInt()) {
                            a = scan.nextInt();
                                while(badInput!=3) {
                                    if(scan.hasNextInt()){
                                    b = scan.nextInt();
                                    if(b > 0){
                                        fraction1 = new Rational(a,b);
                                        fraction1.print();
                                        System.out.println("");
                                        break;
                                    }else {
                                        System.out.println("Denominator can't be less or equal to 0");
                                        System.out.println("Enter a denominator again:");
                                        badInput++;
                                    }
                                    }else {
                                        System.out.println("Wrong input");
                                        badInput++;
                                        scan.next();
                                    }
                            }
                                System.out.println("Enter a numerator and a denominator for the second number:");
                                if(scan.hasNextInt()) {
                                    a = scan.nextInt();
                                    if(scan.hasNextInt()){
                                        b = scan.nextInt();
                                        if(b > 0){
                                            fraction2 = new Rational(a,b);
                                            fraction2.print();
                                            System.out.println("");
                                            printSub(fraction1,fraction2);
                                        }else {
                                            System.out.println("Denominator can't be less or equal to 0");
                                            badInput++;
                                        }
                                    }else {
                                        System.out.println("Wrong input");
                                        badInput++;
                                        scan.next();
                                    }
                                }else {
                                    System.out.println("Wrong input");
                                    badInput++;
                                    scan.next();
                                }
                    }else {
                        System.out.println("Wrong input");
                        badInput++;
                        scan.next();
                    }
                    break;
                case 2:
                    badInput = 0;
                    System.out.println("Enter a numerator and a denominator for the first number:");
                    if(scan.hasNextInt()) {
                        a = scan.nextInt();
                        while(badInput!=3) {
                            if(scan.hasNextInt()){
                                b = scan.nextInt();
                                if(b > 0){
                                    fraction1 = new Rational(a,b);
                                    fraction1.print();
                                    System.out.println("");
                                    break;
                                }else {
                                    System.out.println("Denominator can't be less or equal to 0");
                                    System.out.println("Enter a denominator again:");
                                    badInput++;
                                }
                            }else {
                                System.out.println("Wrong input");
                                badInput++;
                                scan.next();
                            }
                        }
                        System.out.println("Enter a numerator and a denominator for the second number:");
                        if(scan.hasNextInt()) {
                            a = scan.nextInt();
                            if(scan.hasNextInt()){
                                b = scan.nextInt();
                                if(b > 0){
                                    fraction2 = new Rational(a,b);
                                    fraction2.print();
                                    System.out.println("");
                                    printAdd(fraction1,fraction2);
                                }else {
                                    System.out.println("Denominator can't be less or equal to 0");
                                    badInput++;
                                }
                            }else {
                                System.out.println("Wrong input");
                                badInput++;
                                scan.next();
                            }
                        }else {
                            System.out.println("Wrong input");
                            badInput++;
                            scan.next();
                        }
                    }else {
                        System.out.println("Wrong input");
                        badInput++;
                        scan.next();
                    }
                    break;
                case 3:
                    badInput = 0;
                    System.out.println("Enter a numerator and a denominator for the first number:");
                    if(scan.hasNextInt()) {
                        a = scan.nextInt();
                        while(badInput!=3) {
                            if(scan.hasNextInt()){
                                b = scan.nextInt();
                                if(b > 0){
                                    fraction1 = new Rational(a,b);
                                    fraction1.print();
                                    System.out.println("");
                                    break;
                                }else {
                                    System.out.println("Denominator can't be less or equal to 0");
                                    System.out.println("Enter a denominator again:");
                                    badInput++;
                                }
                            }else {
                                System.out.println("Wrong input");
                                badInput++;
                                scan.next();
                            }
                        }
                        System.out.println("Enter a numerator and a denominator for the second number:");
                        if(scan.hasNextInt()) {
                            a = scan.nextInt();
                            if(scan.hasNextInt()){
                                b = scan.nextInt();
                                if(b > 0){
                                    fraction2 = new Rational(a,b);
                                    fraction2.print();
                                    System.out.println("");
                                    printMult(fraction1,fraction2);
                                }else {
                                    System.out.println("Denominator can't be less or equal to 0");
                                    badInput++;
                                }
                            }else {
                                System.out.println("Wrong input");
                                badInput++;
                                scan.next();
                            }
                        }else {
                            System.out.println("Wrong input");
                            badInput++;
                            scan.next();
                        }
                    }else {
                        System.out.println("Wrong input");
                        badInput++;
                        scan.next();
                    }
                    break;
                case 4:
                    badInput = 0;
                    System.out.println("Enter a numerator and a denominator for the first number:");
                    if(scan.hasNextInt()) {
                        a = scan.nextInt();
                        while(badInput!=3) {
                            if(scan.hasNextInt()){
                                b = scan.nextInt();
                                if(b > 0){
                                    fraction1 = new Rational(a,b);
                                    fraction1.print();
                                    System.out.println("");
                                    break;
                                }else {
                                    System.out.println("Denominator can't be less or equal to 0");
                                    System.out.println("Enter a denominator again:");
                                    badInput++;
                                }
                            }else {
                                System.out.println("Wrong input");
                                badInput++;
                                scan.next();
                            }
                        }
                        System.out.println("Enter a numerator and a denominator for the second number:");
                        if(scan.hasNextInt()) {
                            a = scan.nextInt();
                            if(scan.hasNextInt()){
                                b = scan.nextInt();
                                if(b > 0){
                                    fraction2 = new Rational(a,b);
                                    fraction2.print();
                                    System.out.println("");
                                    printDiv(fraction1,fraction2);
                                }else {
                                    System.out.println("Denominator can't be less or equal to 0");
                                    badInput++;
                                }
                            }else {
                                System.out.println("Wrong input");
                                badInput++;
                                scan.next();
                            }
                        }else {
                            System.out.println("Wrong input");
                            badInput++;
                            scan.next();
                        }
                    }else {
                        System.out.println("Wrong input");
                        badInput++;
                        scan.next();
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("There is no option for this number \n");
            }
        }

}
}