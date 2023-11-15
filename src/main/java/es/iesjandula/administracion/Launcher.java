package es.iesjandula.administracion;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.administracion.windows.AdministracionMenu;

/**
 * @author David Martinez
 *
 */
public class Launcher
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();

	/**
	 * Method main
	 * 
	 * @param args
	 */
	public static void main(String[] args)
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
				logger.error(error, ex);
			}
			catch (InstantiationException ex)
			{
				String error = "Instantiation Exception";
				logger.error(error, ex);
			}
			catch (IllegalAccessException ex)
			{
				String error = "IllegalAccess Exception";
				logger.error(error, ex);
			}
			catch (UnsupportedLookAndFeelException ex)
			{
				String error = "Unsupported LookAnd FeelException";
				logger.error(error, ex);
			}
		}
		
		//Launch the principal screen
		AdministracionMenu newAdministracionMenu = new AdministracionMenu();
		newAdministracionMenu.setVisible(true);
	}
}
