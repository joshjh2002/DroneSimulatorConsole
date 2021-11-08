package DroneSimulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

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
		char option = ' ';
		scanner = new Scanner(System.in);

		// This allows the user to select new simulation or load one from a file of
		// their choosing
		while (true) {
			System.out.print("Enter:\n   'N': New Simulation\n   'L': Load\n> ");
			String input = scanner.next();

			input = input.toUpperCase();

			option = input.charAt(0);

			scanner.nextLine();

			// if the user creates a new game, it will set up a new arena and allow them to
			// input the size of it
			if (option == 'N') {
				System.out.print("Insert the X size: ");
				int x = scanner.nextInt();

				System.out.print("Insert the Y size: ");
				int y = scanner.nextInt();

				droneArena = new DroneArena(x, y);
				break;
			}
			// the user can choose to load a previously saved file
			else if (option == 'L') {
				Load();
				break;
			}
		}

		// once the use has selected a new game or to load one, they will be brought to
		// this menu where they can add new drones, save, display next frame and print
		// the drone data
		while (option != 'X') {
			System.out.print(
					"Enter:\n   'A': Add Drone\n   'P': Print\n   'N': Next Frame\n   'S': Save\n   'X': Exit\n> ");
			String input = scanner.next();

			input = input.toUpperCase();

			option = input.charAt(0);

			scanner.nextLine();

			switch (option) {
			case 'A':
				droneArena.addDrone();
				break;
			case 'P':
				System.out.print(droneArena.toString());
				break;
			case 'N':
				DoDisplay();
				break;
			case 'S':
				Save();
				break;
			}
		}

		scanner.close();

		// Creates a new arena and will continue to call DoDisplay which is the function
		// responsible for actually drawing each drone to the canvas
		/*
		 * droneArena = new DroneArena(20, 6); while (true) { DoDisplay();
		 * Thread.sleep(200);
		 */
	}

	private void Load() {
		// create a chooser obejct that will allow the user to choose where they saved
		// their simulation to
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(chooser);

		// it will try to load the file and cast it to a DroneArena, if this fails, then
		// the program will terminate
		try {
			File file = chooser.getSelectedFile();

			if (!file.exists()) {
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			droneArena = (DroneArena) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// will save the simulation in its current state to a file of the users choice
	private void Save() {
		try {
			// chooser will allow you to save the file to the location you wish
			JFileChooser chooser = new JFileChooser();
			chooser.showSaveDialog(chooser);

			File file = chooser.getSelectedFile();

			if (!file.exists()) {
				file.createNewFile();
			}

			// the arena and all its drones will be written to the selected file in a
			// serialised form. If it fails, the program will terminate
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream ous = new ObjectOutputStream(fos);
			ous.writeObject(droneArena);
			ous.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Draws all the drones to the screen
	 */
	public void DoDisplay() {
		for (int i = 0; i < 10; i++) {
			// Each frame requires a new canvas of the same size as the arena
			ConsoleCanvas c = new ConsoleCanvas(droneArena.xSize, droneArena.ySize);

			// calls showDrone in the DroneArena class (will draw each done to the canvas at
			// their position)
			droneArena.showDrones(c);

			// will print the canvas to the screen using it's toString function
			System.out.print(c.toString());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
