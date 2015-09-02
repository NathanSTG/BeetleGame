/**
 * Represents an integer that increments within a range of values,
 * resetting to the lower limit after the higher limit is reached.
 * @author NH029825
 *
 */
public class LimitedIncrementer {
	
	int lowerLimit, higherLimit, value;
	boolean first = true;
	
	/**
	 * Creates a new LimitedIncrementer with an initial valu eequal to the lower limit.
	 * @param lowerLimit
	 * @param higherLimit
	 */
	public LimitedIncrementer(int lowerLimit, int higherLimit){
		this(lowerLimit, higherLimit, lowerLimit);
	}
	
	/**
	 * Creates a new LimitedIncrementer with the specified values.
	 * @param lowerLimit
	 * @param higherLimit
	 * @param initialValue
	 */
	public LimitedIncrementer(int lowerLimit, int higherLimit, int initialValue){
		this.lowerLimit = lowerLimit;
		this.higherLimit = higherLimit;
		this.value = initialValue;
	}
	
	/**
	 * Increments the value, returning to the lower
	 * limit if the higher limit will be surpassed.
	 * @return The next value of the incrementer.
	 */
	public int getAndIncrement(){
		if(first){
			first = false;
			return value;
		}
		value++;
		if(value > higherLimit){
			value = lowerLimit;
		}
		return value;
	}
	
	public int getValue(){
		return value;
	}
}
