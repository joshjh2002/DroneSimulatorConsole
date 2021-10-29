package DroneSimulator;

/**
 * @author joshh
 *
 */
public class ConsoleCanvas {
	char map[][];
	int x, y;

	/**
	 * Creates a new canvas
	 * 
	 * @param x length of the canvas
	 * @param y width of the canvas
	 */
	public ConsoleCanvas(int x, int y) {
		this.x = x;
		this.y = y;

		/*
		 * initialises the map (the size if +2 on both axis to add room for the border
		 */
		map = new char[x + 2][y + 2];

		/* adds # to show the border */
		for (int i = 0; i < x + 2; i++) {
			for (int i2 = 0; i2 < y + 2; i2++) {
				if (i == 0 || i2 == 0 || i == x + 1 || i2 == y + 1) {
					map[i][i2] = '#';
				} else {
					map[i][i2] = ' ';
				}
			}
		}
	}

	/**
	 * puts a D for Drone at the coordinates passed in (adds 2 to each to compensate
	 * for the borders).
	 * 
	 * @param x position of the drone you wish to print to the screen
	 * @param y position of the drone you wish to print to the screen
	 */
	public void showIt(int x, int y) {
		map[x + 2][y + 2] = 'D';
	}

	/**
	 * Converts the map to a string and returns the string
	 */
	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < y + 2; i++) {
			for (int i2 = 0; i2 < x + 2; i2++) {

				ret += map[i2][i];

			}
			ret += "\n";
		}
		return ret;
	}

}
