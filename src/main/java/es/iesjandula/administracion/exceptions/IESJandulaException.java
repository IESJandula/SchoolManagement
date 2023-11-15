package es.iesjandula.administracion.exceptions;

/**
 * @author David Martinez
 *
 */
public class IESJandulaException extends Exception
{
	/**
	 * Constructor for create new IESJandulaException
	 * 
	 * @param error
	 * @param exception
	 */
	public IESJandulaException(String error, Exception exception)
	{
		super(error, exception);
	}
}
