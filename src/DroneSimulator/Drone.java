package DroneSimulator;

/**
 * Class used to instantiate a drone
 * 
 * @author joshh
 *
 */
public class Drone {

	static int lastID = 0;
	private int x, y, id, direction;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @param x   coordinate at which you wish to place a drone
	 * @param y   coordinate at which you wish to place a drone
	 * @param dir in which you wish to make the drone move
	 */
	public Drone(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		direction = dir;
		// lastID++;
		id = ++lastID;
	}

	/**
	 * Will draw the drone to the canvas and rotate the drone clockwise
	 * 
	 * @param c - The canvas to which you wish to print the drones.
	 */
	public void DisplayDrone(ConsoleCanvas c) {

		if (direction == Direction.North.ordinal())
			if (y > -1)
				y -= 1;
			else
				direction = Direction.East.ordinal();
		else if (direction == Direction.East.ordinal())
			if (x < c.x - 2)
				x += 1;
			else
				direction = Direction.South.ordinal();
		else if (direction == Direction.South.ordinal())
			if (y < c.y - 2)
				y += 1;
			else
				direction = Direction.West.ordinal();
		else if (direction == Direction.West.ordinal())
			if (x > -1)
				x -= 1;
			else
				direction = Direction.North.ordinal();

		// calls the showIt function and passes in the coordinates of the drone
		c.showIt(x, y);
	}

	/**
	 * Will return true if the coordinates passed in are the same as the ones stored
	 * in the class
	 * 
	 * @param sx - x position you wish to check for a drone.
	 * @param sy - y position you wish to check for a drone.
	 * @return True if this drone is at position (sx, sy). False if the drone is not
	 *         at the position (sx, sy).
	 */
	public boolean isHere(int sx, int sy) {
		if (sx == x && sy == y) {
			return true;
		}
		return false;
	}

	/**
	 * Gets a string representation of the drone
	 */
	@Override
	public String toString() {
		String ret = "Drone " + id + " is at position (" + x + ", " + y + ")";
		return ret;
	}
}
