package hw4.squarelotron;

import org.junit.Test;
import static org.junit.Assert.*;

public class Check {

	@Test
	public void testConstructorAndNumbers() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		assertArrayEquals(array, squarelotron.numbers());
	}

	@Test
	public void testmakesquarelotron() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		try {
			Squarelotron squarelotron1 = Squarelotron.makeSquarelotron(array1);
			System.out.println("Created a " + squarelotron1.getClass().getSimpleName());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		try {
			Squarelotron squarelotron2 = Squarelotron.makeSquarelotron(array);
			System.out.println("Created a " + squarelotron2.getClass().getSimpleName());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		int[] array3 = { 1, 2, 3, 4, 5 };
		try {
			Squarelotron squarelotron3 = Squarelotron.makeSquarelotron(array3);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testUpsideDownFlip() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		Squarelotron flipped = squarelotron.upsideDownFlip("outer");

		assertArrayEquals(
				new int[] { 25, 22, 19, 24, 20, 16, 7, 8, 9, 21, 11, 12, 13, 14, 15, 6, 17, 18, 23, 10, 1, 2, 3, 4, 5 },
				flipped.numbers());
	}

	@Test
	public void testInverseDiagonalFlip() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		Squarelotron flipped = squarelotron.inverseDiagonalFlip("outer");

		assertArrayEquals(
				new int[] { 20, 21, 15, 10, 5, 24, 7, 8, 9, 4, 19, 12, 13, 14, 3, 22, 17, 18, 23, 2, 25, 16, 11, 6, 1 },
				flipped.numbers());
	}

	@Test
	public void testLeftRightFlip() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		Squarelotron flipped = squarelotron.leftRightFlip("outer");

		assertArrayEquals(
				new int[] { 5, 4, 3, 2, 1, 10, 7, 8, 9, 6, 15, 12, 13, 14, 11, 21, 17, 18, 23, 16, 20, 24, 19, 22, 25 },
				flipped.numbers());
	}

	@Test
	public void testMainDiagonalFlip() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		Squarelotron flipped = squarelotron.mainDiagonalFlip("outer");

		assertArrayEquals(
				new int[] { 1, 6, 11, 16, 25, 2, 7, 8, 9, 22, 3, 12, 13, 14, 19, 4, 17, 18, 23, 24, 5, 10, 15, 21, 20 },
				flipped.numbers());
	}

	@Test
	public void testEquals() {
		int[] array1 = new int[25];
		for (int i = 0; i < 25; i++) {
			array1[i] = i + 1;
		}
		int[] array2 = new int[25];
		for (int i = 0; i < 25; i++) {
			array2[i] = i + 2;
		}
		LargeSquarelotron squarelotron1 = new LargeSquarelotron(array1);
		LargeSquarelotron squarelotron2 = new LargeSquarelotron(array1);
		LargeSquarelotron squarelotron3 = new LargeSquarelotron(array2);
		assertTrue(squarelotron1.equals(squarelotron2));
		assertFalse(squarelotron1.equals(squarelotron3));
	}

	@Test
	public void testRotateRight() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		squarelotron.rotateRight(1);

		assertArrayEquals(
				new int[] { 25, 16, 11, 6, 1, 22, 17, 12, 7, 2, 19, 18, 13, 8, 3, 24, 23, 14, 9, 4, 20, 21, 15, 10, 5 },
				squarelotron.numbers());
	}

	@Test
	public void testToString() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		String str = squarelotron.toString();

		assertEquals("1 2 3 4 5 \n6 7 8 9 10 \n11 12 13 14 15 \n16 17 18 23 21 \n25 22 19 24 20 \n", str);
	}

	@Test
	public void testSideFlip() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 };
		LargeSquarelotron squarelotron = new LargeSquarelotron(array);
		Squarelotron flipped = squarelotron.sideFlip("top");

		assertArrayEquals(
				new int[] { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 11, 12, 13, 14, 15, 16, 17, 18, 23, 21, 25, 22, 19, 24, 20 },
				flipped.numbers());
	}
}
