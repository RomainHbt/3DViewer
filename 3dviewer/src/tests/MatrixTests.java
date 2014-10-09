package tests;

import math_classes.Matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTests {

	@Test
	public void multiplyByMatriceTest() {
		Matrix m1 = new Matrix(new int[][] { { 1, 2, 3 } });
		Matrix m2 = new Matrix(new int[][] { { 2 }, { 6 }, { 9 } });
		try {
			Matrix m3 = Matrix.multiplyByMatrix(m1, m2);
			Matrix mTest = new Matrix(new int[][] { { 41 } });
			for (int i = 0; i < mTest.getLength(); i++) {
				for (int j = 0; j < mTest.getWidth(); j++) {
					assertEquals(m3.matrix[i][j], mTest.matrix[i][j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addMatrixTest() {
		Matrix m1 = new Matrix(new int[][] { { 1, 2, 3 }, { 4, 12, 54 } });
		Matrix m2 = new Matrix(new int[][] { { 7, 9, 14 }, { 17, 19, 24 } });
		try {
			Matrix m3 = Matrix.addMatrix(m1, m2);
			Matrix mTest = new Matrix(new int[][] { { 8, 11, 17 }, { 21, 31, 78 } });
			for (int i = 0; i < mTest.getLength(); i++) {
				for (int j = 0; j < mTest.getWidth(); j++) {
					assertEquals(m3.matrix[i][j], mTest.matrix[i][j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
