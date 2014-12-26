package math_classes;

/**
 * <b><u>Classe Matrix(Matrice)</u></b>
 * 
 * @author Romain CHIGAR La classe Matrix implÃ©mente la notions mathÃ©matiques
 *         de matrice et d'opÃ©rations matricielles
 * 
 */
public class Matrix {
	public double[][] matrix;
	private int length, width;

	/**
	 * Constructeur de la classe Matrix d'aprÃ¨s ses dimensions
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
	 * Constructeur de la classe Matrix d'aprÃ¨s un tableau d'entiers Ã deux
	 * dimensions
	 * 
	 * @param matrix
	 *            Tableau d'entiers Ã deux dimensions
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
	 * MÃ©thode statique effectuant l'addition matricielle des deux matrices
	 * entrÃ©es en paramÃ¨tres
	 * 
	 * @param m1
	 *            Premier terme de l'addition matricielle
	 * @param m2
	 *            Second terme de l'addition matricielle
	 * 
	 * @return Matrice obtenue par l'addition des deux matrices entrÃ©es en
	 *         paramÃ¨tres
	 * 
	 * @throws Exception
	 */
	public static Matrix addMatrix(Matrix m1, Matrix m2) throws Exception {
		Matrix result = new Matrix(m1.getLength(), m1.getWidth());
		if (m1.getLength() == m2.getLength() && m1.getWidth() == m2.getWidth()) {
			for (int i = 0; i < m1.getLength(); i++) {
				for (int j = 0; j < m1.getWidth(); j++) {
					result.matrix[i][j] = m2.matrix[i][j] + m1.matrix[i][j];
				}
			}
			return result;
		} else {
			throw new Exception("Les matrices n'ont pas les mÃªmes dimensions.");
		}
	}

	/**
	 * MÃ©thode statique effectuant le produit matricielle des deux matrices
	 * entrÃ©es en paramÃ¨tres
	 * 
	 * @param m1
	 *            Premier facteur du produit matriciel
	 * @param m2
	 *            Second facteur du produit matriciel
	 * 
	 * @return Matrice obtenue par la multiplication des deux matrices entrÃ©es
	 *         en paramÃ¨tres
	 * 
	 * @throws Exception
	 */
	public static Matrix multiplyByMatrix(Matrix m1, Matrix m2)
			throws Exception {
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
			throw new Exception(
					"Les tailles des matrices ne conviennent pas au produit.");
		}
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

	public static Matrix multiplyByDouble(Matrix m1, double n) {
		Matrix m = new Matrix(m1.getLength(), m1.getWidth());
		for (int i = 0; i < m1.getLength(); i++) {
			for (int j = 0; j < m1.getWidth(); j++) {
				m.matrix[i][j] = m1.matrix[i][j] * n;
			}
		}
		return m;
	}

	public static Matrix getTranslationMatrix(Vector v1) {
		Matrix m = new Matrix(4, 4);
		m.matrix[0][0] = 1;
		m.matrix[1][1] = 1;
		m.matrix[2][2] = 1;
		m.matrix[3][3] = 1;
		m.matrix[0][3] = v1.getX();
		m.matrix[1][3] = v1.getY();
		m.matrix[2][3] = v1.getZ();
		return m;
	}

	public static Matrix getRotationMatrixX(double angle) {
		return new Matrix(new double[][] { { 1, 0, 0, 0 },
				{ 0, Math.cos(angle), -Math.sin(angle), 0 },
				{ 0, Math.sin(angle), Math.cos(angle), 0 }, { 0, 0, 0, 1 } });
	}

	public static Matrix getRotationMatrixY(double angle) {
		return new Matrix(new double[][] {
				{ Math.cos(angle), 0, -Math.sin(angle), 0 }, { 0, 1, 0, 0 },
				{ Math.sin(angle), 0, Math.cos(angle), 0 }, { 0, 0, 0, 1 } });
	}
	
	public static Matrix getIdentityMatrix(int n) {
		Matrix m = new Matrix(n, n);
		for (int i=0 ; i<n ; i++) {
			m.matrix[i][i] = 1;
		}
		return m;
	}
	
	public void print() {
		for (int i = 0 ; i<getLength() ; i++) {
			System.out.print("[");
			for (int j = 0 ; j<getWidth() ; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println("]");
		}
	}
}