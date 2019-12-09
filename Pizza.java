/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will represent a pizza.
 *
 * It will be able to generate a random pizza, as well as store values for the properties of a pizza including the
 * ingredients list, calorie count, cost, shape, and remaining fraction left of the particular pizza. It will contain
 * methods that will allow a user to create a random pizza, get and set all the class scope vars, add an ingredient,
 * eat some of the pizza in question, and compare the pizza to other pizzas by calorie count, price, and size.
 */
public class Pizza implements PizzaComparable {
    /**
     * This is the ingredients list for a pizza
     */
    private ArrayList ingredients;
    /**
     * This is the total calories for the pizza
     */
    private int calories;
    /**
     * This is the cost of the pizza
     */
    private Money cost;
    /**
     * This is the shape of the pizza
     */
    private Shape shape;
    /**
     * This is the remaining fraction of the pizza.
     */
    private Fraction remaining;


    /**
     * This is the no arg constructor for the Pizza class
     *
     * It will be able to create a random pizza for use elsewhere. The pizza may have up to 5 ingredients.
     * It will either be a square or circle, and the inital amount will be 1/1 because it is a whole pizza.
     *
     */
    public Pizza() {
        this.ingredients = new ArrayList();
        this.calories = 0;
        this.cost = new Money();
        this.shape = new Shape();
        this.remaining = new Fraction(1,1);

        int whatShape = 1 + (int)(Math.random() * ((2 - 1) + 1));
        int whatSize = 5 + (int)(Math.random() * ((30 - 5) + 5));

        if(whatShape == 1) {
            this.shape = new Circle(whatSize);
        } else {
            this.shape = new Square(whatSize);
        }


        int howManyIngredients = 1 + (int)(Math.random() * ((5 - 1) + 1));

        for(int i = 1; i <= howManyIngredients; i++) {
            int whichIngredient = 1 + (int)(Math.random() * ((8 - 1) + 1));
            switch (whichIngredient) {
                case 1:
                    addIngredient(new Mozzarella());
                    break;
                case 2:
                    addIngredient(new Goat());
                    break;
                case 3:
                    addIngredient(new Pepperoni());
                    break;
                case 4:
                    addIngredient(new Sausage());
                    break;
                case 5:
                    addIngredient(new Marinara());
                    break;
                case 6:
                    addIngredient(new Alfredo());
                    break;
                case 7:
                    addIngredient(new Pepper());
                    break;
                case 8:
                    addIngredient(new Olive());
                    break;
                default:
                    throw new PizzaException("Invalid Ingredient");
            }
        }
    }

    /**
     * Gets the Fraction that is remaining.
     *
     * @return The fraction representing how much of the pizza has not been eaten
     */
    public Fraction getRemaining() {
        return this.remaining;
    }

    /**
     * This will set the remaining amount of a pizza
     *
     * @param remaining The remaining about that the pizza should be changed to
     */
    public void setRemaining(Fraction remaining) {
        this.remaining = remaining;
    }

    /**
     * This will return the cost of the pizza
     *
     * @return The Money object that is the cost of the pizza
     */
    public Money getCost() {
        return this.cost;
    }

    /**
     * This will return the calories for the pizza
     *
     * @return The integer value for the calories.
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * This will return the remaining area of the pizza
     *
     * The remaining area will use the shape classes area function
     *
     * @return The remaining area of the pizza as a double
     */
    public double getRemainingArea() {
        return (this.getRemaining().getNum() / this.getRemaining().getDenom()) * this.shape.getArea();
    }

    /**
     * Sets the shape of the pizza
     *
     * @param s Shape the pizza should be set to
     */
    public void setShape(Shape s) {
        this.shape = (Shape) s.clone();
    }

    /**
     * Gets the shape of the pizza.
     *
     * Uses clone to avoid privacy leaks
     *
     * @return The shape of the pizza
     */
    public Shape getShape() {
        return (Shape) this.shape.clone();
    }

