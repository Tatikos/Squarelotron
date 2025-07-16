package hw4.squarelotron;

/**
 * The LargeSquarelotron class extends the Squarelotron class and provides
 * additional functionality.
 */
public class LargeSquarelotron extends Squarelotron {
	/**
	 * Constructor for the LargeSquarelotron class.
	 * 
	 * @param array An array of integers to initialize the LargeSquarelotron.
	 */
	public LargeSquarelotron(int[] array) {
		super((int) Math.sqrt(array.length));
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.squarelotron[i][j] = array[count++];
			}
		}
	}

	/**
	 * Returns a flattened array of the LargeSquarelotron.
	 * 
	 * @return An array of integers.
	 */
	@Override
	public int[] numbers() {
		int k = 0;
		int[] num = new int[this.size * this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				num[k] = squarelotron[i][j];
				k++;
			}
		}
		return num;

	}

	/**
	 * Performs an upside-down flip on the LargeSquarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new LargeSquarelotron that is the result of the flip.
	 */
	@Override
	public Squarelotron upsideDownFlip(String ring) {
		if (!(ring.equals("outer") || ring.equals("inner"))) {
			throw new IllegalArgumentException(ring + " is not a valid ring");
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(new int[25]);
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				newSquarelotron.squarelotron[i][j] = this.squarelotron[i][j];
			}
		}
		if (ring.equals("outer")) {
			int start = 0;
			int end = this.size - 1;

			for (int j = start; j <= end; j++) {
				int temp = newSquarelotron.squarelotron[start][j];
				newSquarelotron.squarelotron[start][j] = newSquarelotron.squarelotron[end][j];
				newSquarelotron.squarelotron[end][j] = temp;
			}

			int temp = newSquarelotron.squarelotron[1][0];
			newSquarelotron.squarelotron[1][0] = newSquarelotron.squarelotron[3][0];
			newSquarelotron.squarelotron[3][0] = temp;
			temp = newSquarelotron.squarelotron[1][4];
			newSquarelotron.squarelotron[1][4] = newSquarelotron.squarelotron[3][4];
			newSquarelotron.squarelotron[3][4] = temp;

		} else if (ring.equals("inner")) {
			int start = 1;
			int end = this.size - 2;

			for (int j = start; j <= end; j++) {
				int temp = newSquarelotron.squarelotron[start][j];
				newSquarelotron.squarelotron[start][j] = newSquarelotron.squarelotron[end][j];
				newSquarelotron.squarelotron[end][j] = temp;
			}
		}
		return newSquarelotron;
	}

	/**
	 * Performs an inverse diagonal flip on the LargeSquarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new LargeSquarelotron that is the result of the flip.
	 */
	@Override
	public Squarelotron inverseDiagonalFlip(String ring) {
		if (!(ring.equals("outer") || ring.equals("inner"))) {
			throw new IllegalArgumentException(ring + " is not a valid ring");
		}
		int[][] inv = new int[this.squarelotron.length][this.squarelotron.length];
		for (int i = 0; i < this.squarelotron.length; i++) {
			for (int j = 0; j < this.squarelotron.length; j++) {
				inv[i][j] = this.squarelotron[i][j];
			}
		}
		if (ring.equals("outer")) {
			int size = this.squarelotron.length;
			for (int i = 0; i < size; i++) {

				int temp = inv[0][i];
				inv[0][i] = inv[i][size - 1];
				inv[i][size - 1] = temp;

				temp = inv[i][0];
				inv[i][0] = inv[size - 1][size - 1 - i];
				inv[size - 1][size - 1 - i] = temp;
			}
			int temp = inv[0][1];
			inv[0][1] = inv[0][3];
			inv[0][3] = temp;
			temp = inv[3][4];
			inv[3][4] = inv[1][4];
			inv[1][4] = temp;
		}

		if (ring.equals("inner")) {
			int temp = inv[1][1];
			inv[1][1] = inv[3][3];
			inv[3][3] = temp;
			temp = inv[1][2];
			inv[1][2] = inv[2][3];
			inv[2][3] = temp;
			temp = inv[2][1];
			inv[2][1] = inv[3][2];
			inv[3][2] = temp;

		}
		int[] flat = new int[25];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				flat[i * 5 + j] = inv[i][j];
			}
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(flat);
		return newSquarelotron;
	}

	/**
	 * Performs a left-right flip on the LargeSquarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new LargeSquarelotron that is the result of the flip.
	 */
	@Override
	public Squarelotron leftRightFlip(String ring) {
		if (!(ring.equals("outer") || ring.equals("inner"))) {
			throw new IllegalArgumentException(ring + " is not a valid ring");
		}
		int[][] zazaza = new int[5][5];
		for (int i = 0; i < this.squarelotron.length; i++) {
			for (int j = 0; j < this.squarelotron.length; j++) {
				zazaza[i][j] = this.squarelotron[i][j];
			}
		}
		if (ring.equals("inner")) {
			for (int i = 1; i < this.squarelotron.length - 1; i++) {

				int temp = zazaza[i][1];
				zazaza[i][1] = zazaza[i][this.squarelotron.length - 2];
				zazaza[i][this.squarelotron.length - 2] = temp;
			}
			for (int i = 2; i < this.squarelotron.length - 2; i++) {

				int temp = zazaza[i][2];
				zazaza[i][2] = zazaza[i][this.squarelotron.length - 3];
				zazaza[i][this.squarelotron.length - 3] = temp;
			}
		} else if (ring.equals("outer")) {
			for (int i = 0; i < this.squarelotron.length; i++) {

				int temp = zazaza[i][0];
				zazaza[i][0] = zazaza[i][this.squarelotron.length - 1];
				zazaza[i][this.squarelotron.length - 1] = temp;
			}

			int temp = zazaza[0][1];
			zazaza[0][1] = zazaza[0][this.squarelotron.length - 2];
			zazaza[0][this.squarelotron.length - 2] = temp;

			temp = zazaza[this.squarelotron.length - 1][1];
			zazaza[this.squarelotron.length - 1][1] = zazaza[this.squarelotron.length - 1][this.squarelotron.length
					- 2];
			zazaza[this.squarelotron.length - 1][this.squarelotron.length - 2] = temp;
		}
		int[] flat = new int[25];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				flat[i * 5 + j] = zazaza[i][j];
			}
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(flat);
		return newSquarelotron;
	}

	/**
	 * Performs a main diagonal flip on the LargeSquarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new LargeSquarelotron that is the result of the flip.
	 */
	@Override
	public Squarelotron mainDiagonalFlip(String ring) {
		if (!(ring.equals("outer") || ring.equals("inner"))) {
			throw new IllegalArgumentException(ring + " is not a valid ring");
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(new int[25]);
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				newSquarelotron.squarelotron[i][j] = this.squarelotron[i][j];
			}
		}
		if (ring.equals("outer")) {
			int[] temp = new int[this.squarelotron.length * 4 - 4];
			int index = 0;
			for (int i = 0; i < this.squarelotron.length; i++) {
				temp[index++] = squarelotron[i][0];
			}
			for (int i = 1; i < this.squarelotron.length; i++) {
				temp[index++] = squarelotron[this.squarelotron.length - 1][i];
			}
			for (int i = this.squarelotron.length - 2; i >= 0; i--) {
				temp[index++] = squarelotron[i][this.squarelotron.length - 1];
			}
			for (int i = this.squarelotron.length - 2; i > 0; i--) {
				temp[index++] = squarelotron[0][i];
			}
			index = 0;
			for (int i = 0; i < this.squarelotron.length; i++) {
				newSquarelotron.squarelotron[0][i] = temp[index++];
			}
			for (int i = 1; i < this.squarelotron.length; i++) {
				newSquarelotron.squarelotron[i][this.squarelotron.length - 1] = temp[index++];
			}
			for (int i = this.squarelotron.length - 2; i >= 0; i--) {
				newSquarelotron.squarelotron[this.squarelotron.length - 1][i] = temp[index++];
			}
			for (int i = this.squarelotron.length - 2; i > 0; i--) {
				newSquarelotron.squarelotron[i][0] = temp[index++];
			}
		} else if (ring.equals("inner")) {
			int[] temp = new int[(this.squarelotron.length - 2) * 4];
			int index = 0;
			for (int i = 1; i < this.squarelotron.length - 1; i++) {
				temp[index++] = squarelotron[i][1];
			}
			for (int i = 2; i < this.squarelotron.length - 1; i++) {
				temp[index++] = squarelotron[this.squarelotron.length - 2][i];
			}
			for (int i = this.squarelotron.length - 3; i > 0; i--) {
				temp[index++] = squarelotron[i][this.squarelotron.length - 2];
			}
			for (int i = this.squarelotron.length - 3; i > 1; i--) {
				temp[index++] = squarelotron[1][i];
			}
			index = 0;
			for (int i = 1; i < this.squarelotron.length - 1; i++) {
				newSquarelotron.squarelotron[1][i] = temp[index++];
			}
			for (int i = 2; i < this.squarelotron.length - 1; i++) {
				newSquarelotron.squarelotron[i][this.squarelotron.length - 2] = temp[index++];
			}
			for (int i = this.squarelotron.length - 3; i > 0; i--) {
				newSquarelotron.squarelotron[this.squarelotron.length - 2][i] = temp[index++];
			}
			for (int i = this.squarelotron.length - 3; i > 1; i--) {
				newSquarelotron.squarelotron[i][1] = temp[index++];
			}
		}
		return newSquarelotron;
	}

	/**
	 * Checks if this LargeSquarelotron is equal to another object.
	 * 
	 * @param object The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (object == null || !(object instanceof LargeSquarelotron)) {
			return false;
		}
		LargeSquarelotron other = (LargeSquarelotron) object;
		if (this.size != other.size) {
			return false;
		}
		return equalsHelper(other);
	}

	private boolean equalsHelper(Squarelotron other) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.squarelotron[i][j] != other.squarelotron[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Rotates the LargeSquarelotron to the right.
	 * 
	 * @param numberOfTurns The number of 90 degree turns to rotate.
	 */
	@Override
	public void rotateRight(int numberOfTurns) {
		if (numberOfTurns == -1) {
			numberOfTurns = 3;
		} else {
			numberOfTurns = numberOfTurns % 4;
		}
		numberOfTurns = numberOfTurns % 4;
		for (int k = 0; k < numberOfTurns; k++) {
			int[][] newMatrix = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					newMatrix[j][size - 1 - i] = squarelotron[i][j];
				}
			}
			squarelotron = newMatrix;
		}
	}

	/**
	 * Returns a string representation of the LargeSquarelotron.
	 * 
	 * @return A string representing the LargeSquarelotron.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sb.append(squarelotron[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Performs a side flip on the Squarelotron.
	 * 
	 * <p>
	 * If the side is "left", it switches the first and second columns. If the side
	 * is "right", it switches the last and second to last columns. If the side is
	 * "top", it switches the first and second rows. If the side is "bottom", it
	 * switches the last and second to last rows.
	 *
	 * @param side A string indicating which side to flip. It can be "left",
	 *             "right", "top", or "bottom".
	 * @return A new Squarelotron that is the result of the flip.
	 */
	@Override
	public Squarelotron sideFlip(String side) {
		if (!(side.equals("left") || side.equals("right") || side.equals("bottom") || side.equals("top"))) {
			throw new IllegalArgumentException(side + " is not a valid side");
		}
		int[][] inv = new int[this.squarelotron.length][this.squarelotron.length];
		for (int i = 0; i < this.squarelotron.length; i++) {
			for (int j = 0; j < this.squarelotron.length; j++) {
				inv[i][j] = this.squarelotron[i][j];
			}
		}
		if (side.equals("left")) {
			for (int i = 0; i < size; i++) {
				inv[i][0] = squarelotron[i][1];
				inv[i][1] = squarelotron[i][0];
			}
		} else if (side.equals("right")) {
			for (int i = 0; i < size; i++) {
				inv[i][size - 1] = squarelotron[i][size - 2];
				inv[i][size - 2] = squarelotron[i][size - 1];
			}
		} else if (side.equals("top")) {
			inv[0] = squarelotron[1];
			inv[1] = squarelotron[0];
		} else if (side.equals("bottom")) {
			inv[size - 1] = squarelotron[size - 2];
			inv[size - 2] = squarelotron[size - 1];
		}
		int[] flat = new int[size * size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				flat[i * size + j] = inv[i][j];
			}
		}
		LargeSquarelotron newSquarelotron = new LargeSquarelotron(flat);
		return newSquarelotron;
	}
}
