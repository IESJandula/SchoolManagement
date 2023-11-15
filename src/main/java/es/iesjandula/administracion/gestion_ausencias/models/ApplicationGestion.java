package es.iesjandula.administracion.gestion_ausencias.models;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import es.iesjandula.administracion.exceptions.IESJandulaException;



/**
 * @author David Martinez
 *
 */
public class ApplicationGestion
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();

	/**
	 * Method run
	 *
	 * @throws InterruptedException
	 */
	public void run(String sheetUrl, String email)
	{
		try
		{
			WebDriver driver = new ChromeDriver();

			// ----THE HOURS--- ( TIME ON RELOAD SHEET) ----
			String timeOne = "8:15:0";
			String timeTwo = "9:15:0";
			String timeThree = "10:15:0";
			String timeFour = "11:15:0";
			String timeFive = "12:45:0";
			String timeSix = "13:45:0";

			driver.get(sheetUrl);

			driver.getTitle();

			// Resize current window to the set dimension
			driver.manage().window().maximize();

			// Wait 500ms
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

			// If the email is on the cfg , load it
			if (!email.trim().isEmpty())
			{
				// Getting the google id from input type -> <input id=""identifierId> from HTML
				WebElement username = driver.findElement(By.id("identifierId"));

				// Send Email and press ENTER
				username.sendKeys(email);

				Actions action = new Actions(driver);
				action.keyDown(Keys.ENTER).perform();
			}

			// While the web loaded not contains -> ª Hora , Wait on this loop.
			while (!driver.getPageSource().contains("ª Hora"))
			{
				logger.debug(" SHEET NOT LOADED ");
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException exception)
				{
					String error = "Interrupted Exception";
					ApplicationGestion.logger.warn(error, exception);
				}
			}

			// At this point the google sheet its completely loaded
			// Call to zoomAndSizePreferences for puts on 80% zoom and press F11
			this.zoomAndSizePreferences(driver);

			// Boolean for the first time , to reload the time
			boolean reloadHour = true;

			// Infinite loop because need to be infinite
			while (true)
			{
				// Gett the tittle from driver, if that throw an exception to close the program,
				// because the web is closed or impossible to see.
				driver.getTitle();

				// Getting the actual time
				String actualTime = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":"
						+ LocalDateTime.now().getSecond();
				logger.debug(actualTime);

				// ------RELOAD HOURS---------
				reloadHour = this.reloadOnStartUp(driver, reloadHour);
				// ------RELOAD HOURS---END------

				// ----LOAD HOUR POSITIONS------
				this.loadHour(driver, timeOne, actualTime, "1");

				this.loadHour(driver, timeTwo, actualTime, "2");

				this.loadHour(driver, timeThree, actualTime, "3");

				this.loadHour(driver, timeFour, actualTime, "4");

				this.loadHour(driver, timeFive, actualTime, "5");

				this.loadHour(driver, timeSix, actualTime, "6");
				// ----LOAD HOUR POSITIONS--END----

			}
		}
		catch (NoSuchWindowException webClosedException)
		{
			//When web is closed , and got this exception , exit the application
			System.exit(0);
		}
		catch(org.openqa.selenium.InvalidArgumentException exception) 
		{
			String error = "InvalidArgumentException , google sheet URL error";
			JOptionPane.showMessageDialog(null, error);
			ApplicationGestion.logger.error(error, exception);
			System.exit(0);
		}
		catch(Exception exception)
		{
			String error = "Error inesperado";
			JOptionPane.showMessageDialog(null, error);
			ApplicationGestion.logger.error(error, exception);
			System.exit(0);
		}

	}

	/**
	 * Method reloadOnStartUp
	 *
	 * @param driver
	 * @param reloadHour
	 * @return
	 * @throws InterruptedException
	 */
	private boolean reloadOnStartUp(WebDriver driver, boolean reloadHour)
	{
		// If the reloadHour its true , reload the nearest hour.
		// The hour get reload 10-5 mins before.
		if (reloadHour)
		{
			logger.info("---------RELOADING----------");
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException exception)
			{
				String error = "Interrupted Exception";
				ApplicationGestion.logger.warn(error, exception);
			}

			logger.info(LocalDateTime.now().getHour());
			logger.info(LocalDateTime.now().getHour() + LocalDateTime.now().getMinute());

			if (14 <= (LocalDateTime.now().getHour()))
			{
				logger.info("---------RELOADING 6 HORA--------");
				this.loadHour(driver, "", "", "6");
				reloadHour = false;
			}
			else if (13 <= (LocalDateTime.now().getHour()))
			{
				if (LocalDateTime.now().getMinute() >= 40)
				{
					logger.info("---------RELOADING 6 HORA--------");
					this.loadHour(driver, "", "", "6");
					reloadHour = false;
				}
				else
				{
					logger.info("---------RELOADING 5 HORA--------");
					this.loadHour(driver, "", "", "5");
					reloadHour = false;
				}
			}
			else if (12 <= (LocalDateTime.now().getHour()))
			{
				if (LocalDateTime.now().getMinute() >= 40)
				{
					logger.info("---------RELOADING 5 HORA--------");
					this.loadHour(driver, "", "", "5");
					reloadHour = false;
				}
				else
				{
					logger.info("---------RELOADING 4 HORA--------");
					this.loadHour(driver, "", "", "4");
					reloadHour = false;
				}
			}
			else if (11 <= (LocalDateTime.now().getHour()))
			{
				if (LocalDateTime.now().getMinute() >= 10)
				{
					logger.info("---------RELOADING 5 HORA--------");
					this.loadHour(driver, "", "", "4");
					reloadHour = false;
				}
				else
				{
					logger.info("---------RELOADING 4 HORA--------");
					this.loadHour(driver, "", "", "3");
					reloadHour = false;
				}
			}
			else if (10 <= (LocalDateTime.now().getHour()))
			{
				if (LocalDateTime.now().getMinute() <= 10)
				{
					logger.info("---------RELOADING 2 HORA--------");
					this.loadHour(driver, "", "", "2");
					reloadHour = false;
				}
				else
				{
					logger.info("---------RELOADING 3 HORA--------");
					this.loadHour(driver, "", "", "3");
					reloadHour = false;
				}
			}
			else if (9 <= (LocalDateTime.now().getHour()))
			{
				if (LocalDateTime.now().getMinute() <= 10)
				{
					logger.info("---------RELOADING 1 HORA--------");
					this.loadHour(driver, "", "", "1");
					reloadHour = false;
				}
				else
				{
					logger.info("---------RELOADING 2 HORA--------");
					this.loadHour(driver, "", "", "2");
					reloadHour = false;
				}
			}
			else if (8 <= (LocalDateTime.now().getHour() + LocalDateTime.now().getMinute()))
			{
				logger.info("---------RELOADING 1 HORA--------");
				this.loadHour(driver, "", "", "1");
				reloadHour = false;
			}
		}
		return reloadHour;
	}

	/**
	 * Method zoomPreferences Zoom 80% and F11 process
	 *
	 * @param driver
	 * @throws InterruptedException
	 */
	private void zoomAndSizePreferences(WebDriver driver)
	{
		Robot robot;
		try
		{
			robot = new Robot();
			for (int i = 0; i < 2; i++)
			{
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			robot.keyPress(KeyEvent.VK_F11);
		}
		catch (AWTException exception)
		{
			String error = "IO Exception getSheetUrl ";
			ApplicationGestion.logger.error(error, exception);
		}
	}

	/**
	 * Method loadHour Method for load specific hour
	 *
	 * @param driver
	 * @param timeSix
	 * @param actualTime
	 * @param hourNumber
	 */
	private void loadHour(WebDriver driver, String time, String actualTime, String hourNumber)
	{
		// If the time == to actualtime
		if (time.equals(actualTime))
		{
			logger.info("---------" + hourNumber + " HORA----------");
			Actions action = new Actions(driver);

			// Press CTRL+F
			action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0066')).perform();

			// Leave CRTL
			action.keyUp(Keys.CONTROL);

			// Send keys with hour+ª Hora parttern for seach
			action.sendKeys(hourNumber).perform();
			action.sendKeys("ª").perform();
			action.sendKeys(" ").perform();
			action.sendKeys("H").perform();
			action.sendKeys("o").perform();
			action.sendKeys("r").perform();
			action.sendKeys("a").perform();

			// Press ESCAPE , for leave the CRTL+F Container
			action.keyDown(Keys.ESCAPE).perform();

			// Leave ESCAPE
			action.keyUp(Keys.ESCAPE).perform();

			// Press right arrow for focuse the guard cell
			action.keyDown(Keys.ARROW_RIGHT).perform();
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException exception)
			{
				String error = "Interrupted Exception";
				ApplicationGestion.logger.warn(error, exception);
			}
		}
	}

	/**
	 * Method getSheetUrl Method for load the URL from CFG
	 *
	 * @return String with the URL sheet
	 * @throws IESJandulaException
	 */
	public String getSheetUrl() throws IESJandulaException
	{

		String outcome = "";
		BufferedReader fileInputStream = null;

		// -----------READ ONLY THE FIRST LINE------------!
		try
		{
			fileInputStream = new BufferedReader(new FileReader("configuration.cfg"));
			String read = fileInputStream.readLine();
			if (read != null)
			{
				outcome = read;
			}

		}
		catch (FileNotFoundException exception)
		{
			String error = "FileNotFoundException getSheetUrl ";
			ApplicationGestion.logger.error(error, exception);
		}
		catch (IOException exception)
		{
			String error = "IO Exception getSheetUrl ";
			ApplicationGestion.logger.error(error, exception);
		}
		finally
		{
			if (fileInputStream != null)
			{
				try
				{
					fileInputStream.close();
				}
				catch (IOException exception)
				{
					String error = "IO Exception getSheetUrl ";
					ApplicationGestion.logger.error(error, exception);
					throw new IESJandulaException(error, exception);
				}
			}
		}

		return outcome;
	}

	/**
	 * Method getEmail Method for load the EMAIL from CFG
	 *
	 * @return String with the EMAIL
	 * @throws IESJandulaException
	 */
	public String getEmail() throws IESJandulaException
	{
		String outcome = "";
		BufferedReader fileInputStream = null;

		// -----------READ ONLY THE SECOND LINE BY TWO READS------------!
		try
		{
			fileInputStream = new BufferedReader(new FileReader("configuration.cfg"));
			String read = fileInputStream.readLine();
			read = fileInputStream.readLine();
			if (read != null)
			{
				outcome = read;
			}

		}
		catch (FileNotFoundException exception)
		{
			String error = "FileNotFoundException getEmail ";
			ApplicationGestion.logger.error(error, exception);
		}
		catch (IOException exception)
		{
			String error = "IO Exception getEmail ";
			ApplicationGestion.logger.error(error, exception);
		}
		finally
		{
			if (fileInputStream != null)
			{
				try
				{
					fileInputStream.close();
				}
				catch (IOException exception)
				{
					String error = "IO Exception getEmail ";
					ApplicationGestion.logger.error(error, exception);
					throw new IESJandulaException(error, exception);
				}
			}
		}

		return outcome;
	}

	/**
	 * Method storeNewConfiguration Method for store the new configuration file
	 *
	 * @param newConfiguration
	 * @throws IESJandulaException
	 */
	public void storeNewConfiguration(String newConfiguration) throws IESJandulaException
	{
		//Store the configuration on file
		PrintWriter printWriter = null;

		try
		{
			printWriter = new PrintWriter(new File("configuration.cfg"));
			printWriter.println(newConfiguration);
			printWriter.flush();
		}
		catch (FileNotFoundException exception)
		{
			String error = "FileNotFoundException storeNewConfiguration ";
			ApplicationGestion.logger.error(error, exception);
			throw new IESJandulaException(error, exception);
		}
		finally
		{
			if (printWriter != null)
			{
				printWriter.close();
			}
		}
	}
}