    public void addIngredient(Ingredient a) {
        this.calories += a.getCalorieCount();
        this.getCost().add(a.getCost().getDollars(), a.getCost().getCents());
        this.ingredients.insert(a,ingredients.size());
    }

    /**
     * Allows user to eat some pizza
     *
     * If the remaining area of a pizza is 0 then the the pizza can no longer be consumed. If its anything else,
     * the fraction that is input will be subtracted with the fraction for the remaining area that is already present.
     * If the difference in negative then the user cannot eat that amount, but if its positive, the fraction for the
     * calling object will be set to the difference, and of course reduced. And so will the remaining total area.
     *
     * @param amt This is the fraction that the user wants to eat.
     * @throws PizzaException if the user cant eat the pizza
     * @throws ArithmeticException if the differece of the two fractions is negative
     */
    public void eatSomePizza(Fraction amt) throws PizzaException, ArithmeticException {
        if(this.getRemainingArea() == 0) {
            throw new PizzaException("Already ate this whole pizza.");
        }

        double commonDenominator = this.getRemaining().getDenom() * amt.getDenom();

        double awnserNumerator = (this.getRemaining().getNum() * amt.getDenom()) - (amt.getNum() * this.getRemaining().getDenom());

        if(awnserNumerator < 0) {
            throw new ArithmeticException("Not enough pizza in this pizza for your specified eating amt");
        }

        if(awnserNumerator == 0) {
            this.setRemaining(new Fraction());
        }

        this.setRemaining(new Fraction(awnserNumerator, commonDenominator));
    }

    /**
     * Returns string value of a pizza
     *
     * @return The string representing the calling pizza
     */
    @Override
    public String toString() {
        return "Pizza has a price: " + this.getCost().toString() +
                " and calories: " + this.getCalories() + " ," +
                " Fraction remaining: " + this.getRemaining().toString() +
                " and area left: " + this.getRemainingArea() + " and shape: " +
                this.getShape().toString();
    }


    /**
     * Compares pizzas by cost.
     *
     * Will first compare classes, then compare using the get method for the private instance vars for cost of a
     * pizza to see weather the input pizza is less, greater, or equal to that of the calling pizza.
     *
     * @param o The object that will be compared
     * @return 1,0,-1 denoting more, equal, or less than calling object
     */
    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) {
            return -1;
        } else {
            Pizza temp = (Pizza)o;
            return this.getCost().compareTo(temp.getCost());
        }
    }


    /**
     * Compares pizzas by calorie counts.
     *
     * Will first compare classes, then compare using the get method for the private instance vars for calories of a
     * pizza to see weather the input pizza is less, greater, or equal to that of the calling pizza.
     *
     * @param o The object that will be compared
     * @return 1,0,-1 denoting more, equal, or less than calling object
     */
    @Override
    public int compareToByCalories(Object o) {
        if(o.getClass() != this.getClass()) {
            return -1;
        } else {
            Pizza temp = (Pizza)o;

            if(temp.getCalories() < this.getCalories()) {
                return -1;
            }
            if(temp.getCalories() > this.getCalories()) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * This method will compare two pizzas by the remaining area.
     *
     * It first compares classes, then uses the remaining area method to test if the remaining area is great, less, or
     * equal to that of the calling object
     *
     * @param o The object to be compared with the calling object
     * @return Integer -1,0, or 1 denoting if the pizza is greater, less, or equal to in size of another pizza
     */
    @Override
    public int compareToBySize(Object o) {
        if(o.getClass() != this.getClass()) {
            return -1;
        } else {
            Pizza temp = (Pizza)o;

            if(temp.getRemainingArea() < this.getRemainingArea()) {
                return -1;
            }
            if(temp.getRemainingArea() > this.getRemainingArea()) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Some random testing I was doing
     *
     * @param args n/a
     */
    public static void main(String[] args) {
        Pizza a = new Pizza();
        System.out.println(a.toString());
        a.eatSomePizza(new Fraction( 1, 4));
        System.out.println(a.toString());




    }
}

