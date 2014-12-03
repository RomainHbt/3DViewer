package math_classes;

import exceptions.NotAVectorException;
import exceptions.NotCorrespondingMatrixException;

/**
 * <b><u>Classe Matrix(Matrice)</u></b>
 * 
 * @author Romain CHIGAR La classe Matrix implémente la notions mathématiques
 *         de matrice et d'opérations matricielles
 * 
 */
public class Matrix {
	public double[][] matrix;
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
		this.matrix = new double[length][width];
		this.length = length;
		this.width = width;
	}

	/**
	 * Constructeur de la classe Matrix d'après un tableau d'entiers à deux
	 * dimensions
	 * 
	 * @param matrix
	 *            Tableau d'entiers à deux dimensions
	 */
	public Matrix(double[][] matrix) {
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
	 * @return Matrice obtenue par l'addition des deux matrices entrées en
	 *         paramètres
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
			throw new NotCorrespondingMatrixException(
					"Les matrices n'ont pas les mêmes dimensions.");
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
	 * @return Matrice obtenue par la multiplication des deux matrices entrées
	 *         en paramètres
	 * 
	 * @throws NotCorrespondingMatrixException
	 */
	public static Matrix multiplyByMatrix(Matrix m1, Matrix m2)
			throws NotCorrespondingMatrixException {
		if (m1.getWidth() == m2.getLength()) {
			Matrix result = new Matrix(m1.getLength(), m2.getWidth());
			for (int i = 0; i < m1.getLength(); i++) {
				for (int j = 0; j < m1.getWidth(); j++) {
					for (int k = 0; k < m2.getWidth(); k++) {
						result.matrix[i][k] += m1.matrix[i][j]
								* m2.matrix[j][k];
					}
				}
			}
			return result;
		} else {
			throw new NotCorrespondingMatrixException(
					"Les tailles des matrices ne conviennent pas au produit.");
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

	public static Matrix homogeneous(Matrix m1) {
		Matrix m = new Matrix(m1.getLength() + 1, m1.getWidth());
		for (int i = 0; i < m1.getLength(); i++) {
			for (int j = 0; j < m1.getWidth(); j++) {
				m.matrix[i][j] = m1.matrix[i][j];
			}
		}
		for (int i = 0; i < m1.getWidth(); i++) {
			m.matrix[m1.getLength()][i] = 1.0;
		}
		return m;
	}

	public static Matrix getTranslationMatrix(Matrix m1)
			throws NotAVectorException {
		if (m1.getLength() == 3 && m1.getWidth() == 1) {
			Matrix m = new Matrix(4, 4);
			m.matrix[0][0] = 1;
			m.matrix[1][1] = 1;
			m.matrix[2][2] = 1;
			m.matrix[3][3] = 1;
			m.matrix[0][3] = m1.matrix[0][0];
			m.matrix[1][3] = m1.matrix[1][0];
			m.matrix[2][3] = m1.matrix[2][0];
			return m;
		} else {
			throw new NotAVectorException(
					"La matrice entr�e en param�tre n'est pas un vecteur.");
		}
	}

	public static Matrix getRotationMatrixX(double angle) {
		return new Matrix(new double[][] { { 1, 0, 0, 0 },
				{ 0, Math.cos(angle), -Math.sin(angle), 0 },
				{ 0, Math.sin(angle), Math.cos(angle), 0 }, { 0, 0, 0, 1 } });
	}
}