

/**
 * The Squarelotron class represents a square matrix and provides methods for
 * various transformations.
 */
public abstract class Squarelotron {
	public int size;
	public int[][] squarelotron;

	/**
	 * Constructor for the Squarelotron class.
	 * 
	 * @param size The size of the square matrix.
	 */
	public Squarelotron(int size) {
		this.size = size;
		this.squarelotron = new int[size][size];
		int count = 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.squarelotron[i][j] = count++;
			}
		}
	}

	/**
	 * Creates a new Squarelotron from an array of integers.
	 * 
	 * @param array An array of integers to initialize the Squarelotron.
	 * @return A new Squarelotron.
	 * @throws IllegalArgumentException If the array length is not 16 or 25, or if
	 *                                  the array contains numbers not in the range
	 *                                  0 to 99.
	 */
	public static Squarelotron makeSquarelotron(int[] array) throws IllegalArgumentException {
		if (array.length != 16 && array.length != 25)
			throw new IllegalArgumentException("Array length must be 16 or 25");
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0 || array[i] > 99)
				throw new IllegalArgumentException("Array must contain numbers from 0 to 99");
		}
		if (array.length == 16)
			return new SmallSquarelotron(array);
		else
			return new LargeSquarelotron(array);
	}

	/**
	 * Returns a flattened array of the Squarelotron.
	 * 
	 * @return An array of integers.
	 */
	public abstract int[] numbers();

	/**
	 * Performs an upside-down flip on the Squarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new Squarelotron that is the result of the flip.
	 */
	public abstract Squarelotron upsideDownFlip(String ring);

	/**
	 * Performs an inverse diagonal flip on the Squarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new Squarelotron that is the result of the flip.
	 */
	public abstract Squarelotron inverseDiagonalFlip(String ring);

	/**
	 * Performs a left-right flip on the Squarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new Squarelotron that is the result of the flip.
	 */
	public abstract Squarelotron leftRightFlip(String ring);

	/**
	 * Performs a main diagonal flip on the Squarelotron.
	 * 
	 * @param ring A string indicating which ring to flip.
	 * @return A new Squarelotron that is the result of the flip.
	 */
	public abstract Squarelotron mainDiagonalFlip(String ring);

	/**
	 * Checks if this Squarelotron is equal to another object.
	 * 
	 * @param object The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public abstract boolean equals(Object object);

	/**
	 * Rotates the Squarelotron to the right.
	 * 
	 * @param numberOfTurns The number of 90 degree turns to rotate.
	 */
	public abstract void rotateRight(int numberOfTurns);

	/**
	 * Returns a string representation of the Squarelotron.
	 * 
	 * @return A string representing the Squarelotron.
	 */
	@Override
	public abstract String toString();

	/**
	 * Performs a side flip on the Squarelotron.
	 * 
	 * @param side A string indicating which side to flip.
	 * @return A new Squarelotron that is the result of the flip.
	 */
	public abstract Squarelotron sideFlip(String side);

}
