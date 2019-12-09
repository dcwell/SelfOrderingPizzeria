/**
 * @author Denali Cornwell
 * @version 2.0, from pizza sim, integrated swap, and set, and generics.
 *
 * This class will act like an ArrayList ADT. It contains all the functions necessary for an ArrayList ADT including
 * the ability to insert a piece of data anywhere in the ArrayList as determined by the user, it will also be able to
 * remove and get data from any active index in the ArrayList. This means that this class and by definition an
 * ArrayList is random access.
 *
 * This class implements a basic 1 dimensional array to store the data entered into the ArrayList, and an integer to
 * represent the amount of active elements. The array will be dynamically resized when the number of active elements
 * exceeds the amount of available spaces inside the array, just like an ArrayList is defined as.
 */
public class ArrayList<T> {
    /**
     * The array that will store all of the data that is added into this ArrayList.
     */
    private Object[] data;

    /**
     * The integer that will keep track of the number of active elements in the ArrayList.
     */
    private int numElements;


    /**
     * The basic no-parameter constructor for this ArrayList class.
     *
     * <p>
     *     This constructor will simply initialize both class-level variables "data" and "numElements" to their starting
     *     conditions, when creating a new ArrayList.
     * </p>
     */
    public ArrayList() {
        this.data = new Object[10];
        this.numElements = 0;
    }

    /**
     * This method will insert any piece of data into the ArrayList at any index given by the user.
     *
     * <p>
     *     This method assumes that the user will have the reason enough to put the data into an index that actually
     *     exists and is active in the ArrayList. The "index" parameter must not exceed numElements or the method will
     *     not work.
     * </p>
     * <p>
     *     This method works by first checking weather or not adding the data to the ArrayList will excede the number
     *     of spaces available in the "data" array. If the number of active elements (as denoted by the class-level
     *     integer numElements) is about to exceed the length value of the array "data", it will resize the data array
     *     to contain more blank spaces for more data. It will resize the array by creating a new array with more spaces
     *     than the data array, implement java's "arraycopy" method to copy all the data from the current "data" array
     *     to the new array, then set the new array with more space to equal the "data" array.
     * </p>
     * <p>
     *     If the array "data" does not need to be resized, OR after the resizing, it will simply use a for loop that
     *     shifts everything in the array from the last active element to the index specified by the user to the "right"
     *     in the "data" array. It will then insert the new data specified by the user into the freed up index where the
     *     user wants to insert the data, and increment numElements by +1 because there is now a single new active
     *     element in the ArrayList.
     * </p>
     * @param in The data that the user wants to put into the ArrayList.
     * @param index The index in the ArrayList that the user wants to put the new data into.
     */
    public void insert(T in, int index) {
        if(this.numElements == this.data.length - 1) {
            Object[] newArry = new Object[this.numElements * 2];

            System.arraycopy(this.data,0,newArry,0, this.data.length);

            this.data = newArry;

            for (int i = this.size(); i >= index; i--) {
                this.data[i + 1] = this.data[i];
            }

            this.data[index] = in;
            this.numElements++;

        } else {

            for (int i = this.size(); i >= index; i--) {
                this.data[i + 1] = this.data[i];
            }

            this.data[index] = in;
            this.numElements++;
        }
    }

    /**
     * This method will add a piece of data to the end of the ArrayList.
     *
     * It will do this by utilizing the insert method and taking in a object of the type parameter that the arrayList
     * was declared with. It will insert at the last index, gotten using the size method so we can insert at the end of
     * the list.
     *
     * @param in This is the object of the arrayLists type parameter we want to add to the end of the ArrayList.
     */
    public void append(T in) {
        this.insert(in, this.size());
    }



    /**
     * This method will remove and return a piece of data from the ArrayList.
     *
     * <p>
     *     This method will accomplish the above task by setting a temporary Object to the data in the index that the
     *     user wishes to remove and return. The program will then loop through the "data" array, from the index
     *     specified by the user to the end of the array and shift all of the elements to the left. This effectively
     *     replaces the index the user wanted to remove with the data directly to its right. It will then increment
     *     numElements by -1 because there is one less active element in the ArrayList now, then it will return the
     *     original value that we saved from the data array.
     * </p>
     * @param index The index at which the user wishes to remove a piece of data from the ArrayList.
     * @return This is the deleted value from the ArrayList the user can use elsewhere.
     */
    public Object remove(int index) {
        Object retVal = this.data[index];

        for(int i = index; i < this.size(); i++) {
            this.data[i] = this.data[i + 1];
        }

        numElements--;
        return retVal;
    }

    /**
     * This method will tell the user the size of the ArrayList.
     *
     * <p>
     *     The method will accomplish this task by simply returning numElements. The reason why it is returning
     *     numElements is because that is the number of active elements there are in the ArrayList. Or in other terms,
     *     that is how many elements are filled with data in the "data" array for this class.
     * </p>
     * @return The number of active elements in the "data" array, which constitutes our ArrayList.
     */
    public int size() {
        return this.numElements;
    }

