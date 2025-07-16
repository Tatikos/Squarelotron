public class TestRunner {
    public static void main(String[] args) {
        System.out.println("=== SQUARELOTRON COMPREHENSIVE TESTS ===\n");
        
        testConstructors();
        testMakeSquarelotron();
        testSmallSquarelotronFlips();
        testLargeSquarelotronFlips();
        testEqualsMethod();
        testToStringMethod();
        testErrorCases();
        
        System.out.println("=== ALL TESTS COMPLETED ===");
    }
    
    private static void testConstructors() {
        System.out.println("--- Testing Constructors ---");
        
        // Test SmallSquarelotron constructor
        int[] smallArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        SmallSquarelotron small = new SmallSquarelotron(smallArray);
        System.out.println("SmallSquarelotron constructor: " + 
            java.util.Arrays.equals(smallArray, small.numbers()));
        
        // Test LargeSquarelotron constructor
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        LargeSquarelotron large = new LargeSquarelotron(largeArray);
        System.out.println("LargeSquarelotron constructor: " + 
            java.util.Arrays.equals(largeArray, large.numbers()));
        System.out.println();
    }
    
    private static void testMakeSquarelotron() {
        System.out.println("--- Testing makeSquarelotron ---");
        
        // Test with 16 elements (should create SmallSquarelotron)
        int[] array16 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        try {
            Squarelotron sq16 = Squarelotron.makeSquarelotron(array16);
            System.out.println("Array of 16 elements creates: " + sq16.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Error with 16 elements: " + e.getMessage());
        }
        
        // Test with 25 elements (should create LargeSquarelotron)
        int[] array25 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        try {
            Squarelotron sq25 = Squarelotron.makeSquarelotron(array25);
            System.out.println("Array of 25 elements creates: " + sq25.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Error with 25 elements: " + e.getMessage());
        }
        
        // Test with invalid size (should throw exception)
        int[] array9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        try {
            Squarelotron sq9 = Squarelotron.makeSquarelotron(array9);
            System.out.println("Array of 9 elements creates: " + sq9.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Expected error with 9 elements: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testSmallSquarelotronFlips() {
        System.out.println("--- Testing SmallSquarelotron Flips ---");
        
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        SmallSquarelotron sq = new SmallSquarelotron(array);
        
        // Test upside down flip outer
        System.out.println("Original: " + java.util.Arrays.toString(sq.numbers()));
        Squarelotron upsideOuter = sq.upsideDownFlip("outer");
        System.out.println("Upside down outer: " + java.util.Arrays.toString(upsideOuter.numbers()));
        
        // Test upside down flip inner
        Squarelotron upsideInner = sq.upsideDownFlip("inner");
        System.out.println("Upside down inner: " + java.util.Arrays.toString(upsideInner.numbers()));
        
        // Test left right flip outer
        Squarelotron leftRightOuter = sq.leftRightFlip("outer");
        System.out.println("Left right outer: " + java.util.Arrays.toString(leftRightOuter.numbers()));
        
        // Test left right flip inner
        Squarelotron leftRightInner = sq.leftRightFlip("inner");
        System.out.println("Left right inner: " + java.util.Arrays.toString(leftRightInner.numbers()));
        
        // Test inverse diagonal flip outer
        Squarelotron invDiagOuter = sq.inverseDiagonalFlip("outer");
        System.out.println("Inverse diagonal outer: " + java.util.Arrays.toString(invDiagOuter.numbers()));
        
        // Test inverse diagonal flip inner
        Squarelotron invDiagInner = sq.inverseDiagonalFlip("inner");
        System.out.println("Inverse diagonal inner: " + java.util.Arrays.toString(invDiagInner.numbers()));
        
        // Test main diagonal flip outer
        Squarelotron mainDiagOuter = sq.mainDiagonalFlip("outer");
        System.out.println("Main diagonal outer: " + java.util.Arrays.toString(mainDiagOuter.numbers()));
        
        // Test main diagonal flip inner
        Squarelotron mainDiagInner = sq.mainDiagonalFlip("inner");
        System.out.println("Main diagonal inner: " + java.util.Arrays.toString(mainDiagInner.numbers()));
        System.out.println();
    }
    
    private static void testLargeSquarelotronFlips() {
        System.out.println("--- Testing LargeSquarelotron Flips ---");
        
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        LargeSquarelotron sq = new LargeSquarelotron(array);
        
        // Test upside down flip outer
        System.out.println("Original: " + java.util.Arrays.toString(sq.numbers()));
        Squarelotron upsideOuter = sq.upsideDownFlip("outer");
        System.out.println("Upside down outer: " + java.util.Arrays.toString(upsideOuter.numbers()));
        
        // Test upside down flip inner
        Squarelotron upsideInner = sq.upsideDownFlip("inner");
        System.out.println("Upside down inner: " + java.util.Arrays.toString(upsideInner.numbers()));
        
        // Test left right flip outer
        Squarelotron leftRightOuter = sq.leftRightFlip("outer");
        System.out.println("Left right outer: " + java.util.Arrays.toString(leftRightOuter.numbers()));
        
        // Test left right flip inner
        Squarelotron leftRightInner = sq.leftRightFlip("inner");
        System.out.println("Left right inner: " + java.util.Arrays.toString(leftRightInner.numbers()));
        
        // Test inverse diagonal flip outer
        Squarelotron invDiagOuter = sq.inverseDiagonalFlip("outer");
        System.out.println("Inverse diagonal outer: " + java.util.Arrays.toString(invDiagOuter.numbers()));
        
        // Test inverse diagonal flip inner
        Squarelotron invDiagInner = sq.inverseDiagonalFlip("inner");
        System.out.println("Inverse diagonal inner: " + java.util.Arrays.toString(invDiagInner.numbers()));
        
        // Test main diagonal flip outer
        Squarelotron mainDiagOuter = sq.mainDiagonalFlip("outer");
        System.out.println("Main diagonal outer: " + java.util.Arrays.toString(mainDiagOuter.numbers()));
        
        // Test main diagonal flip inner
        Squarelotron mainDiagInner = sq.mainDiagonalFlip("inner");
        System.out.println("Main diagonal inner: " + java.util.Arrays.toString(mainDiagInner.numbers()));
        System.out.println();
    }
    
    private static void testEqualsMethod() {
        System.out.println("--- Testing equals Method ---");
        
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] array3 = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        SmallSquarelotron sq1 = new SmallSquarelotron(array1);
        SmallSquarelotron sq2 = new SmallSquarelotron(array2);
        SmallSquarelotron sq3 = new SmallSquarelotron(array3);
        
        System.out.println("sq1.equals(sq2) [same content]: " + sq1.equals(sq2));
        System.out.println("sq1.equals(sq3) [different content]: " + sq1.equals(sq3));
        System.out.println("sq1.equals(null): " + sq1.equals(null));
        System.out.println("sq1.equals(\"string\"): " + sq1.equals("string"));
        
        // Test different sizes
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        LargeSquarelotron large = new LargeSquarelotron(largeArray);
        System.out.println("small.equals(large) [different sizes]: " + sq1.equals(large));
        System.out.println();
    }
    
    private static void testToStringMethod() {
        System.out.println("--- Testing toString Method ---");
        
        // Test SmallSquarelotron toString
        int[] smallArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        SmallSquarelotron small = new SmallSquarelotron(smallArray);
        System.out.println("SmallSquarelotron toString:");
        System.out.println(small.toString());
        
        // Test LargeSquarelotron toString
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        LargeSquarelotron large = new LargeSquarelotron(largeArray);
        System.out.println("LargeSquarelotron toString:");
        System.out.println(large.toString());
        System.out.println();
    }
    
    private static void testErrorCases() {
        System.out.println("--- Testing Error Cases ---");
        
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        SmallSquarelotron sq = new SmallSquarelotron(array);
        
        // Test invalid ring parameters
        try {
            sq.upsideDownFlip("middle");
            System.out.println("ERROR: Should have thrown exception for invalid ring");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught exception for invalid ring 'middle': " + e.getMessage());
        }
        
        try {
            sq.leftRightFlip("invalid");
            System.out.println("ERROR: Should have thrown exception for invalid ring");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught exception for invalid ring 'invalid': " + e.getMessage());
        }
        
        try {
            sq.inverseDiagonalFlip("");
            System.out.println("ERROR: Should have thrown exception for empty ring");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught exception for empty ring: " + e.getMessage());
        }
        
        try {
            sq.mainDiagonalFlip("OUTER");
            System.out.println("ERROR: Should have thrown exception for wrong case");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught exception for wrong case 'OUTER': " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void printArray(String label, int[] array) {
        System.out.println(label + ": " + java.util.Arrays.toString(array));
    }
    
    private static boolean arraysEqual(int[] a1, int[] a2) {
        return java.util.Arrays.equals(a1, a2);
    }
}