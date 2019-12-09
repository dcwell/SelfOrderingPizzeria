import java.awt.Color;

/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will simply be a connecting class that can be used to classify different "Vegetable" ingredients. It only
 * has one 3 argument constructor because it will be using values from the specific ingredients that inherit from it.
 * For example, Pepper and Olive are both Vegetable so they need to extend this class. The Pepper and Olive classes
 * will use this classes triple argument constructor to be able to set their values as ingredients.
 *
 * This class will have the special property of a Color variable that will denote the Color of a vegetable, it will
 * have its own setters and getters here so that the color may be mutated or accessed for use elsewhere. It will also
 * have its own equals method because if we want to compare two vegetables, then we must use the color value as well as
 * the price, cost or calorie count.
 */
public class Vegetable extends Ingredient{
    /**
     * This is the color of the vegetable ingredient.
     */
    private Color color;

    /**
     * This is the quad argument constructor for the Vegetable class, and the only method the class needs.
     *
     * This class will utilize the Ingredient classes triple argument constructor which will take in the same exact
     * parameters. AS WELL AS setting the color of the vegetable This class will use this method by getting the
     * arguments passed in from the specific Vegetable ingredients no-arg constructors.
     *
     * @param description This is the description of the specific ingredient that is a Vegetable.
     * @param cost This is the cost of the Vegetable ingredient
     * @param calorieCount This is the calorieCount of the Vegetable ingredient
     * @param color This is the color of the Vegetable ingredient
     */
    public Vegetable(String description, Money cost, int calorieCount, Color color) {
        super(description, cost, calorieCount);
        this.color = color;
    }

    /**
     * This is the triple argument constructor for the Vegetable class.
     *
     * This is important because in case a vegetable ingredient doesn't have a color or doesn't need a color, we can
     * still use that ingredient in the ingredient list of a pizza.
     *
     * @param description This is the description of the specific ingredient that is a Vegetable.
     * @param cost This is the cost of the Vegetable ingredient
     * @param calorieCount This is the calorieCount of the Vegetable ingredient
     */
    public Vegetable(String description, Money cost, int calorieCount) {
        super(description, cost, calorieCount);
        this.color = null;
    }

    /**
     * This is the getter method for the color variable of a specific vegetable ingredient.
     *
     * This is a simple getter method that will return the color object being used as the color for some vegetable
     * ingredient.
     *
     * @return This is the color object being used as the color for some variable.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * This is the setter method for the color variable of a specific vegetable ingredient.
     *
     * This method will set the color variable to a new color object that will be input into this method.
     *
     * @param color This is the color that the vegetable ingredient's color should be changed to
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * This is the modified toString method, specific to vegetable ingredients
     *
     * This method will simply use the super class ingredient's toString and simply append the color classes toString
     * to the end of the String output by the super classes toString method.
     *
     * @return The string representation of a vegetable ingredient.
     */
    @Override
    public String toString() {
        return super.toString() + " Color: " + this.color.toString();
    }

    /**
     * This is the revised equals method for vegetable ingredients
     *
     * This method will use the super class Ingredients equals method and if that is true, check if the unique color
     * variable is the same as the input.
     *
     * @param obj This is the input object that will be checked against the calling object.
     * @return This is the boolean value telling us if the two object are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            Vegetable compareMe = (Vegetable)obj;
            if(this.color.equals(compareMe.color)) {
                return true;
            }
        }
        return false;
    }
}
