package DroneSimulator;

public class Drone {
	static int lastID = 0;
	int x, y, id;
	int direction;

	public Drone(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		direction = dir;
		// lastID++;
		id = ++lastID;
	}

	public boolean isHere(int sx, int sy) {
		if (sx == x && sy == y) {
			return true;
		}
		return false;
	}

	public String toString() {
		String ret = "Drone " + id + " is at position (" + x + ", " + y + ")";
		return ret;
	}

	public void DisplayDrone(ConsoleCanvas c) {
		switch (direction) {
		case 0:
			if (y > -1)
				y -= 1;
			else
				direction = 1;
			break;
		case 1:
			if (x < c.x - 2)
				x += 1;
			else 
				direction = 2;
			break;
		case 2:
			if (y < c.y - 2)
				y += 1;
			else
				direction = 3;
			break;
		case 3:
			if (x > -1)
				x -= 1;
			else 
				direction = 0;
			break;

		}
		c.showIt(x, y);
	}
}
