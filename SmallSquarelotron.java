package hw4.squarelotron;

/**
 * The SmallSquarelotron class extends the Squarelotron class and represents a
 * 4x4 Squarelotron.
 */
public class SmallSquarelotron extends Squarelotron {
	/**
	 * Constructs a new SmallSquarelotron with the given array. The array is
	 * expected to have 16 elements.
	 *
	 * @param array the array to use for the initial state of the Squarelotron
	 */
	public SmallSquarelotron(int[] array) {
		super((int) Math.sqrt(array.length));
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.squarelotron[i][j] = array[count++];
			}
		}
	}

	/**
	 * Returns a 1D array representation of the Squarelotron.
	 *
	 * @return a 1D array representation of the Squarelotron
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
	 * Performs an upside-down flip on the Squarelotron.
	 *
	 * @param ring the ring to perform the flip on ("inner" or "outer")
	 * @return a new Squarelotron that is the result of the flip
	 */
	@Override
	public Squarelotron upsideDownFlip(String ring) {
		if (!(ring.equals("outer") || ring.equals("inner"))) {
			throw new IllegalArgumentException(ring + " is not a valid ring");
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(new int[16]);
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				newSquarelotron.squarelotron[i][j] = this.squarelotron[i][j];
			}
		}
		if (ring.equals("inner")) {
			int start = 1;
			int end = this.size - 2;
			for (int i = start; i <= end; i++) {
				for (int j = start; j <= end; j++) {
					newSquarelotron.squarelotron[i][j] = this.squarelotron[end - i + start][j];
				}
			}
		} else if (ring.equals("outer")) {
			int start = 0;
			int end = this.size - 1;
			for (int j = start; j <= end; j++) {

				int temp = newSquarelotron.squarelotron[start][j];
				newSquarelotron.squarelotron[start][j] = newSquarelotron.squarelotron[end][j];
				newSquarelotron.squarelotron[end][j] = temp;
			}
			int i = 1;
			for (int j = 0; j < this.size; j += 3) {
				int temp = newSquarelotron.squarelotron[i][j];
				newSquarelotron.squarelotron[i][j] = newSquarelotron.squarelotron[i + 1][j];
				newSquarelotron.squarelotron[i + 1][j] = temp;

			}
		}
		return newSquarelotron;
	}

	/**
	 * Performs an inverse diagonal flip on the Squarelotron.
	 *
	 * @param ring the ring to perform the flip on ("inner" or "outer")
	 * @return a new Squarelotron that is the result of the flip
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
			int temp = inv[1][3];
			inv[1][3] = inv[2][3];
			inv[2][3] = temp;
			temp = inv[0][1];
			inv[0][1] = inv[0][2];
			inv[0][2] = temp;
		} else if (ring.equals("inner")) {
			int temp = inv[1][1];
			inv[1][1] = inv[2][2];
			inv[2][2] = temp;
		}
		int[] flat = new int[16];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				flat[i * 4 + j] = inv[i][j];
			}
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(flat);
		return newSquarelotron;
	}

	/**
	 * Performs a left-right flip on the Squarelotron.
	 *
	 * @param ring the ring to perform the flip on ("inner" or "outer")
	 * @return a new Squarelotron that is the result of the flip
	 */
	@Override
	public Squarelotron leftRightFlip(String ring) {
		if (!(ring.equals("outer") || ring.equals("inner"))) {
			throw new IllegalArgumentException(ring + " is not a valid ring");
		}
		int[][] zazaza = new int[4][4];
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
		} else if (ring.equals("outer")) {
			for (int i = 0; i < this.squarelotron.length; i++) {

				int temp = zazaza[i][0];
				zazaza[i][0] = zazaza[i][this.squarelotron.length - 1];
				zazaza[i][this.squarelotron.length - 1] = temp;
			}
		}
		int[] flat = new int[16];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				flat[i * 4 + j] = zazaza[i][j];
			}
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(flat);
		return newSquarelotron;
	}

	/**
	 * Performs a main diagonal flip on the Squarelotron.
	 *
	 * @param ring the ring to perform the flip on ("inner" or "outer")
	 * @return a new Squarelotron that is the result of the flip
	 */
	@Override
	public Squarelotron mainDiagonalFlip(String ring) {
		if (!(ring.equals("outer") || ring.equals("inner"))) {
			throw new IllegalArgumentException(ring + " is not a valid ring");
		}
		int[][] inv = new int[this.squarelotron.length][this.squarelotron.length];
		for (int i = 0; i < this.squarelotron.length; i++) {
			for (int j = 0; j < this.squarelotron.length; j++) {
				inv[i][j] = this.squarelotron[i][j];
			}
		}
		if (ring == "outer") {
			int[] temp = new int[this.squarelotron.length * 4 - 4];
			int index = 0;
			for (int i = 0; i < this.squarelotron.length; i++) {
				temp[index++] = inv[i][0];
			}
			for (int i = 1; i < this.squarelotron.length; i++) {
				temp[index++] = inv[this.squarelotron.length - 1][i];
			}
			for (int i = this.squarelotron.length - 2; i >= 0; i--) {
				temp[index++] = inv[i][this.squarelotron.length - 1];
			}
			for (int i = this.squarelotron.length - 2; i > 0; i--) {
				temp[index++] = inv[0][i];
			}
			index = 0;
			for (int i = 0; i < this.squarelotron.length; i++) {
				inv[0][i] = temp[index++];
			}
			for (int i = 1; i < this.squarelotron.length; i++) {
				inv[i][this.squarelotron.length - 1] = temp[index++];
			}
			for (int i = this.squarelotron.length - 2; i >= 0; i--) {
				inv[this.squarelotron.length - 1][i] = temp[index++];
			}
			for (int i = this.squarelotron.length - 2; i > 0; i--) {
				inv[i][0] = temp[index++];
			}
		} else if (ring == "inner") {
			int temp = inv[1][2];
			inv[1][2] = inv[2][1];
			inv[2][1] = temp;
		}
		int[] flat = new int[16];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				flat[i * 4 + j] = inv[i][j];
			}
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(flat);
		return newSquarelotron;
	}

	/**
	 * Checks if this Squarelotron is equal to the given object.
	 *
	 * @param object the object to compare this Squarelotron to
	 * @return true if the object is a Squarelotron and its state is equal to this
	 *         Squarelotron's state, false otherwise
	 */
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (object == null || !(object instanceof SmallSquarelotron)) {
			return false;
		}
		SmallSquarelotron other = (SmallSquarelotron) object;
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
	 * Rotates the Squarelotron to the right the given number of turns.
	 *
	 * @param numberOfTurns the number of turns to rotate the Squarelotron (can be
	 *                      negative)
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
	 * Returns a string representation of the Squarelotron.
	 *
	 * @return a string representation of the Squarelotron
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
		int[] flat = new int[16];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				flat[i * 4 + j] = inv[i][j];
			}
		}
		SmallSquarelotron newSquarelotron = new SmallSquarelotron(flat);
		return newSquarelotron;

	}
}
