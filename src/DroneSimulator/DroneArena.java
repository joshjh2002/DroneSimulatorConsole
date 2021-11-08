package DroneSimulator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Holds all drones in a list
 * 
 * @author joshh
 *
 */
public class DroneArena implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7162694793744161960L;
	int xSize, ySize;
	List<Drone> drones;
	private Random randomGenerator = new Random();

	/**
	 * Creates a new drone area of size x, y and will add a single drone to the
	 * arena
	 * 
	 * @param x - the length of the arena
	 * @param y - the height of the arena
	 */
	public DroneArena(int x, int y) {
		xSize = x;
		ySize = y;
		drones = new ArrayList<>();
		//for (int i = 0; i < 10; i++)
			addDrone();
	}

	/**
	 * Adds a new drone to the list at a random location.
	 */
	public void addDrone() {
		// if there are more drones than cells, then it will not add a new drone
		if (drones.size() < xSize * ySize) {
			// creates a new drone at a random position
			Drone newDrone = new Drone(randomGenerator.nextInt(xSize - 3) + 1, randomGenerator.nextInt(ySize - 3) + 1,
					Direction.getRandom());

			// makes sure that the position is not already used by a drone, if so
			// it will continue to make generate new coordinates until it has found
			// a space
			while (getDroneAt(newDrone.getX(), newDrone.getY()) != null) {
				newDrone.setX(randomGenerator.nextInt(xSize));
				newDrone.setY(randomGenerator.nextInt(ySize));
			}

			// finally adds drone to list
			drones.add(newDrone);

		}
	}

	/**
	 * Will cycle through all drones currently in the list and return the drone that
	 * is at that position.
	 * 
	 * @param x position at which wish to check for drone
	 * @param y position at which wish to check for drone
	 * @return The drone at position (x, y). Null if there is no drone.
	 */
	public Drone getDroneAt(int x, int y) {
		for (Drone drone : drones) {
			if (drone.isHere(x, y)) {
				return drone;
			}
		}
		return null;
	}

	/**
	 * Adds all drones to the canvas.
	 * 
	 * @param c - The canvas to which you wish to print the drones.
	 */
	public void showDrones(ConsoleCanvas c) {
		for (Drone drone : drones) {
			if (c.map[drone.getX() + 2][drone.getY() + 2] == 'D') {

				// if a drone is currently in the position of another drone, the it will change
				// it's direction and move it there
				drone.setDirection(Direction.getNext(drone.getDirection()));

			}
			drone.DisplayDrone(c);
		}
	}

	/**
	 * returns a string representation of the drone arena. It contains all the
	 * drones, their IDs and their position
	 */
	@Override
	public String toString() {
		String ret = "Arena Size = " + xSize + " x " + ySize + ".\n";

		for (Drone drone : drones) {
			ret += drone.toString() + "\n";
		}

		return ret;
	}

}
