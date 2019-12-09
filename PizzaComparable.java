/* 
 * CSS 162, Pizza Manager Project
 * 
 * This interface can do everything the Comparable interface can and more
 * 
 * Author: Rob Nash with minor edits by Johnny Lin
 */
public interface PizzaComparable extends Comparable {  
                                        //Example of interface inheritance

	/**
	 * Will require that the class have a compare method
     *
	 * @param o The object to be compared
	 * @return 1,0,-1 denoting if the object is greater, equal, or less than the calling object
	 */
	@Override
	public int compareTo(Object o);          //a.k.a compareToByPrice

	//non-overrides

    /**
     * Will require that the class has a compare to by size method
     *
     * @param o this is the object to be compared
     * @return 0,1,-1 telling the user if the calling object is equal, less, or greater than the input object
     */
	public int compareToBySize(Object o);    //a.k.a. compareToByAreaLeft

    /**
     * Will require that the class has a compare to by calorie method
     *
     * @param o this is the object to be compared
     * @return 0,1,-1 telling the user if the calling object is equal, less, or greater than the input object
     */
    public int compareToByCalories(Object o);
	
}
