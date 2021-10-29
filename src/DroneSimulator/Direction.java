package DroneSimulator;

import java.util.Random;

/**
 * Enumerator to define direction of drone
 * 
 * @author joshh
 *
 */
public enum Direction {
	North, East, South, West;
	
	public static int getRandom()
	{
		Random rnd = new Random();
		return rnd.nextInt(4);
	}
	
	public static int getNext(int current)
	{
		current++;
		if (current > West.ordinal())
		{
			current = North.ordinal();
		}
		return current;
	}
}
