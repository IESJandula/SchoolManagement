/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.administracion.huelga_alumnos;

import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.iesjandula.administracion.exceptions.IESJandulaException;
import es.iesjandula.administracion.huelga_alumnos.utils.Alumn;
import es.iesjandula.administracion.huelga_alumnos.utils.ApplicationHuelgas;

/**
 * @author David Martinez
 *
 */
public class ConsultaHuelgaCurso extends javax.swing.JFrame
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();
	
	/** Attribute alumnList */
	private List<Alumn> alumnList;

	/** Attribute queryAlumList */
	private List<Alumn> queryAlumList;

	/** Attribute queryModelList */
	private DefaultListModel<Alumn> queryModelList;

	/** Attribute newPage */
	private boolean newPage;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private java.awt.Choice choiceCurso;
	private javax.swing.JButton jButtonAceptar;
	private javax.swing.JButton jButtonBorrar;
	private javax.swing.JButton jButtonPdf;
	private javax.swing.JButton jButtonSalir;
	private com.toedter.calendar.JDateChooser jDateChooser;
	private javax.swing.JLabel jLabelBackground;
	private javax.swing.JLabel jLabelCurso;
	private javax.swing.JLabel jLabelHuelga;
	private javax.swing.JLabel jLabelJandulaLogo;
	private javax.swing.JLabel jLabelNewPage;
	private javax.swing.JLabel jLabelPdfActualName;
	private javax.swing.JList<Alumn> jListAllAlumns;
	private javax.swing.JScrollPane jScrollPane;
	private javax.swing.JTextField jTextFieldPdfName;
	private javax.swing.JToggleButton jToggleButtonNewPages;
	// End of variables declaration//GEN-END:variables

	/**
	 * Constructor for create new ConsultaHuelgaCurso
	 *
	 * @param alumnList
	 */
	public ConsultaHuelgaCurso(List<Alumn> alumnList)
	{
		this.initComponents();
		this.newPage = false;
		this.setResizable(false);
		this.setTitle("CONSULTA HUELGAS CURSO");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./images/jandula.png"));

		this.jLabelBackground.setIcon(new ImageIcon("./images/background2.jpg"));
		this.jLabelJandulaLogo.setIcon(new ImageIcon("./images/jandula.png"));

		this.jListAllAlumns.setCellRenderer(new CheckboxListCellRenderer());
		this.queryAlumList = new ArrayList<>();
		this.queryModelList = new DefaultListModel<>();
		this.setLocationRelativeTo(null);
		this.alumnList = alumnList;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		this.choiceCurso = new java.awt.Choice();
		this.jLabelCurso = new javax.swing.JLabel();
		this.jDateChooser = new com.toedter.calendar.JDateChooser();
		this.jLabelHuelga = new javax.swing.JLabel();
		this.jScrollPane = new javax.swing.JScrollPane();
		this.jListAllAlumns = new javax.swing.JList<>();
		this.jButtonAceptar = new javax.swing.JButton();
		this.jButtonSalir = new javax.swing.JButton();
		this.jLabelNewPage = new javax.swing.JLabel();
		this.jToggleButtonNewPages = new javax.swing.JToggleButton();
		this.jLabelJandulaLogo = new javax.swing.JLabel();
		this.jButtonPdf = new javax.swing.JButton();
		this.jButtonBorrar = new javax.swing.JButton();
		this.jTextFieldPdfName = new javax.swing.JTextField();
		this.jLabelPdfActualName = new javax.swing.JLabel();
		this.jLabelBackground = new javax.swing.JLabel();

		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		this.choiceCurso.addItemListener(new java.awt.event.ItemListener()
		{
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				ConsultaHuelgaCurso.this.choiceCursoItemStateChanged(evt);
			}
		});
		this.getContentPane().add(this.choiceCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 160, -1));

		this.jLabelCurso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelCurso.setText("CURSO:");
		this.getContentPane().add(this.jLabelCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));
		this.getContentPane().add(this.jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 200, -1));

		this.jLabelHuelga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelHuelga.setText("HUELGA:");
		this.getContentPane().add(this.jLabelHuelga, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

		this.jListAllAlumns.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		this.jScrollPane.setViewportView(this.jListAllAlumns);

		this.getContentPane().add(this.jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 87, 630, 210));

		this.jButtonAceptar.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonAceptar.setText("ACEPTAR");
		this.jButtonAceptar.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelgaCurso.this.jButtonAceptarActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 130, 38));

		this.jButtonSalir.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonSalir.setText("SALIR");
		this.jButtonSalir.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelgaCurso.this.jButtonSalirActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 130, 38));

		this.jLabelNewPage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelNewPage.setText("NUEVA PAGINA");
		this.getContentPane().add(this.jLabelNewPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));

		this.jToggleButtonNewPages.setBackground(new java.awt.Color(203, 203, 203));
		this.jToggleButtonNewPages.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jToggleButtonNewPages.setText("OFF");
		this.jToggleButtonNewPages.setOpaque(true);
		this.jToggleButtonNewPages.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelgaCurso.this.jToggleButtonNewPagesActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jToggleButtonNewPages,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 60, 30));
		this.getContentPane().add(this.jLabelJandulaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 140, 90));

		this.jButtonPdf.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonPdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonPdf.setText("GENERAR PDF");
		this.jButtonPdf.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelgaCurso.this.jButtonPdfActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 40));

		this.jButtonBorrar.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonBorrar.setText("BORRAR SELECCIONADOS");
		this.jButtonBorrar.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelgaCurso.this.jButtonBorrarActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 17, -1, 40));

		this.jTextFieldPdfName.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelgaCurso.this.jTextFieldPdfNameActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jTextFieldPdfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 180, 30));

		this.jLabelPdfActualName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelPdfActualName.setText("NO HUELGA SELECTED");
		this.getContentPane().add(this.jLabelPdfActualName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));
		this.getContentPane().add(this.jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 430));

		this.pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Method jButtonBorrarActionPerformed
	 * @param evt
	 */
	private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonBorrarActionPerformed
		if (this.jListAllAlumns.getSelectedValuesList().size() > 0)
		{
			ApplicationHuelgas application = new ApplicationHuelgas();
			try
			{
				application.deleteHuelga(this.jListAllAlumns.getSelectedValuesList(), this.jDateChooser.getDate());
			}
			catch (IESJandulaException exception)
			{
				String error = "IESJandulaException conexion.cfg deleteHuelga getSelectedValuesList ConsultaHuelgaCurso";
				JOptionPane.showMessageDialog(null,error);
				logger.error(error,exception);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "NO HAY ALUMNOS SELECCIONADOS");
		}
	}// GEN-LAST:event_jButtonBorrarActionPerformed

	/**
	 * Method jTextFieldPdfNameActionPerformed
	 * @param evt
	 */
	private void jTextFieldPdfNameActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jTextFieldPdfNameActionPerformed
		if (!this.jTextFieldPdfName.getText().trim().isBlank())
		{
			this.jLabelPdfActualName.setText(this.jTextFieldPdfName.getText().trim() + ".pdf");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No se pueden introducir nombres en blanco");
		}

	}// GEN-LAST:event_jTextFieldPdfNameActionPerformed

	/**
	 * Method jToggleButtonNewPagesActionPerformed
	 * @param evt
	 */
	private void jToggleButtonNewPagesActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jToggleButtonNewPagesActionPerformed
		if (this.jToggleButtonNewPages.isSelected())
		{
			this.newPage = true;
			this.jToggleButtonNewPages.setText("ON");
		}
		else
		{
			this.newPage = false;
			this.jToggleButtonNewPages.setText("OFF");

		}
		System.out.println(this.newPage);
	}// GEN-LAST:event_jToggleButtonNewPagesActionPerformed

	/**
	 * Method jButtonAceptarActionPerformed
	 * @param evt
	 */
	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonAceptarActionPerformed

		// JOptionPane.showMessageDialog(null, "ESPERE...");
		Thread acceptButton = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				LoadingBarPanel barPanel = new LoadingBarPanel();
				barPanel.setVisible(true);
				String pattern = "dd-MM-yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				if (ConsultaHuelgaCurso.this.jDateChooser.getDate() != null)
				{

					ApplicationHuelgas application = new ApplicationHuelgas();
					String dateString = simpleDateFormat.format(ConsultaHuelgaCurso.this.jDateChooser.getDate());

					ConsultaHuelgaCurso.this.jLabelPdfActualName.setText("Huelga-" + dateString + ".pdf");

					// ---GETTING THE QUERY ALUMNS LIST AND MODEL---
					ConsultaHuelgaCurso.this.queryModelList = new DefaultListModel<>();
					ConsultaHuelgaCurso.this.queryAlumList = new ArrayList<>();
					try
					{
						ConsultaHuelgaCurso.this.queryAlumList = application.getHuelgaAlumns(ConsultaHuelgaCurso.this.jDateChooser.getDate());
					}
					catch (IESJandulaException exception)
					{
						String error = "IESJandulaException conexion.cfg getHuelgaAlumns getSelectedValuesList ConsultaHuelgaCurso";
						JOptionPane.showMessageDialog(null,error);
						logger.error(error,exception);
					}

					ConsultaHuelgaCurso.this.queryModelList.addAll(ConsultaHuelgaCurso.this.queryAlumList);
					ConsultaHuelgaCurso.this.jListAllAlumns.setModel(ConsultaHuelgaCurso.this.queryModelList);

					System.out.println(ConsultaHuelgaCurso.this.jListAllAlumns);

					// ---REMOVE ALL CURSES FROM CHOICE AND PUT ONLY THE NECESARY COURSES FROM THE
					// QUERY----
					ConsultaHuelgaCurso.this.choiceCurso.removeAll();
					Set<String> setCourses = new HashSet<>();
					setCourses = application.getAllCourses(ConsultaHuelgaCurso.this.queryAlumList);

					List<String> sortedList = new ArrayList<>(setCourses);
					Collections.sort(sortedList);
					ConsultaHuelgaCurso.this.choiceCurso.add("Todos");
					for (String course : sortedList)
					{
						ConsultaHuelgaCurso.this.choiceCurso.add(course);
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "NO HAY FECHA SELECCIONADA");
				}
				barPanel.dispose();
			}
		});
		acceptButton.start();

	}// GEN-LAST:event_jButtonAceptarActionPerformed

	/**
	 * Method jButtonSalirActionPerformed
	 * @param evt
	 */
	private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonSalirActionPerformed
		MenuHuelga menuHuelga = new MenuHuelga(this.alumnList);
		menuHuelga.setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jButtonSalirActionPerformed

	/**
	 * Method choiceCursoItemStateChanged
	 * @param evt
	 */
	private void choiceCursoItemStateChanged(java.awt.event.ItemEvent evt)
	{// GEN-FIRST:event_choiceCursoItemStateChanged
		List<Alumn> temporalList = new ArrayList<>();

		if (!this.choiceCurso.getSelectedItem().equals("Todos"))
		{
			for (Alumn alumn : this.queryAlumList)
			{
				if (alumn.getCourse().equalsIgnoreCase(this.choiceCurso.getSelectedItem()))
				{
					temporalList.add(alumn);
					System.out.println(alumn);
				}
			}
			DefaultListModel<Alumn> temporalListModel = new DefaultListModel<>();
			temporalListModel.addAll(temporalList);
			this.jListAllAlumns.setModel(temporalListModel);
		}
		else
		{
			this.jListAllAlumns.setModel(this.queryModelList);
		}
	}// GEN-LAST:event_choiceCursoItemStateChanged

	/**
	 * Method jButtonPdfActionPerformed
	 * @param evt
	 */
	private void jButtonPdfActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButton1ActionPerformed

		if (this.queryModelList.size() <= 0)
		{
			JOptionPane.showMessageDialog(null, "NO SE PUEDE GENERAR PDF NO HAY ALUMNOS");
		}
		else
		{
			String pattern = "dd-MM-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String dateString = simpleDateFormat.format(this.jDateChooser.getDate());

			Set<String> setCourses = new HashSet<>();
			ApplicationHuelgas application = new ApplicationHuelgas();
			setCourses = application.getAllCourses(this.queryAlumList);
			List<String> sortLisCourses = new ArrayList(setCourses);
			Collections.sort(sortLisCourses);

			try
			{
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(this.jLabelPdfActualName.getText()));

				document.open();
				Font font = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 24, BaseColor.BLACK);
				document.add(new Paragraph("Instituto - I.E.S JANDULA", font));
				font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
				document.add(new Paragraph("ALUMNOS PARTICIPANTES EN LA HUELGA DEL " + dateString, font));
				font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);

				if (this.choiceCurso.getSelectedItem().equals("Todos"))
				{
					for (String course : sortLisCourses)
					{
						font = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 16, BaseColor.RED);
						document.add(new Paragraph("", font));
						document.add(new Paragraph("", font));
						document.add(new Paragraph("ALUMNOS DE " + course + ":", font));
						for (Alumn alumn : this.queryAlumList)
						{
							if (alumn.getCourse().equals(course))
							{
								font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
								document.add(new Paragraph(alumn.getName(), font));
							}

						}
						if (this.newPage)
						{
							document.newPage();
						}
					}
				}
				else
				{

					font = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 16, BaseColor.RED);
					document.add(new Paragraph("", font));
					document.add(new Paragraph("", font));
					document.add(new Paragraph("ALUMNOS DE " + this.choiceCurso.getSelectedItem() + ":", font));
					for (Alumn alumn : this.queryAlumList)
					{
						if (alumn.getCourse().equals(this.choiceCurso.getSelectedItem()))
						{
							font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
							document.add(new Paragraph(alumn.getName(), font));
						}

					}

				}

				document.close();

			}
			catch (FileNotFoundException exception)
			{
				String error = "IESJandulaException FileNotFoundException PDF";
				JOptionPane.showMessageDialog(null,error);
				logger.error(error,exception);
			}
			catch (IOException exception)
			{
				String error = "IESJandulaException IOException PDF";
				JOptionPane.showMessageDialog(null,error);
				logger.error(error,exception);
			}
			catch (DocumentException exception)
			{
				String error = "IESJandulaException DocumentException PDF";
				JOptionPane.showMessageDialog(null,error);
				logger.error(error,exception);
			}
		}
	}// GEN-LAST:event_jButton1ActionPerformed

}
