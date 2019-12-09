import java.io.Serializable;

/**
 * @author Denali Cornwell
 * @version 2.0, from "revisiting HW"
 *
 * Changes include making all "copy constructed" deep copies clones, and making the class implement Cloneable,
 * Comparable, and Serializable.
 *
 * This class will act as a literal "dollar and cent amount" in the format "dollar.cents". It will do this by
 * implementing two class-scope integers that will act as a dollar and cent amount respectively. The cent amount will
 * never be able to exceed 99 because you may not have more than 99 partials to a dollar, as in cents cannot equal 100
 * because it would simply be equal to another dollar. This class will also be able to compare two dollar and cent
 * amounts and tell the user if they are equal. Also this class will have NO public setters because it would be illegal
 * in this implementation to change the value of someones money for a bill or other use.
 */
public class Money implements Comparable, Cloneable, Serializable {

    /**
     * These are simply the integer values representing dollars and cents respectively.
     */
    private int dollars, cents;

    /**
     * This is the default no arg constructor for the Money class. it will initialize both class-level data items to 0.
     */
    public Money() {
        this.dollars = 0;
        this.cents = 0;
    }

    /**
     * This is a basic constructor for the Money class that will make a new Money object with an initial dollar amount.
     *
     * @param dollars This is the initial dollar amount that the user wants to have the new Money object equal.
     */
    public Money(int dollars) {
        if (dollars < 0) {
            this.setDollars(0);
            System.out.println("Input dollars cannot be negative! Dollars set default to 0!");
        }
        this.setDollars(dollars);
        this.setCents(0);
    }

    /**
     * This is another constructor for the Money class that will take in an initial dollar and cent amount.
     *
     * @param dollars This is the initial dollar amount that the user wants to have the new Money object equal.
     * @param cents This is the initial cent amount that the user wants to have the new Money object equal.
     */
    public Money(int dollars, int cents) {
        if(dollars < 0) {
            this.dollars = 0;
            System.out.println("Input dollars cannot be negative! But still setting your cent value!");
            this.setCents(cents);
        } else if (cents < 0) {
            this.cents = 0;
            System.out.println("Input cents cannot be negative!");
        } else if(cents > 99) {
            int tempDollars = cents / 100;
            int tempCents = cents % 100;
            this.setMoney(dollars + tempDollars, tempCents);
        } else {
            this.setMoney(dollars, cents);
        }
    }

    /**
     * This is a copy constructor for the Money class.
     *
     * @param other The Money object the user wants to copy.
     */
    public Money(Money other) {
        this.setMoney(other.getDollars(), other.getCents());
    }

    /**
     * This is a simple getter method for the class-scope variable cents.
     *
     * @return The cent value for the calling Money object.
     */
    public int getCents() {
        return this.cents;
    }

    /**
     * This is a simple getter method for the class-scope variable dollars.
     *
     * @return The dollar value for the calling Money object.
     */
    public int getDollars() {
        return this.dollars;
    }

    /**
     * This is the setter method for the current cent value of the calling Money object.
     *
     * @param cents This is the cent value the user wants the cent value in the calling object to be.
     */
    private void setCents(int cents) {
        if (cents < 0) {
            System.out.println("Input cents cannot be negative!");
        } else if (cents > 99) {
            int tempDollars = cents / 100;
            int tempCents = cents % 100;
            this.dollars = dollars + tempDollars;
            this.cents = tempCents;
        } else {
            this.cents = cents;
        }
    }

    /**
     * This is the setter method for the current dollar value of the calling Money object.
     *
     * @param dollars This is the dollar value the user wants the calling objects dollar value to be set to.
     */
    private void setDollars(int dollars) {
        if (dollars < 0) {
            this.dollars = 0;
            System.out.println("Input cents cannot be negative!");
        } else {
            this.dollars = dollars;
        }
    }

    /**
     * This method will be able to set BOTH class data items to specific value, it is private because it is a setter
     * and we do not want anyone calling it outside of this class.
     *
     * @param dollars Input dollars that the user wants dollars to be changed to.
     * @param cents Input cents that the user wants cents to be changed to.
     */
    private void setMoney(int dollars, int cents) {
        if(dollars < 0) {
            this.setDollars(0);
            System.out.println("Input dollars cannot be negative!");
        } else if (cents < 0) {
            this.setCents(0);
            System.out.println("Input cents cannot be negative!");
        } else if(cents > 99) {
            int tempDollars = cents / 100;
            int tempCents = cents % 100;
            this.setDollars(dollars + tempDollars);
            this.setCents(tempCents);
        } else {
            this.setDollars(dollars);
            this.setCents(cents);
        }
    }

