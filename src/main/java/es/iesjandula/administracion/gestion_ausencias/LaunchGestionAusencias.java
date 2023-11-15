package es.iesjandula.administracion.gestion_ausencias;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.administracion.gestion_ausencias.jframes.StarterWindow;

/**
 * @author David Martinez
 *
 */
public class LaunchGestionAusencias
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();


	/**
	 * Method run
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
			catch (ClassNotFoundException ex)
			{
				String error = "Class Not Found Exception";
				LaunchGestionAusencias.logger.error(error, ex);
			}
			catch (InstantiationException ex)
			{
				String error = "Instantiation Exception";
				LaunchGestionAusencias.logger.error(error, ex);
			}
			catch (IllegalAccessException ex)
			{
				String error = "IllegalAccess Exception";
				LaunchGestionAusencias.logger.error(error, ex);
			}
			catch (UnsupportedLookAndFeelException ex)
			{
				String error = "Unsupported LookAnd FeelException";
				LaunchGestionAusencias.logger.error(error, ex);
			}
		}
		StarterWindow startWindow = new StarterWindow();
		startWindow.setVisible(true);
	}

}