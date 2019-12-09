/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will represent the value of an ingredient for a pizza. Namely, "Pepperoni" base. It will not be able
 * to be edited because there is no point to edit it, we always want it to have the same name, calorie count, and
 * money value. It only contains a no argument constructor that utilizes the super class Base's constructor which will
 * when called, invoke the ingredient classes constructor and set the "Pepperoni" ingredients private name, cost and
 * calorie count.
 */
public class Pepperoni extends Meat {
    /**
     * This is the no-args constructor for the Pepperoni class
     *
     * This utilizes the super class "Meat" triple argument constructor, and then the ingredient classes triple argument
     * constructor which will initialize its private variables which will not be able to be edited. These vars will
     * not be able to be changed because they are explicitly set when this classes constructor is called.
     */
    public Pepperoni() {
        super("Pepperoni", new Money(3,15), 250);
    }
}
