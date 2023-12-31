/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.administracion.huelga_alumnos;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.administracion.exceptions.IESJandulaException;
import es.iesjandula.administracion.huelga_alumnos.utils.Alumn;
import es.iesjandula.administracion.huelga_alumnos.utils.ApplicationHuelgas;

/**
 * @author David Martinez
 *
 */
public class ConsultaHuelga extends javax.swing.JFrame
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();
	
	/** Attribute alumnList*/
	private List<Alumn> alumnList;

	/** Attribute alumCourses*/
	private Set<String> alumCourses;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonAceptar;
	private javax.swing.JButton jButtonHuelgasExistentes;
	private javax.swing.JButton jButtonSalir;
	private com.toedter.calendar.JDateChooser jDateChooser;
	private javax.swing.JLabel jLabelBackground;
	private javax.swing.JLabel jLabelCursoMasAlumnosText;
	private javax.swing.JLabel jLabelCursoMenosAlumnosText;
	private javax.swing.JLabel jLabelCursosNoVanText;
	private javax.swing.JLabel jLabelFecha;
	private javax.swing.JLabel jLabelHuelgaListText;
	private javax.swing.JLabel jLabelJandulaLogo;
	private javax.swing.JLabel jLabelNumeroAlumnos;
	private javax.swing.JLabel jLabelNumeroAlumnosText;
	private javax.swing.JList<String> jList1NoVan;
	private javax.swing.JList<String> jListHuelgasExistentes;
	private javax.swing.JList<String> jListMasAlumnado;
	private javax.swing.JList<String> jListMenosAlumnado;
	private javax.swing.JScrollPane jScrollPaneHuelgasExistente;
	private javax.swing.JScrollPane jScrollPaneMasAlumnado;
	private javax.swing.JScrollPane jScrollPaneMenosAlumnado;
	private javax.swing.JScrollPane jScrollPaneNoVan;
	// End of variables declaration//GEN-END:variables


	/**
	 * Constructor for create new ConsultaHuelga
	 * @param alumnList
	 */
	public ConsultaHuelga(List<Alumn> alumnList)
	{
		this.initComponents();
		this.setResizable(false);
		this.jLabelJandulaLogo.setIcon(new ImageIcon("./images/jandula.png"));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./images/jandula.png"));
		this.jLabelBackground.setIcon(new ImageIcon("./images/background2.jpg"));
		this.setTitle("CONSULTA HUELGA");
		this.alumnList = alumnList;
		this.alumCourses = this.getAlumnCourses();
		this.setLocationRelativeTo(null);

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

		this.jDateChooser = new com.toedter.calendar.JDateChooser();
		this.jLabelFecha = new javax.swing.JLabel();
		this.jLabelNumeroAlumnos = new javax.swing.JLabel();
		this.jButtonAceptar = new javax.swing.JButton();
		this.jButtonSalir = new javax.swing.JButton();
		this.jButtonHuelgasExistentes = new javax.swing.JButton();
		this.jLabelHuelgaListText = new javax.swing.JLabel();
		this.jScrollPaneHuelgasExistente = new javax.swing.JScrollPane();
		this.jListHuelgasExistentes = new javax.swing.JList<>();
		this.jLabelNumeroAlumnosText = new javax.swing.JLabel();
		this.jLabelCursoMasAlumnosText = new javax.swing.JLabel();
		this.jLabelCursoMenosAlumnosText = new javax.swing.JLabel();
		this.jLabelCursosNoVanText = new javax.swing.JLabel();
		this.jScrollPaneNoVan = new javax.swing.JScrollPane();
		this.jList1NoVan = new javax.swing.JList<>();
		this.jLabelJandulaLogo = new javax.swing.JLabel();
		this.jScrollPaneMasAlumnado = new javax.swing.JScrollPane();
		this.jListMasAlumnado = new javax.swing.JList<>();
		this.jScrollPaneMenosAlumnado = new javax.swing.JScrollPane();
		this.jListMenosAlumnado = new javax.swing.JList<>();
		this.jLabelBackground = new javax.swing.JLabel();

		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		this.getContentPane().add(this.jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 240, -1));

		this.jLabelFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelFecha.setText("FECHA");
		this.getContentPane().add(this.jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

		this.jLabelNumeroAlumnos.setBackground(new java.awt.Color(255, 255, 255));
		this.jLabelNumeroAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelNumeroAlumnos.setText("              ");
		this.jLabelNumeroAlumnos.setOpaque(true);
		this.getContentPane().add(this.jLabelNumeroAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 200, -1));

		this.jButtonAceptar.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonAceptar.setText("ACEPTAR");
		this.jButtonAceptar.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelga.this.jButtonAceptarActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 111, 38));

		this.jButtonSalir.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonSalir.setText("SALIR");
		this.jButtonSalir.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelga.this.jButtonSalirActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 111, 38));

		this.jButtonHuelgasExistentes.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonHuelgasExistentes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonHuelgasExistentes.setText("CARGAR");
		this.jButtonHuelgasExistentes.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConsultaHuelga.this.jButtonHuelgasExistentesActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonHuelgasExistentes,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 111, 38));

		this.jLabelHuelgaListText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelHuelgaListText.setText("HUELGAS EXISTENTES:");
		this.getContentPane().add(this.jLabelHuelgaListText, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

		this.jScrollPaneHuelgasExistente.setViewportView(this.jListHuelgasExistentes);

		this.getContentPane().add(this.jScrollPaneHuelgasExistente,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 170, 170));

		this.jLabelNumeroAlumnosText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelNumeroAlumnosText.setText("Num. Alumnos en Huelga:");
		this.getContentPane().add(this.jLabelNumeroAlumnosText,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

		this.jLabelCursoMasAlumnosText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelCursoMasAlumnosText.setText("Cursos con mas Alumnado:");
		this.getContentPane().add(this.jLabelCursoMasAlumnosText,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

		this.jLabelCursoMenosAlumnosText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelCursoMenosAlumnosText.setText("Cursos con menos alumnado:");
		this.getContentPane().add(this.jLabelCursoMenosAlumnosText,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

		this.jLabelCursosNoVanText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelCursosNoVanText.setText("Cursos que no van:");
		this.getContentPane().add(this.jLabelCursosNoVanText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

		this.jScrollPaneNoVan.setViewportView(this.jList1NoVan);

		this.getContentPane().add(this.jScrollPaneNoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 200, 80));
		this.getContentPane().add(this.jLabelJandulaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 140, 90));

		this.jScrollPaneMasAlumnado.setViewportView(this.jListMasAlumnado);

		this.getContentPane().add(this.jScrollPaneMasAlumnado,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 200, 80));

		this.jScrollPaneMenosAlumnado.setViewportView(this.jListMenosAlumnado);

		this.getContentPane().add(this.jScrollPaneMenosAlumnado,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 200, 80));
		this.getContentPane().add(this.jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 450));

		this.pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Method jButtonHuelgasExistentesActionPerformed
	 * @param evt
	 */
	private void jButtonHuelgasExistentesActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonHuelgasExistentesActionPerformed
		Thread butonAceptarLoad = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				LoadingBarPanel barPanel = new LoadingBarPanel();
				barPanel.setVisible(true);
				DefaultListModel<String> listModel = new DefaultListModel<>();
				try
				{
					listModel.addAll(new ApplicationHuelgas().getHuelgaDates());
				}
				catch (IESJandulaException exception)
				{
					String error = "IESJandulaException conexion.cfg getHuelgaDates ConsultaHuelga";
					JOptionPane.showMessageDialog(null,error);
					logger.error(error,exception);
				}
				ConsultaHuelga.this.jListHuelgasExistentes.setModel(listModel);
				barPanel.dispose();
			}
		});
		butonAceptarLoad.start();
	}// GEN-LAST:event_jButtonHuelgasExistentesActionPerformed

	/**
	 * Method jButtonAceptarActionPerformed
	 * @param evt
	 */
	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonAceptarActionPerformed
		if (this.jDateChooser.getDate() != null)
		{
			Thread butonAceptarLoad = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					LoadingBarPanel barPanel = new LoadingBarPanel();
					barPanel.setVisible(true);

					ApplicationHuelgas application = new ApplicationHuelgas();
					List<Alumn> queryAlumList = new ArrayList<>();
					try
					{
						queryAlumList = application.getHuelgaAlumns(ConsultaHuelga.this.jDateChooser.getDate());
					}
					catch (IESJandulaException exception)
					{
						String error = "IESJandulaException conexion.cfg getHuelgaAlumns ConsultaHuelga";
						JOptionPane.showMessageDialog(null,error);
						logger.error(error,exception);
					}

					List<String> moreAlumnsCourseList = new ArrayList<>();
					List<String> lessAlumnsCourseList = new ArrayList<>();

					Map<String, Integer> alumMap = new HashMap<>();

					Set<String> setCourses = application.getAllCourses(queryAlumList);
					Set<String> noCourses = new HashSet<>();

					System.out.println(setCourses);
					System.out.println(noCourses);
					System.out.println(queryAlumList);

					for (String course : ConsultaHuelga.this.alumCourses)
					{
						if (!setCourses.contains(course))
						{
							noCourses.add(course);
						}
					}
					DefaultListModel<String> modelList = new DefaultListModel<>();
					List<String> sortedListNoCourses = new ArrayList<>(noCourses);
					Collections.sort(sortedListNoCourses);
					modelList.addAll(sortedListNoCourses);
					ConsultaHuelga.this.jList1NoVan.setModel(modelList);

					// --COUNT ALUMNS AND COURSE ON THE DATE---
					for (Alumn alumn : queryAlumList)
					{
						if (alumMap.containsKey(alumn.getCourse()))
						{
							alumMap.put(alumn.getCourse(), alumMap.get(alumn.getCourse()) + 1);
						}
						else
						{
							alumMap.put(alumn.getCourse(), 1);
						}
					}

					// --MAX VALUE---
					Integer maxValue = 0;
					for (Map.Entry<String, Integer> entry : alumMap.entrySet())
					{
						if (entry.getValue() > maxValue)
						{
							maxValue = entry.getValue();
						}
					}
					for (Map.Entry<String, Integer> entry : alumMap.entrySet())
					{
						if (entry.getValue() == maxValue)
						{
							moreAlumnsCourseList.add(entry.getKey());
						}
					}

					// ---MIN VALUE---
					Integer minValue = maxValue;
					for (Map.Entry<String, Integer> entry : alumMap.entrySet())
					{
						if (entry.getValue() < minValue)
						{
							minValue = entry.getValue();
						}
					}

					for (Map.Entry<String, Integer> entry : alumMap.entrySet())
					{
						if (entry.getValue() == minValue)
						{
							lessAlumnsCourseList.add(entry.getKey());
						}
					}
					System.out.println(moreAlumnsCourseList);
					System.out.println(lessAlumnsCourseList);

					System.out.println(alumMap);

					DefaultListModel<String> moreModel = new DefaultListModel<>();
					Collections.sort(moreAlumnsCourseList);
					moreModel.addAll(moreAlumnsCourseList);
					ConsultaHuelga.this.jListMasAlumnado.setModel(moreModel);

					DefaultListModel<String> lessModel = new DefaultListModel<>();
					Collections.sort(lessAlumnsCourseList);
					lessModel.addAll(lessAlumnsCourseList);
					ConsultaHuelga.this.jListMenosAlumnado.setModel(lessModel);

					ConsultaHuelga.this.jLabelNumeroAlumnos.setText(queryAlumList.size() + "");

					barPanel.dispose();
				}
			});
			butonAceptarLoad.start();

		}
		else
		{
			JOptionPane.showMessageDialog(null, "NO HAY FECHA SELECCIONADA");
		}
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
	 * Method getAlumnCourses
	 * @return
	 */
	private Set<String> getAlumnCourses()
	{
		ApplicationHuelgas application = new ApplicationHuelgas();
		return application.getAllCourses(this.alumnList);
	}
}
