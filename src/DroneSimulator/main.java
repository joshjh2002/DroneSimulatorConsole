package DroneSimulator;

/**
 * main class which cannot be instantiated, responsible for starting up the
 * program
 * 
 * @author joshh
 *
 */
abstract public class main {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Drone drone1 = new Drone(5,3); System.out.print(drone1.toString() + "\n");
		 *
		 * Drone drone2 = new Drone(5,3); System.out.print(drone2.toString());
		 */

		/*
		 * DroneArena arena1 = new DroneArena(20, 10); arena1.addDrone();
		 * System.out.print(arena1.toString());
		 */

		DroneInterface droneInterface = new DroneInterface();
		// ConsoleCanvas c = new ConsoleCanvas(10,6);
	}

}
