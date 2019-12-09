/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will simply be a connecting class that can be used to classify different "Base" ingredients. It only
 * has one 3 argument constructor because it will be using values from the specific ingredients that inherit from it.
 * For example, Marinara and Alfredo are both Bases so they need to extend this class. The Marinara and Alfredo classes
 * will use this classes triple argument constructor to be able to set their values as ingredients.
 */
public class Base extends Ingredient {
    /**
     * This is the triple argument constructor for the Base class, and the only method the class needs.
     *
     * This class will utilize the Ingredient classes triple argument constructor which will take in the same exact
     * parameters. This class will use this method by getting the arguments passed in from the specific Base
     * ingredients no-arg constructors.
     *
     * @param description This is the description of the specific ingredient that is a Base.
     * @param cost This is the cost of the Base ingredient
     * @param calorieCount This is the calorieCount of the Base ingredient
     */
    public Base(String description, Money cost, int calorieCount) {
        super(description,cost,calorieCount);
    }
}
