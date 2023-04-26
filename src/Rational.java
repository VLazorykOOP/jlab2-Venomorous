import java.util.Scanner;

public class Rational {
    private int numerator;
    private int denominator;

    Scanner scan = new Scanner(System.in);



    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if(denominator > 0){
            this.denominator = denominator;
        }
        else{
            System.out.println("Denominator is less or equal 0");
        }
//        reduce();
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
        Rational fraction1 = new Rational(1, 3);
        Rational fraction2 = new Rational (3, 5);
        Rational fraction3 = new Rational(12,16);
        Rational fraction4 = new Rational(12,0);

        if(fraction1.equals(fraction2)){
            System.out.println("Fraction 1 equals fraction 2");
        }else{
            System.out.println("Fraction 1 doesn't equal fraction 2");
        }
        if(fraction1.isGreaterThan(fraction3)){
            System.out.println("Fraction 1 is greater than fraction 3");
        }else{
            System.out.println("Fraction 1 is less than fraction 2");
        }
        if(fraction3.isLessThan(fraction1)){
            System.out.println("Fraction 3 is less than fraction 1");
        }else{
            System.out.println("Fraction 3 is greater than fraction 1");
        }

        System.out.println(fraction1.numerator + "/" + fraction1.denominator);
        System.out.println(fraction2.numerator + "/" + fraction2.denominator);
        System.out.println(fraction3.numerator + "/" + fraction3.denominator);

        Rational Add = fraction1.add(fraction2);
        System.out.println(fraction1.numerator + "/" + fraction1.denominator + " + " + fraction2.numerator + "/" + fraction2.denominator + " = " + Add.numerator + "/" + Add.denominator);

        Rational sub = fraction3.subtract(fraction1);
        System.out.println(fraction3.numerator + "/" + fraction3.denominator + " - " + fraction1.numerator + "/" + fraction1.denominator + " = " + sub.numerator + "/" + sub.denominator);

        Rational Mult = fraction1.multiply(fraction3);
        System.out.println(fraction1.numerator + "/" + fraction1.denominator + " * " + fraction3.numerator + "/" + fraction3.denominator + " = " + Mult.numerator + "/" + Mult.denominator);

        Rational Div = fraction2.divide(fraction3);
        System.out.println(fraction2.numerator + "/" + fraction2.denominator + " : " + fraction3.numerator + "/" + fraction3.denominator + " = " + Div.numerator + "/" + Div.denominator);

    System.out.println("Fraction 4: " + fraction4.denominator);
    }
}