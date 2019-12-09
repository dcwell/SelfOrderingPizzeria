/**
 * @author Denali Cornwell
 * @version 1.0
 *
 * This class will represent a literal fraction. In a fraction orientation "x/y". It has the
 * ability to reduce any fraction and change any part of it. To reduce a fraction it implements
 * a recursive GCD algorithm.
 */
public class Fraction implements Comparable {
    /**
     * These 2 values represent the numerator and denominator of a fraction respectively.
     */
    private double num, denom;

    /**
     * This is the basic constructor to initalize both class level variables when creating a
     * new Fraction2 object.
     */
    public Fraction() {
        this.num = 0;
        this.denom = 0;
    }


    /**
     * This is the constructor that sets a Fracttion2 object to a specific fraction and reduces it
     * <p>
     *     This class simply initializes both class level variables with the input doubles representing
     *     the numerator and denominator respectively.
     * </p>
     * @param num The value the user wants the numerator to be.
     * @param denom The value the user wants the denominator to be.
     */
    public Fraction(double num, double denom) {
        this.num = num;
        this.denom = denom;
        this.reduce();
    }

    /**
     * This method is used to reduce a fraction using the GCD of the 2 class level variables.
     * <p>
     *     This accomplishes the task by using the GCD method to obtain the GCD for the numerator and
     *     denominator. It then sets the numerator and denominator to the reduced values by dividing
     *     both the numerator and denominator by the gcd.
     * </p>
     */
    public void reduce() {
        double gcd = gcd(this.num, this.denom);
        this.num = this.num / gcd;
        this.denom = this.denom / gcd;
    }

    /**
     * This method is used to see weather 2 Fraction2 objects are equal to each other.
     * <p>
     *     This method accomplishes the task by taking in another fraction object and
     *     comparing its numerator and denominator with the this fractions numerator and
     *     denominator by using the accessor methods for numerator and denominator to get
     *     the values from the input Fraction2 object
     * </p>
     * @param in This is the Fraction2 object that the user wants to compare to the current Fraction2
     *           object
     * @return This is the boolean value telling the user weather they are in fact equal.
     */
    public boolean equals(Fraction in) {
        if (this.num == in.getNum() && this.denom == in.getDenom()) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * This is a gcd formula that will be used to reduce fractions.
     * <p>
     *     This function uses recursion to accomplish this task. It will take in
     *     2 double values, a numerator and denominator in this case. If the denominator
     *     is 0, which it should never be, it will simply return the numerator so that the
     *     program does not break itself. Otherwise the function will call itself with the
     *     denominator taking the place of the numerator and taking the mod of the numerator
     *     and denominator as the new denominator, effectively acting as the quotient of the
     *     numerator and denominator.
     * </p>
     * @param num The users input numerator
     * @param denom The users input denominator
     * @return The double that is the GCD of the numerator and denominator of the fraction.
     */
    public double gcd(double num, double denom) {
        if (denom == 0) {
            return num;
        } else {
            return gcd(denom,num % denom);
        }

    }


    /**
     * This is simply a toString to represent a fraction properly.
     *
     * @return The properly represented fraction.
     */
    @Override
    public String toString() {
        return this.num + "/" + this.denom;
    }


    /**
     * Simply a set function that will set completely new values for both the numerator
     * and denominator.
     * @param num The number the user wants this Fraction2 objects numerator to be.
     * @param denom The number the user wants this Fraction2 objects denominator to be.
     */
    public void setFraction(double num, double denom) {
        this.num = num;
        this.denom = denom;
    }

    /**
     * Simply an accessor for the private denominator of this class
     *
     * @return The current denominator.
     */
    public double getDenom() {
        return denom;
    }

    /**
     * Simply an accessor for the private numerator of this class.
     *
     * @return The current numerator.
     */
    public double getNum() {
        return num;
    }

    /**
     * Simply a mutator for the current denominator.
     *
     * @param denom The value that the user wants this Fraction2 objects denominator to be.
     */
    public void setDenom(double denom) {
        this.denom = denom;
    }

    /**
     * Simply a mutator for the current denominator.
     *
     * @param num The value that the user wants this Fraction2 objects numerator to be.
     */
    public void setNum(double num) {
        this.num = num;
    }

    /**
     * Compares two fractions
     *
     * Will compare two fractions and return 1,0, or -1 to tell the user if the fraction input is greater, equal, or
     * less than the calling fraction. Does this by first making the fractions have a common denominator then comparing
     * the numerator to each other to see if they are equal or not.
     *
     * @param o The object to be compared with the calling fraction
     * @return 1,0, or -1 telling the user if the input fraction is greater, equal to, or lesser than the calling.
     */
    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) {
            return -1;
        } else {
            Fraction temp = (Fraction)o;
            if(this.equals(temp)) {
                return 0;
            }

            double commonDenominator = this.getDenom() * temp.getDenom();

            double awnserNumerator = (this.getNum() * temp.getDenom()) - (temp.getNum() * this.getDenom());

            if(awnserNumerator < 0) {
                return -1;
            }
        }
        return 1;
    }
}
