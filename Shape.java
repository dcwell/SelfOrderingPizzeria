import java.awt.*;

/** Class Shape
 *
 * @author Rob Nash
 *
 * CODE BY DENALI CORNWELL
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)
class Shape extends Object implements Cloneable {
    /**
     * This is the x coordinate where the shape will be printed in a JPANE
     */
    private int x;
    /**
     * This is the y coordinate where the shape will be printed in a JPANE
     */
	private int y;

	/**
	 * This is the no arg constructor for the Shape class.
     *
     * It will tell the console where to print a shape in a JPane using x and y coordinates which this constructor will
     * automatically initialize as 0.
	 */
	public Shape() {
		x=0;
		y=0;
	}

    /**
     * This is a 2 arg constructor for the Shape class.
     *
     * It will take in 2 ints which will denote where to print a object in a JPane
     *
     * @param a This is the x value where we want to print the Shape
     * @param b This is the y value where we want to print the Shape
     */
	public Shape( int a, int b ) {
		x=a;
		y=b;
	}

    /**
     * This is the area function that will need to be redefined with overrides in every shape subclass.
     *
     * @return This is the double for the area of a shape.
     */
	public double getArea(){ return -1; }

    /**
     * This is similar to the getArea, It will need to be redefined for every specific shape.
     *
     * @param g This is the input graphics object which will allow the shape to be output in a JPane.
     */
	public void draw( Graphics g ){}

    /**
     * This is a simple getter for the y variable.
     *
     * It will return the value of y.
     *
     * @return The value of y
     */
	public int getX() { return x; }

    /**
     * This is a simple getter for the x variable.
     *
     * It will return the value of x.
     *
     * @return The value of x
     */
	public int getY() { return y; }

    /**
     * This is the toString for shape classes.
     *
     * This function will print out the name of the shape its being called upon.
     *
     * @return This is the string name of the shape calling object.
     */
    @Override
    public String toString() {
	    return this.getClass().toString().substring(6);
    }

    /**
     * This is a clone method for the Shape class.
     *
     * It will implement the object classes clone method because all data in the class is primitive and we don't
     * need to worry about copying mutable classes insecurely here. It has a tryCatch block to deal with a
     * cloning error if it arises so it doesn't have to be dealt with later.
     *
     * @return This is the shape object that has been cloned (copied).
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}