    /**
     * This method will amalgamate a String based upon the ".toString()" values of the pieces of data in the ArrayList.
     *
     * <p>
     *     The method will accomplish this by using a simple for loop to amalgamate a string to represent a the entire
     *     ArrayList. Inside of the for loop as it iterates through each element in the ArrayList, it calls each
     *     elements toString method and uses the += function to easily add it to the return value. After the loop
     *     concludes it will return the amalgamated string for use elsewhere.
     * </p>
     * @return The string representation of an ArrayList for use elsewhere.
     */
    @Override
    public String toString() {
        String retVal = "";

        for(int i = 0; i < this.size(); i++) {
            retVal += this.data[i].toString() + ", ";
        }

        return retVal;
    }

    /**
     * This function will tell the user if the ArrayList is empty or not.
     *
     * <p>
     *     This function will accomplish this by using a simple if statement. It's based on the .size() method, because
     *     if the size is 0, of course it is empty, if not, it has at least one active element.
     * </p>
     *
     * @return This is the boolean value that will tell the user if the ArrayList is empty or not.
     */
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This fuction will tell the user the index of a specific data value in the ArrayList.
     *
     * <p>
     *     The function accomplishes the goal by looping through each element of the ArrayList and calling each elements
     *     .equals() method. It will check if each element is equal to the input object and return the index value if
     *     it finds a match, otherwise it will return -1 as an "error" code.
     * </p>
     * @param in This is the piece of data the user wants to find in the ArrayList.
     * @return This is the index of the data in the ArrayList.
     */
    public int indexOf(T in) {
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i].equals(in)) {
                return i;
            }
        }

        return -1;
    }


    /**
     * This function will tell the user weather or not two ArrayLists are equal to each other.
     *
     * <p>
     *     This method will accomplish the task by first checking all the "false" statements. So, if the input data is
     *     not an array list, it will return false, but if it is, it moves on to check weather the array list input has
     *     the same size of the one we are calling the method with. If that is also true, it will check each element
     *     in the input ArrayList against the calling ArrayLists elements and if all of those are also equal, then it
     *     will return true because they are exactly the same.
     * </p>
     * @param in This is the Object the user wants to check against the calling ArrayList to see whether it is equal.
     * @return This is the boolean value telling us weather or not the input object is equal to the calling ArrayList.
     */
    public boolean equals(Object in) {
        //CHECK IF ARRAYLIST
        if(this.getClass() != in.getClass()) {

            return false;

        } else {

            ArrayList compare = (ArrayList)in;

            //CHECK IF SAME SIZE
            if(this.size() != compare.size()) {

                return false;

            } else {
                //ITERATE THRU WHOLE ARRAY LIST AND CHECK ELEMENTS AGAINST EACH OTHER
                for (int i = 0; i < this.size(); i++) {

                    //CHECK FOR SAME KIND OF THING
                    if(this.data[i].getClass() != compare.data[i].getClass()) {
                        return false;
                    } else {
                        //CHECK IF THE THINGS ARE EQUAL TO EACH OTHER
                        if(!this.data[i].equals(compare.data[i])) {
                            return false;
                        }
                    }
                }
            }
        }
        //IF ALL CONDITIONS PASS FOR ALL OF BOTH ARRAYLISTS
        return true;
    }

    /**
     * This is a simple getter method that will return a specific piece of data contained in the ArrayList at a
     * specific index.
     *
     * <p>
     *     It simply does this by returning the data at the user input index.
     * </p>
     * @param index The index of the element the user wants to return for use elsewhere.
     * @return The data that is in the index the user requested as a param.
     */
    public T get(int index) {
        //return (T)this.data[index];
        T obj = (T) data[index];
        return obj;
    }

    /**
     * This method allows a certian element in the ArrayList to be set to a specific value
     *
     * It simply sets it to the param value. Considering the param is of T type.
     *
     * @param index The index that should be changed
     * @param in The object of type T that the index should be.
     */
    public void set(int index, T in) {
        this.data[index] = in;
    }

    /**
     * This will swap to elements in the ArrayList
     *
     * Simply uses the get and set methods already defined to swap the elements. Creates a temp var so that we dont
     * loose the data for an element, this is neccary in swapping because we need to retain the values for both of the
     * swapped elements
     * @param min Min index as defined by Selection Sort
     * @param current current index as defined by Selection Sort
     */
    public void swap(int min, int current) {

        T smallest = this.get(min);
        this.set(min, this.get(current));
        this.set(current, smallest);


    }

    /**
     * Random testing stuff I was doing
     *
     * @param args n/a
     */
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.append(4);
        intList.append(5);
        intList.append(6);
        System.out.println(intList.toString());
        intList.swap(0,1);
        System.out.println(intList.toString());

    }
}
