// ImmutableCircle.java
public class ImmutableCircle {
    private final double centreX, centreY, radius;
    private static int numCircles;

    public ImmutableCircle(double newCentreX, double newCentreY, double newRadius) {
        centreX = newCentreX;
        centreY = newCentreY;
        radius = newRadius;
        numCircles++;
    }

    public double getCentreX() {
        return centreX;
    }
    public double getCentreY() {
        return centreY;
    }
    public double getRadius() {
        return radius;
    }

    public double computeCircumference () {
        double circum = 2 * Math.PI * radius;
        return circum;
    }
    public double computeArea () {
        double area = Math.PI * radius * radius;
        return area;
    }

    // Static method to count the number of circles
    public static void printNumCircles() {
        System.out.println("Number of circles = " + numCircles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableCircle circle = (ImmutableCircle) o;
        return Double.compare(circle.centreX, centreX) == 0 &&
                Double.compare(circle.centreY, centreY) == 0 &&
                Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public String toString() {
        return "I am a Circle with {" +
                "centreX=" + centreX +
                ", centreY=" + centreY +
                ", radius=" + radius +
                '}';
    }


}
