/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will represent an ingredient for a pizza.
 *
 * The ingredients are in a hierarchy, as defined by the assignment on the assingment page.
 *
 * This class will hold the description, cost, and calorie count of each ingredient as private vars that should not be
 * edited. The class will contain accessor and mutator methods for the vars and make the class comparable to other
 * ingredients.
 *
 */
public class Ingredient implements Comparable {

    /**
     * The description or name of an ingredient
     */
    private String description;
    /**
     * The cost of an ingredient
     */
    private Money cost;
    /**
     * The calorie count of an ingredient
     */
    private int calorieCount;

    /**
     * The main constructor for the ingredient class.
     *
     * This will initalize all the class scope vars with the params passed to it.
     *
     * @param description Name of the ingredient
     * @param cost Cost of the ingredient
     * @param calorieCount Calories the ingredient holds
     */
    public Ingredient(String description, Money cost, int calorieCount) {
        this.description = description;
        this.cost = (Money)cost.clone();
        this.calorieCount = calorieCount;
    }

    /**
     * Getter for name of the ingredient
     *
     * @return name of the ingredient
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for the name of the ingredient
     *
     * @param description Name that the ingredient should be set too
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the cost of the ingredient
     *
     * @return The cost of the ingredient as a Money object
     */
    public Money getCost() {
        return this.cost;
    }

    /**
     * Setter for the cost of the ingredient
     *
     * @param cost The cost the ingredient should be set too.
     */
    public void setCost(Money cost) {
        this.cost = cost;
    }

    /**
     * Getter for the calorie count of the ingredient
     *
     * @return The calorie count of a specific ingredient
     */
    public int getCalorieCount() {
        return this.calorieCount;
    }

    /**
     * Setter for the calorie count of a specific ingredient
     *
     * @param calorieCount Calorie count the ingredient should be set to.
     */
    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    /**
     * Compares two Ingredients by cost
     *
     * Uses the money classes compareTo method to compare two ingredients by cost.
     *
     * @param o This is the object that will be compared with the calling object
     * @return 1,0,-1 letting the user know if the cost is, greater, equal, or less than the input object
     */
    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) {
            return -1;
        } else {
            Ingredient temp = (Ingredient)o;
            return temp.getCost().compareTo(this.getCost());
        }
    }

    /**
     * Will return the string representation of an ingredient
     *
     * @return The string representation of an ingredient.
     */
    @Override
    public String toString() {
        return "Ingredient: " + this.getDescription() + ", Cost: " + this.getCost().toString()
                + ", Calories: " + this.getCalorieCount();
    }

    /**
     * Tells the user wheather 2 ingredients are equal
     *
     * If the name of the two ingredients are the same, logically they should be the same. So only check this variable.
     *
     * @param obj This is the obj that the ingredient should be compared to.
     * @return The boolean value if the two object are equal or not.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) {
            return false;
        } else {
            Ingredient compareMe = (Ingredient)obj;

            if(this.getDescription() != compareMe.getDescription()) {
                return false;
            }

        }
        return true;
    }
}
