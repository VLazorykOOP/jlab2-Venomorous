import java.util.Scanner;
public class Triangle {
    int side1, side2, side3;
    int perimeter;
    double area, areasq, S;
    protected boolean isValid(double a, double b, double c) {
        if((a+b)>c && (a+c)>b && (b+c)>a) {
            return true;
        }else {
            return false;
        }
    }
    public Triangle(){
        this.side1 = 0;
        this.side2 = 0;
        this.side3 = 0;
    }

    public Triangle(int side1, int side2, int side3){
        if(isValid(side1, side2, side3)){
            System.out.println("Triangle is created");
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }else {
            System.out.println("This is not a valid triangle");
        }
//        System.out.println("Sides");
    }
    protected int Perim(){
        perimeter = side1 + side2 + side3;
        return perimeter;
    }
    protected double Area(){
        S = perimeter/2;
//        S = (this.side1 + this.side2 + this.side3)/2;
//        System.out.println("S = " + S);
        areasq = S*(S-side1)*(S-side2)*(S-side3);
//        System.out.println("areasq = " + areasq);
        area =  java.lang.Math.sqrt(areasq);
//        System.out.println("area = " + area);

        return area;
    }

    protected void isEqual(Triangle triangle){
        if(this.area == triangle.area && this.perimeter == triangle.perimeter){
            System.out.println("Area and perimeter of triangles are the same");
            if (this.side1 == triangle.side1 && this.side2 == triangle.side2 && this.side3 == triangle.side3) {
                System.out.println("Sides of triangles are the same");
            }else {
                System.out.println("Sides of triangles are different");
            }
        }else {
            System.out.println("Area and perimeter of triangles are different");
        }
    }


    public void print(){
        System.out.println("Sides of a triangle:");
        System.out.println("Side 1: " + side1);
        System.out.println("Side 2: " + side2);
        System.out.println("Side 3: " + side3);
        System.out.println("Perimeter of a triangle: " + perimeter);
        System.out.println("Area of a triangle: " + area);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Triangle tri = new Triangle(9,10,11);

        tri.Perim();
        tri.Area();
        tri.print();
        System.out.println("--------------------------------------------------------------");

        Triangle tri2 = new Triangle(1,2,3);

        tri2.Perim();
        tri2.Area();
        tri2.print();
        tri2.isEqual(tri);
        System.out.println("--------------------------------------------------------------");

        Triangle tri3 = new Triangle(9,10,11);

        tri3.Perim();
        tri3.Area();
        tri3.print();
        tri3.isEqual(tri);
        System.out.println("--------------------------------------------------------------");

        Triangle tri4 = new Triangle(10,9,11);

        tri4.Perim();
        tri4.Area();
        tri4.print();
        tri4.isEqual(tri);
    }
}
