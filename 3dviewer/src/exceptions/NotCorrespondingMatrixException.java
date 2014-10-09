package exceptions;

public class NotCorrespondingMatrixException extends Exception {

		public NotCorrespondingMatrixException() {
			super("Les tailles des matrices ne correspondent pas à l'opération à appliquer");
		}
}
