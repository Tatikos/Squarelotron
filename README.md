# Squarelotron

A Java implementation of a square matrix data structure with various transformation operations.

## Overview

Squarelotron is a square matrix that supports different flip and rotation operations on its "rings" (outer and inner elements). This project implements two types:
- **SmallSquarelotron**: 4x4 matrix (16 elements)
- **LargeSquarelotron**: 5x5 matrix (25 elements)

## Features

### Transformations
- **Upside Down Flip**: Flips elements vertically within a ring
- **Left-Right Flip**: Flips elements horizontally within a ring
- **Main Diagonal Flip**: Flips elements across the main diagonal
- **Inverse Diagonal Flip**: Flips elements across the inverse diagonal
- **Side Flip**: Swaps adjacent rows/columns on specified sides
- **Rotate Right**: Rotates the entire matrix 90° clockwise

### Ring Operations
- **Outer Ring**: Operates on the perimeter elements
- **Inner Ring**: Operates on the interior elements
```

## Compilation & Testing

```bash
javac *.java
java TestRunner
```

## Structure

- `Squarelotron.java` - Abstract base class
- `SmallSquarelotron.java` - 4x4 implementation
- `LargeSquarelotron.java` - 5x5 implementation
- `SquarelotronMethods.java` - Interface definition
- `TestRunner.java` - Comprehensive test suite