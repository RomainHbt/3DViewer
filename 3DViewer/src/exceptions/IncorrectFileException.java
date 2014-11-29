package exceptions;

@SuppressWarnings("serial")
public class IncorrectFileException extends Exception{

	public IncorrectFileException(String message){
		super(message);
	}
}
