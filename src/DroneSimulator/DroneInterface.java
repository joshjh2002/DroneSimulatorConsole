package DroneSimulator;

import java.util.*;

public class DroneInterface {

	Scanner scanner;
	DroneArena droneArena;

	public DroneInterface() throws InterruptedException {
		char option = ' ';
		scanner = new Scanner(System.in);
		droneArena = new DroneArena(20, 6);
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
		while (true) {
			DoDisplay();
			Thread.sleep(200);
		}
	}

	public void DoDisplay() {
		ConsoleCanvas c = new ConsoleCanvas(droneArena.xSize, droneArena.ySize);
		droneArena.showDrones(c);
		System.out.print(c.toString());
	}

}
