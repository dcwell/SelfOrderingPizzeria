import java.util.Scanner;

/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will be the controller of all of the classes in the pizza sim HW.
 *
 * It will create an interface for the user so that the user may eat, add, and sort pizzas by a bunch of different
 * ways to their hearts content.
 *
 * It will use a single arrayList of pizzas to keep all the users pizzas in line.
 */
public class PizzaManager {

    /**
     * This is the arrayList containing all of the pizzas
     */
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    
    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {

        
        Scanner foo = new Scanner(System.in);
        char selection;

        boolean quit = false;

        while(!quit) {
            displayAllPizzas();
            displayInstructions();

            selection = foo.next().charAt(0);
            
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                addRandomPizza();
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                for(int i = 0; i < 100; i++) {
                                    addRandomPizza();
                                }
                                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                                if(this.pizzas.size() == 0) {
                                    System.out.println("You dont have any pizzas");
                                    break;
                                }
                                Scanner getFraction = new Scanner(System.in);
                                try {
                                    eatSomePizza(getFraction);
                                } catch (ArithmeticException e) {
                                    System.out.println(e);
                                } catch (PizzaException a) {
                                    System.out.println(a);
                                }
                                break;
                case 'P':
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                                sortByPrice();
                                System.out.println("EXCEUTED");
                                break;
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                                 sortBySize();
                                 break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                                 sortByCalories();
                                 break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                                int target = foo.nextInt();
                                System.out.println("Searching for your calorie count");
                                int index = binarySearchByCalories(target);
                                if(index == -1) {
                                    System.out.println("Calorie count not found");
                                } else {
                                    System.out.println("Calorie count found at: " + index);
                                }
                                break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                                quit = true;
                                break;

                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * Allows user to eat some pizza at a specified index
     *
     * Will use the eat some pizza method from the pizza class to eat some pizza at a specified index. It will take in
     * a scanner that will allow the user to input a fraction so they can eat however much they want of the pizza they
     * want to eat.
     *
     * @param keys Scanner that allows user input
     */
    private void eatSomePizza(Scanner keys) {
        String initial = keys.nextLine();
        String[] parts = initial.split("/");
        Fraction currentFraction = new Fraction(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
        System.out.println("At what index?");
        Pizza beingEaten = (Pizza)this.pizzas.get(keys.nextInt());
        try {
            beingEaten.eatSomePizza(currentFraction);
            if(beingEaten.getRemaining().equals(new Fraction(0,1))) {
                this.pizzas.remove(0);
            }
        } catch (PizzaException e) {
            System.out.println(e);
        }

    }

    /**
     * Adds a random pizzas to the pizzas ArrayList
     *
     * Simply invokes the pizza classes no arg constructor which will generate a random pizza.
     */
    private void addRandomPizza() {
        this.pizzas.append(new Pizza());
    }

    /**
     * Displays all the pizzas in the Pizzas arrayList
     *
     * Loops through the arrayList and toStrings all the elements and prints them out.
     */
    private void displayAllPizzas() {
        for(int i = 0; i < this.pizzas.size(); i++) {
            System.out.println(this.pizzas.get(i).toString());
        }
    }

    /**
     * Sort pizzas by cost in pizzas ArrayList
     *
     * Sorts pizzas in the pizzas arrayList by their total cost using selection sort.
     */
    public void sortByPrice() {
        for (int i = 0; i < this.pizzas.size() - 1; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < this.pizzas.size(); ++j) {
                if (this.pizzas.get(j).compareTo(this.pizzas.get(minIndex)) < 0) {
                    minIndex = j;
                }

            }
            this.pizzas.swap(minIndex ,i);

        }
    }

    /**
     * Sort pizzas by size in the pizzas ArrayList
     *
     * Sorts pizzas in the pizza arrayList by their size using selection sort.
     */
    private void sortBySize() {
        for (int i = 0; i < this.pizzas.size() - 1; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < this.pizzas.size(); ++j) {
                if (this.pizzas.get(j).getRemainingArea() < this.pizzas.get(minIndex).getRemainingArea()) {
                    minIndex = j;
                }

            }
            this.pizzas.swap(minIndex,i);
        }
    }

    /**
     * Sort pizzas by calories in the pizzas ArrayList
     *
     * Sorts pizzas in the pizza arrayList by their calorie counts using selection sort.
     */
    private void sortByCalories() {
        for (int i = 0; i < this.pizzas.size() - 1; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < this.pizzas.size(); ++j) {
                if (this.pizzas.get(j).getCalories() < this.pizzas.get(minIndex).getCalories()) {
                    minIndex = j;
                }

            }
            this.pizzas.swap(minIndex ,i);
        }
    }

    /**
     * Searches the pizzas ArrayList to find a pizza with the specified calorie count.
     *
     * Uses the binary search algorithm as generally defined by computer scientists.
     *
     * @param cals This is the calorie count specified by the user that they want to search for
     * @return The index at which the calorie count was found at
     */
    private int binarySearchByCalories(int cals) {
        sortByCalories();
        int low = 0;
        int high = pizzas.size() -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            Pizza a = this.pizzas.get(mid);
            int comparison = a.getCalories() - cals;

            if (comparison == 0) return mid;
            else if (comparison < 0) low = mid +1;
            else high = mid -1;
        }

        return -1;
    }
    
    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
