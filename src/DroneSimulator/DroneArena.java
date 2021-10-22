package DroneSimulator;

import java.util.*;

public class DroneArena {
	int xSize, ySize;
	List<Drone> drones;
	Random randomGenerator = new Random();

	public DroneArena(int x, int y) {
		xSize = x;
		ySize = y;
		drones = new ArrayList();
		for (int i = 0; i < 5; i++)
			addDrone();
	}

	public void addDrone() {
		if (drones.size() < xSize * ySize) {
			Drone newDrone = new Drone(randomGenerator.nextInt(xSize - 1), randomGenerator.nextInt(ySize - 1),
					randomGenerator.nextInt(4));

			while (getDroneAt(newDrone.x, newDrone.y) != null) {
				newDrone.x = randomGenerator.nextInt(xSize);
				newDrone.y = randomGenerator.nextInt(ySize);
			}

			drones.add(newDrone);

		}
	}

	public Drone getDroneAt(int x, int y) {
		for (int i = 0; i < drones.size(); i++) {
			if (drones.get(i).isHere(x, y)) {
				return drones.get(i);
			}
		}
		return null;
	}

	public String toString() {
		String ret = "Arena Size = " + xSize + " x " + ySize + ".\n";

		for (int i = 0; i < drones.size(); i++) {
			ret += drones.get(i).toString() + "\n";
		}

		return ret;
	}

	public void showDrones(ConsoleCanvas c) {
		for (int i = 0; i < drones.size(); i++) {
			if (c.map[drones.get(i).x + 2][drones.get(i).y + 2] != 'D')
				drones.get(i).DisplayDrone(c);
			else {
				drones.get(i).direction += 1;
				if (drones.get(i).direction == 4)
					drones.get(i).direction = 0;
				drones.get(i).DisplayDrone(c);
			}
		}
	}

}
