package es.iesjandula.administracion.huelga_alumnos;

import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.administracion.huelga_alumnos.utils.Alumn;
import es.iesjandula.administracion.huelga_alumnos.utils.ApplicationHuelgas;

/**
 * @author David Martinez
 *
 */
public class LaunchHuelgas
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();
	/**
	 * Method main
	 *
	 * @param args
	 */
	public void run()
	{
		// ---USING NIMBUS LOOK FOR JAVA SWING---
		try
		{
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (Exception exception)
		{
			try
			{
				// If Nimbus is not available, you can set the GUI to another look and feel.
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			}
			catch (ClassNotFoundException exceptionIn)
			{
				String error="Error ClassNotFoundException";
				logger.error(error,exceptionIn);
			}
			catch (InstantiationException exceptionIn)
			{
				String error="Error InstantiationException";
				logger.error(error,exceptionIn);
			}
			catch (IllegalAccessException exceptionIn)
			{
				String error="Error IllegalAccessException";
				logger.error(error,exceptionIn);
			}
			catch (UnsupportedLookAndFeelException exceptionIn)
			{
				String error="Error UnsupportedLookAndFeelException";
				logger.error(error,exceptionIn);
			}
		}
		ApplicationHuelgas application = new ApplicationHuelgas();

		List<Alumn> alumnList = application.getLoadedAlumns();

		MenuHuelga menuHuelga = new MenuHuelga(alumnList);
		menuHuelga.setVisible(true);

	}
}
