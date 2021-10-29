package DroneSimulator;

import java.util.Scanner;

/**
 * This class is responsible for displaying the drone arena
 * 
 * @author joshh
 *
 */
public class DroneInterface {

	Scanner scanner;
	DroneArena droneArena;

	public DroneInterface() throws InterruptedException {
		// char option = ' ';
		// scanner = new Scanner(System.in);
		/*
		 * while (option != 'X') { System.out.
		 * print("Enter:\n   'A': Add Drone\n   'P': Print\n   'X': Exit\n   'S': Show Drones\n> "
		 * ); String input = scanner.next();
		 *
		 * input = input.toUpperCase();
		 *
		 * option = input.charAt(0);
		 *
		 * scanner.nextLine();
		 *
		 * switch (option) { case 'A': droneArena.addDrone(); break; case 'P':
		 * System.out.print(droneArena.toString()); break; case 'S': DoDisplay(); break;
		 * } }
		 *
		 * scanner.close();
		 */

		// Creates a new arena and will continue to call DoDisplay which is the function
		// responsible for actually drawing each drone to the canvas
		droneArena = new DroneArena(20, 6);
		while (true) {
			DoDisplay();
			Thread.sleep(200);
		}
	}

	
	/**
	 * Draws all the drones to the screen
	 */
	public void DoDisplay() {
		// Each frame requires a new canvas of the same size as the arena
		ConsoleCanvas c = new ConsoleCanvas(droneArena.xSize, droneArena.ySize);

		// calls showDrone in the DroneArena class (will draw each done to the canvas at
		// their position)
		droneArena.showDrones(c);

		// will print the canvas to the screen using it's toString function
		System.out.print(c.toString());
	}

}
