package es.iesjandula.administracion.huelga_alumnos.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.iesjandula.administracion.huelga_alumnos.Huelga;
import es.iesjandula.administracion.huelga_alumnos.LoadingBarPanel;
import es.iesjandula.administracion.exceptions.IESJandulaException;
import lombok.Data;

/**
 * @author David Martinez
 *
 */
@Data
public class ApplicationHuelgas
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();
	
	/** Attribute loadedAlumns*/
	private List<Alumn> loadedAlumns;

	/**
	 * Constructor for create new Application
	 */
	public ApplicationHuelgas()
	{
		this.loadedAlumns = this.loadAlumnsList();
	}


	/**
	 * Method loadAlumnsList
	 * @return
	 */
	private List<Alumn> loadAlumnsList()
	{
		List<Alumn> loaded = new ArrayList<>();
		InputStreamReader fileReader = null;
		BufferedReader bufferedReader = null;

		try
		{

			fileReader = new InputStreamReader(new FileInputStream(new File("./ALUMNADO.csv")),
					StandardCharsets.ISO_8859_1);
			bufferedReader = new BufferedReader(fileReader);
			String subString = bufferedReader.readLine();
			subString = bufferedReader.readLine();

			while (subString != null)
			{
				subString = ApplicationHuelgas.removerTildesEnye(subString);

				logger.debug(subString);

				String[] temporalArray = subString.split(";");
				Alumn newAlumn = new Alumn(temporalArray[0], temporalArray[1], temporalArray[2]);
				loaded.add(newAlumn);
				subString = bufferedReader.readLine();

			}

			logger.debug(loaded);
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "ERROR NO SE ENCONTRO EL FICHERO ALUMNOS.csv ");
			System.exit(0);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "ERROR ENTRADA/SALIDA SOBRE FICHERO ALUMNOS.csv ");
			System.exit(0);
		}

		return loaded;
	}

	/**
	 * Method registerHuelga
	 * @param alumnList
	 * @param date
	 * @throws IESJandulaException 
	 */
	public void registerHuelga(List<Alumn> alumnList, Date date) throws IESJandulaException
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String dateString = simpleDateFormat.format(date);

		// Conexion
		String connectionString = this.getConexionStored();

		// Create a new client and connect to the server
		Thread registerHuelga = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				LoadingBarPanel barPanel = new LoadingBarPanel();
				barPanel.setVisible(true);
				try
				{
					MongoClient mongoClient = MongoClients.create(connectionString);
					try
					{
						MongoDatabase db = mongoClient.getDatabase("huelgas");

						MongoCollection collection = db.getCollection("huelga");

						FindIterable<Document> allDocsIterable = collection.find();
						Iterator iterable = allDocsIterable.iterator();

						int index = 0;
						for (Alumn alumn : alumnList)
						{
							boolean exist = false;
							iterable = allDocsIterable.iterator();
							try
							{
								Document doc = new Document("name", alumn.getName()).append("dni", alumn.getDni())
										.append("course", alumn.getCourse()).append("huelgaDate", dateString);
								collection.insertOne(doc);
							}
							catch (MongoWriteException e)
							{

							}
						}
					}
					catch (MongoException e)
					{
						JOptionPane.showMessageDialog(null, "ERROR DE CONEXION A LA BASE DE DATOS... ");
						e.printStackTrace();
					}
				}
				catch (Exception exception)
				{
					JOptionPane.showMessageDialog(null, "ERROR DE CONEXION A LA BASE DE DATOS... ");
				}
				barPanel.dispose();
				JOptionPane.showMessageDialog(null, "REGISTROS FINALIZADOS");
			}
		});
		registerHuelga.start();

	}

	/**
	 * Method deleteHuelga
	 *
	 * @param alumnList
	 * @param date
	 * @throws IESJandulaException 
	 */
	public void deleteHuelga(List<Alumn> alumnList, Date date) throws IESJandulaException
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String dateString = simpleDateFormat.format(date);

		// Conexion
		String connectionString = this.getConexionStored();


		// Create a new client and connect to the server
		Thread deleteHuelga = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				LoadingBarPanel barPanel = new LoadingBarPanel();
				barPanel.setVisible(true);
				try
				{
					MongoClient mongoClient = MongoClients.create(connectionString);
					try
					{
						MongoDatabase db = mongoClient.getDatabase("huelgas");

						MongoCollection collection = db.getCollection("huelga");

						FindIterable<Document> allDocsIterable = collection.find();
						Iterator iterable = allDocsIterable.iterator();

						int index = 0;
						for (Alumn alumn : alumnList)
						{
							boolean exist = false;
							iterable = allDocsIterable.iterator();

							while (iterable.hasNext())
							{
								Document tmpDoc = (Document) iterable.next();
								if (alumn.getDni().equals(tmpDoc.getString("dni"))
										&& dateString.equals(tmpDoc.getString("huelgaDate")))
								{
									logger.debug(alumn.getName() + " ALUMNO A BORRAR");

									collection.deleteOne(tmpDoc);

								}
							}
						}
					}
					catch (MongoException e)
					{

						e.printStackTrace();
					}
				}
				catch (Exception exception)
				{
					JOptionPane.showMessageDialog(null, "ERROR DE CONEXION A LA BASE DE DATOS... ");
				}
				barPanel.dispose();
				JOptionPane.showMessageDialog(null, "REGISTROS FINALIZADOS");
			}
		});
		deleteHuelga.start();

	}

	/**
	 * Method getHuelgaAlumns
	 *
	 * @param date
	 * @return
	 * @throws IESJandulaException 
	 */
	public List<Alumn> getHuelgaAlumns(Date date) throws IESJandulaException
	{
		List<Alumn> alumList = new ArrayList<>();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String dateString = simpleDateFormat.format(date);

		String connectionString = this.getConexionStored();

		try
		{
			MongoClient mongoClient = MongoClients.create(connectionString);
			try
			{
				MongoDatabase db = mongoClient.getDatabase("huelgas");

				MongoCollection personas = db.getCollection("huelga");

				FindIterable<Document> allDocsIterable = personas.find();
				for (Document tmpDoc : allDocsIterable)
				{
					if (tmpDoc.getString("huelgaDate").equals(dateString))
					{
						Alumn newAlumn = new Alumn(tmpDoc.getString("name"), tmpDoc.getString("dni"),
								tmpDoc.getString("course"));
						alumList.add(newAlumn);
					}
				}
			}
			catch (MongoTimeoutException e)
			{
				JOptionPane.showMessageDialog(null, "ERROR TIEMPO DE ESPERA AGOTADO... ");
				e.printStackTrace();
			}
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "ERROR DE CONEXION A LA BASE DE DATOS... ");
		}
		return alumList;
	}

	public List<String> getHuelgaDates() throws IESJandulaException
	{
		Set<String> dataSet = new HashSet<>();
		List<String> dateList = new ArrayList<>();

		// Conexion
		String connectionString = this.getConexionStored();

		try
		{
			MongoClient mongoClient = MongoClients.create(connectionString);
			try
			{
				MongoDatabase db = mongoClient.getDatabase("huelgas");

				MongoCollection personas = db.getCollection("huelga");

				FindIterable<Document> allDocsIterable = personas.find();
				for (Document tmpDoc : allDocsIterable)
				{
					String[] temporalArray = tmpDoc.getString("huelgaDate").split("-");
					String dateSpanish = temporalArray[2] + "-" + temporalArray[1] + "-" + temporalArray[0];
					dataSet.add(dateSpanish);
				}
			}
			catch (MongoTimeoutException e)
			{
				JOptionPane.showMessageDialog(null, "ERROR TIEMPO DE ESPERA AGOTADO... ");
				e.printStackTrace();
			}
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "ERROR DE CONEXION A LA BASE DE DATOS... ");
		}
		dateList.addAll(dataSet);
		return dateList;
	}

	/**
	 * Method getAllCourses
	 *
	 * @param alumnList
	 * @return
	 */
	public Set<String> getAllCourses(List<Alumn> alumnList)
	{
		Set<String> allCourses = new HashSet<>();
		for (Alumn alumno : alumnList)
		{
			allCourses.add(alumno.getCourse());
		}
		return allCourses;
	}

	/**
	 * Method removerTildesEnye
	 *	Method for remove characters
	 * @param cadena
	 * @return
	 */
	public static String removerTildesEnye(String cadena)
	{
		return cadena.replace("�", "A").replace("�", "E").replace("�", "I").replace("�", "O").replace("�", "U")
				.replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u")
				.replace('�', '�').replace('�', 'n');
	}

	/**
	 * Method getConexionStored
	 * @return
	 * @throws IESJandulaException 
	 */
	public String getConexionStored() throws IESJandulaException
	{
		String outcome = "";
		BufferedReader fileInputStream = null;

		try
		{
			fileInputStream = new BufferedReader(new FileReader("conexion.cfg"));
			String read = fileInputStream.readLine();
			if (read != null)
			{
				outcome = read;
			}

		}
		catch (FileNotFoundException exception)
		{
			String error = "FileNot Found Exception conexion.cfg getConexionStored";
			logger.error(error,exception);
		}
		catch (IOException exception)
		{
			String error = "IOException conexion.cfg getConexionStored";
			logger.error(error,exception);
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
					String error = "IOException conexion.cfg getConexionStored";
					logger.error(error,exception);
					throw new IESJandulaException(error, exception);
				}
			}
		}

		return outcome;
	}

	/**
	 * Method storeNewConexion
	 * @param newConexion
	 * @throws IESJandulaException 
	 */
	public void storeNewConexion(String newConexion) throws IESJandulaException
	{
		PrintWriter printWriter = null;

		try
		{
			printWriter = new PrintWriter(new File("conexion.cfg"));
			printWriter.println(newConexion);
			printWriter.flush();
		}
		catch (FileNotFoundException exception)
		{
			String error = "FileNot Found Exception conexion.cfg storeNewConexion";
			logger.error(error,exception);
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
