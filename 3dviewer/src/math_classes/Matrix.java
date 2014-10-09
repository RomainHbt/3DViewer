package math_classes;

import java.util.Random;

import exceptions.NotCorrespondingMatrixException;

/**
 * <b><u>Classe Matrix(Matrice)</u></b>
 * 
 * @author Romain CHIGAR La classe Matrix implémente la notions mathématiques de
 *         matrice et d'opérations matricielles
 * 
 */

public class Matrix {

	public int[][] matrix;
	private int length, width;

	/**
	 * Constructeur de la classe Matrix d'après ses dimensions
	 * 
	 * @param length
	 *            Nombre de colonnes de la matrice
	 * @param width
	 *            Nombre de lignes de la matrice
	 */

	public Matrix(int length, int width) {
		this.matrix = new int[length][width];
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Constructeur de la classe Matrix d'après un tableau d'entiers à deux dimensions
	 * 
	 * @param matrix
	 * 				Tableau d'entiers à deux dimensions 
	 */
	
	public Matrix(int[][] matrix) {
		this.matrix = matrix;
		this.length = matrix.length;
		this.width = matrix[0].length;
	}

	/**
	 * Accesseur de l'argument "length"
	 * 
	 * @return length
	 */

	public int getLength() {
		return this.length;
	}

	/**
	 * Accesseur de l'argument "width"
	 * 
	 * @return width
	 */

	public int getWidth() {
		return this.width;
	}

	/**
	 * Méthode statique effectuant l'addition matricielle des deux matrices
	 * entrées en paramètres
	 * 
	 * @param m1
	 *            Premier terme de l'addition matricielle
	 * @param m2
	 *            Second terme de l'addition matricielle
	 * 
	 * @return Matrice obtenue par l'addition des deux matrices entrées en paramètres
	 * 
	 * @throws NotCorrespondingMatrixException
	 */

	public static Matrix addMatrix(Matrix m1, Matrix m2)
			throws NotCorrespondingMatrixException {
		Matrix result = new Matrix(m1.getLength(), m1.getWidth());
		if (m1.getLength() == m2.getLength() && m1.getWidth() == m2.getWidth()) {
			for (int i = 0; i < m1.getLength(); i++) {
				for (int j = 0; j < m1.getWidth(); j++) {
					result.matrix[i][j] = m2.matrix[i][j] + m1.matrix[i][j];
				}
			}
			return result;
		} else {
			throw new NotCorrespondingMatrixException();
		}
	}

	/**
	 * Méthode statique effectuant le produit matricielle des deux matrices
	 * entrées en paramètres
	 * 
	 * @param m1
	 *            Premier facteur du produit matriciel
	 * @param m2
	 *            Second facteur du produit matriciel
	 * 
	 * @return Matrice obtenue par la multiplication des deux matrices entrées en paramètres
	 * 
	 * @throws NotCorrespondingMatrixException
	 */

	public static Matrix multiplyByMatrix(Matrix m1, Matrix m2)
			throws NotCorrespondingMatrixException {
		if (m1.getLength() == m2.getWidth()) {
			Matrix result = new Matrix(m2.getWidth(), m1.getLength());
			for (int i = 0; i < m1.getLength(); i++) {
				for (int j = 0; j < m2.getWidth(); j++) {
					for (int k = 0; k < m1.getWidth(); k++) {
						result.matrix[i][j] += m1.matrix[i][k]
								* m2.matrix[k][j];
					}
				}
			}
			return result;
		} else {
			throw new NotCorrespondingMatrixException();
		}

	}
	
	/**
	 * Méthode toString
	 * 
	 * @return Chaine de caractères représentant une matrice
	 */
	
	public String toString() {
		String result = "";
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.width; j++) {
				result += " " + this.matrix[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		Matrix matrice1 = new Matrix(new int[][] { { 1, 3, 2 }, { 2, 9, 4 } });
		Matrix matrice2 = new Matrix(3, 2);
		Random r = new Random();
		for (int i = 0; i < matrice2.getLength(); i++) {
			for (int j = 0; j < matrice2.getWidth(); j++) {
				matrice2.matrix[i][j] = r.nextInt(3);
			}
		}
		System.out.println(matrice1);
		System.out.println(matrice2);
		try {
			Matrix m3 = Matrix.multiplyByMatrix(matrice1, matrice2);
			System.out.println(m3);
		} catch (NotCorrespondingMatrixException e) {
			e.printStackTrace();
		}
	}
}
