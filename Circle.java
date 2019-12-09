import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will represent a circle shape and inherit all of the public and protected members from the shape class.
 * It will be able to draw the circle using only a radius measurement in a Jpane.
 */
public class Circle extends Shape {
    /**
     * This is the radius of the Circle.
     */
    private double radius;

    /**
     * This is the no arg constructor that will implement the super classes no arg constructor so that the user does
     * not have to input any information.
     */
    public Circle() {
        super();
        radius = 1;

    }

    /**
     * This constructor will allow the user to specify a radius for the circle.
     *
     * @param r This is the radius that the user wants the circle to be.
     */
    public Circle(double r) {
        super();
        radius = r;

    }

    /**
     * This constructor will take in an origin xy pair so that it can be printed out there in a Jpane.
     *
     * @param x This is the x coordinate the user wants the origin for the Circle to be at.
     * @param y This is the y coordinate the user wants the origin for the Circle to be at.
     */
    public Circle(int x, int y) {
        super(x,y);
        radius = 1;
    }

    /**
     * This constructor will give the user the most customization over the circle object, it will implement the super
     * constructor to be able to take in a specific xy coordinate, and let the user specify a radius they want the
     * circle to be.
     *
     * @param x This is the x coordinate the user wants the origin for the Circle to be at.
     * @param y This is the y coordinate the user wants the origin for the Circle to be at.
     * @param r This is the radius the user wants the circle to be.
     */
    public Circle(int x, int y, double r) {
        super(x,y);
        radius = r;
    }

    /**
     * This is a simple setter method for the radius of the Circle, it is not public access because of best practices
     * for privacy leaks.
     *
     * @param radius This is the radius that the program should set the radius of the calling object to.
     */
    private void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * This is a simple getter method for the radius data member for this class.
     *
     * @return The radius of the calling Circle object.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * This will be able to obtain the area of the circle. Using the formula PI(r)^2 = A
     *
     * @return The area of the circle.
     */
    @Override
    public double getArea() {
        return Math.pow(this.radius,2)*Math.PI;
    }

    /**
     * This will simply take in a graphics object so that the circle may be drawn in a JPane. It will simply use the
     * built in draw ellipse function to be able to draw a circle.
     *
     * @param g This is the input graphics object that will allow the shape to be drawn in a Jpane.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor( Color.GREEN );
        g2d.draw( new Ellipse2D.Double(super.getX(), super.getY(),this.getRadius(),this.getRadius()));
    }
}