    /**
     * This is a simple getter method for the total money amount of the calling Money object.
     *
     * @return This is the total money amount of the calling Money object.
     */
    public double getMoney() {
        return (double)this.getDollars() + ((double)this.getCents() / 100);
    }

    /**
     * This method will add a user defined amount of dollars to the calling objects dollar amount.
     *
     * @param dollars This is the user defined dollar amount to be added to the calling Money object.
     */
    public void add(int dollars) {
        if(dollars < 0) {
            System.out.println("Input dollars cannot be negative!");
        } else {
            Money deepCopy = new Money(this);
            deepCopy.setDollars(deepCopy.getDollars() + dollars);
            this.setDollars(deepCopy.getDollars());
        }
    }

    /**
     * This method will add a user defined amount of dollars and cents to the calling objects class-scope vars.
     *
     * @param dollars The user defined dollar amount to be added to the calling Money object.
     * @param cents The user defined cent amount to be added to the calling Money object.
     */
    public void add(int dollars, int cents) {
        if (dollars < 0) {
            System.out.println("Cannot add a negative dollar amount!");
        } else if (cents < 0) {
            System.out.println("Cannot add a negative dollar amount! But dollars still added!");
            this.add(dollars);
        } else {
            int tempCents = this.getCents() + cents;
            if (tempCents > 99) {
                this.add(dollars);
                this.setCents(tempCents);
            } else {
                this.add(dollars);
                this.setCents(tempCents);
            }
        }
    }

    /**
     * This method will return a properly formatted String to represent a money value for the calling Money object.
     *
     * @return The String representing the Money value for the calling Money object.
     */
    @Override
    public String toString() {
        //Money deepCopy = new Money(this);
        return "$" + this.getMoney();
    }

    /**
     * This method will check to see if one money instance is equal to another.
     *
     * @param obj the object passed to the method by the user for comparison.
     * @return This is the boolean value telling the user weather the object passed to the method by the user is equal
     * to the calling Money object or not.
     */
    @Override
    public boolean equals(Object obj) {
         if(this.getClass() != obj.getClass()) {
             return false;
         } else {
             Money compareMe = (Money)obj;

             if(this.getMoney() == compareMe.getMoney()) {
                 return true;
             } else {
                 return false;
             }

         }
    }

    /**
     * This is the compareTo method for the Money class.
     *
     * It will compare 2 Money objects and logically order them, returning an integer to state if the calling object is
     * more than, equal to, or less than the input money object. It will return 1, 0, or -1 respectively.
     *
     * This method will be useful when we are using sorting algorithms because it will be able to tell the algorithm if
     * an object is greater than or less than the calling objects so that the algorithm know when to swap things.
     *
     * @param o The input object the calling object should be compared to.
     * @return The integer, -1, 0, or 1 that will denote if the input object is less than, equal to, or more than the
     * calling object respectively.
     */
    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) {
            return -1;
        } else {
            Money compareMe = (Money) o;

            if(this.getMoney() > compareMe.getMoney()) {
                return 1;
            }

            if(this.getMoney() < compareMe.getMoney()) {
                return -1;
            }

        }
        return 0;
    }

    /**
     * Some random testing I was doing.
     *
     * @param args n/a
     */
    public static void main(String[] args) {
        Money a = new Money(2,3);
        System.out.println(a.toString());

        Money b = new Money(2, 4);
        System.out.println(b.toString());

        System.out.println(a.compareTo(b));
    }

    /**
     * This is the clone method the Money class agrees to redefine as it implements the cloneable interface.
     *
     * This basically works just like a copy constructor would except it returns a Object type which needs to be casted
     * to a Money class if you want to compare it or have it be seen as a regular Date object. It simply uses the Object
     * super classes clone function. It will not create any privacy leaks because it is only copying immutable types.
     *
     * @return The object containing all the data of the Money object that the clone was called upon.
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
