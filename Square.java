import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will represent a square shape with a certain side length. It includes, getters and setters for the
 * sideLength and be able to set up the square at a specific x and y coordinate. It will also include a method that
 * will be able to draw the square out in a jPane.
 */
public class Square extends Shape {
    /**
     * This is the side length of the square.
     */
    private double sideLength;

    /**
     * This is the no arg constructor for the Square class.
     *
     * It simply initializes the sideLength variable to 1 and uses the default super class Shape's no-arg constructor
     * to set the x and y.
     */
    public Square() {
        super();
        this.sideLength = 1;

    }

    /**
     * This constructor will take in a side length variable.
     *
     * This will initialize the classes side length variable to the input side length. And use the super classes
     * constructor to set the x and y vars.
     *
     * @param sideLength The value we want the side length to be.
     */
    public Square(double sideLength) {
        super();
        this.sideLength = sideLength;

    }

    /**
     * This constructor will take in two params an x and y coordinate.
     *
     * This will set the x and y vars by passing them to the super classes 2 arg constructor. It will also set the
     * side length variable to default 1.
     *
     * @param x This is the x var that the Square object should be set to.
     * @param y This is the y var that the Square object should be set to.
     */
    public Square(int x, int y) {
        super(x,y);
        this.sideLength = 10;
    }

    /**
     * This is the most comprehensive and customizable constructor in the square class.
     *
     * It will allow the user to set the x,y, and side length for the square. It too will use the super classes
     * constructor to set the x and y coords for the square, but it will also take in a side length variable which the
     * classes side length will be initialized too.
     *
     * @param x This is the x var that the Square object should be set to.
     * @param y This is the y var that the Square object should be set to.
     * @param sideLength The value we want the side length to be.
     */
    public Square(int x, int y, double sideLength) {
        super(x,y);
        this.sideLength = sideLength;
    }

    /**
     * This is the setter for the side length variable.
     *
     * This setter is very simple and just require the input of a double to change the sideLength of the square
     *
     * @param sideLength This is the double we want the sideLength to be set to.
     */
    private void setsideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * This is the getter for the side length var
     *
     * This getter will be very simple and just return the double known as sideLength
     *
     * @return This is the sideLength variable for the Square class.
     */
    public double getsideLength() {
        return this.sideLength;
    }

    /**
     * This will get the area of the square.
     *
     * This method simply return the side length squared because that is the formula for finding the area of a square.
     *
     * @return This is the area of the Square being represented by the calling object.
     */
    @Override
    public double getArea() {
        return Math.pow(this.sideLength,2);
    }

    /**
     * This is the draw function that will draw the Square.
     *
     * This method implements the Graphics class in java and its subsequent rectangle2D class to draw a "rectangle" with
     * all equal side lengths.
     *
     * @param g This is the graphics object needed as input to draw the square.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor( Color.GREEN );
        g2d.draw(new Rectangle2D.Double(super.getX(),super.getY(),getsideLength(),getsideLength()));
    }
}
