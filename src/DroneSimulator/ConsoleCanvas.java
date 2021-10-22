package DroneSimulator;

public class ConsoleCanvas {
	char map[][];
	int x, y;

	public ConsoleCanvas(int x, int y) {
		this.x = x;
		this.y = y;
		map = new char[x + 2][y + 2];

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

	public void showIt(int x, int y) {
		map[x + 2][y + 2] = 'D';
	}

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
