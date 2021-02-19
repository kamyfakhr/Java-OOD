// CircleTest.java: A test program to test the Circle class
public class CircleTest {
    public static void main(String args[]) {
        Circle aCircle = new Circle();


        aCircle.setCentreX(10.0);
        aCircle.setCentreY(20.0);
        aCircle.setRadius(5.0);
        System.out.println("Radius = " + aCircle.getRadius());
        System.out.println("Circum: = " + aCircle.computeCircumference());
        System.out.println("Area = " + aCircle.computeArea());
        aCircle.resize(2.0);
        System.out.println("Radius = " + aCircle.getRadius());
        System.out.println(new Circle(5.0, 5.0, 40.0));


        Circle  circ_1 = new Circle(2.0, 2.0, 100.0);
        Circle circ_2=  new Circle(2.0, 2.0, 10.0);
        System.out.println("Circles are equal = " +  circ_1.equals(circ_2));

        System.out.println("circ_1 = " + circ_1);
    }
}
