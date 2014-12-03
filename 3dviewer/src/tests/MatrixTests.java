package tests;

import math_classes.Matrix;
import static org.junit.Assert.*;
import org.junit.Test;

public class MatrixTests {

	@Test
	public void multiplyByMatriceTest1() {
		Matrix m1 = new Matrix(new double[][] { { 1, 2, 3 } });
		Matrix m2 = new Matrix(new double[][] { { 2 }, { 6 }, { 9 } });
		try {
			Matrix m3 = Matrix.multiplyByMatrix(m1, m2);
			Matrix mTest = new Matrix(new double[][] { { 41 } });
			for (int i = 0; i < mTest.getLength(); i++) {
				for (int j = 0; j < mTest.getWidth(); j++) {
					assertEquals(m3.matrix[i][j], mTest.matrix[i][j], 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void multiplyByMatriceTest2() {
		Matrix m1 = new Matrix(new double[][] { { 1, 2, 3 }, { 3, 6, 3 } });
		Matrix m2 = new Matrix(new double[][] { { 2}, { 6 }, { 9 } });
		try {
			Matrix m3 = Matrix.multiplyByMatrix(m1, m2);
			Matrix mTest = new Matrix(new double[][] { { 41 }, { 69 } });
			for (int i = 0; i < mTest.getLength(); i++) {
				for (int j = 0; j < mTest.getWidth(); j++) {
					assertEquals(m3.matrix[i][j], mTest.matrix[i][j], 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addMatrixTest() {
		Matrix m1 = new Matrix(new double[][] { { 1, 2, 3 }, { 4, 12, 54 } });
		Matrix m2 = new Matrix(new double[][] { { 7, 9, 14 }, { 17, 19, 24 } });
		try {
			Matrix m3 = Matrix.addMatrix(m1, m2);
			Matrix mTest = new Matrix(new double[][] { { 8, 11, 17 },
					{ 21, 31, 78 } });
			for (int i = 0; i < mTest.getLength(); i++) {
				for (int j = 0; j < mTest.getWidth(); j++) {
					assertEquals(m3.matrix[i][j], mTest.matrix[i][j], 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void homogeneousMatrix() {
		Matrix m1 = new Matrix(new double[][] { { 1, 2, 3 }, { 4, 12, 54 } });
		Matrix mTest = Matrix.homogeneous(m1);
		for (int i = 0; i < m1.getLength(); i++) {
			for (int j = 0; j < m1.getWidth(); j++) {
				assertEquals(m1.matrix[i][j], mTest.matrix[i][j], 0);
			}
		}
		for (int i=0 ; i < m1.getWidth() ; i++) {
			assertEquals(mTest.matrix[mTest.matrix.length-1][i], 1.0, 0);
		}
	}
}