
package es.iesjandula.administracion.huelga_alumnos;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.administracion.exceptions.IESJandulaException;
import es.iesjandula.administracion.huelga_alumnos.utils.ApplicationHuelgas;

/**
 * @author David Martinez
 *
 */
public class ConfigurationWindow extends javax.swing.JFrame
{
	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();
	/** Attribute menuHuelga */
	private MenuHuelga menuHuelga;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonAceptar;
	private javax.swing.JButton jButtonPreCargar;
	private javax.swing.JButton jButtonSalir;
	private javax.swing.JEditorPane jEditorPaneNewConexion;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabelBackground;
	private javax.swing.JLabel jLabelConexionActual;
	private javax.swing.JLabel jLabelConexionMongoText;
	private javax.swing.JLabel jLabelEditarConexion;
	private javax.swing.JLabel jLabelJandulaLogo;
	private javax.swing.JScrollPane jScrollPane;
	// End of variables declaration//GEN-END:variables

	/**
	 * Constructor for create new ConfigurationWindow
	 *
	 * @param menuHuelga
	 */
	public ConfigurationWindow(MenuHuelga menuHuelga)
	{
		this.initComponents();
		this.jLabelBackground.setIcon(new ImageIcon("./images/background2.jpg"));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./images/jandula.png"));
		this.jLabelJandulaLogo.setIcon(new ImageIcon("./images/jandula.png"));
		this.setTitle("CONEXION CONFIGURATION");
		this.menuHuelga = menuHuelga;
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		try
		{
			this.jLabelConexionActual.setText(new ApplicationHuelgas().getConexionStored().trim());
		}
		catch (IESJandulaException exception)
		{
			String error = "IESJandulaException conexion.cfg getConexionStored ConfigurationWindow";
			JOptionPane.showMessageDialog(null,error);
			logger.error(error,exception);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		this.jButtonSalir = new javax.swing.JButton();
		this.jLabelConexionMongoText = new javax.swing.JLabel();
		this.jLabelConexionActual = new javax.swing.JLabel();
		this.jLabelEditarConexion = new javax.swing.JLabel();
		this.jScrollPane = new javax.swing.JScrollPane();
		this.jEditorPaneNewConexion = new javax.swing.JEditorPane();
		this.jButtonPreCargar = new javax.swing.JButton();
		this.jButtonAceptar = new javax.swing.JButton();
		this.jLabel1 = new javax.swing.JLabel();
		this.jLabelJandulaLogo = new javax.swing.JLabel();
		this.jLabelBackground = new javax.swing.JLabel();

		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		this.jButtonSalir.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonSalir.setText("VOLVER");
		this.jButtonSalir.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConfigurationWindow.this.jButtonSalirActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 120, 38));

		this.jLabelConexionMongoText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelConexionMongoText.setText("CONEXION CON MONGO ATLAS ACTUAL:");
		this.getContentPane().add(this.jLabelConexionMongoText,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		this.jLabelConexionActual.setBackground(new java.awt.Color(255, 255, 255));
		this.jLabelConexionActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		this.jLabelConexionActual.setText(" ");
		this.jLabelConexionActual.setOpaque(true);
		this.getContentPane().add(this.jLabelConexionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 830, 32));

		this.jLabelEditarConexion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelEditarConexion.setText("EDITAR CONEXION:");
		this.getContentPane().add(this.jLabelEditarConexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

		this.jScrollPane.setViewportView(this.jEditorPaneNewConexion);

		this.getContentPane().add(this.jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 830, 90));

		this.jButtonPreCargar.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonPreCargar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonPreCargar.setText("PRE-CARGAR");
		this.jButtonPreCargar.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConfigurationWindow.this.jButtonPreCargarActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonPreCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 120, 40));

		this.jButtonAceptar.setBackground(new java.awt.Color(203, 203, 203));
		this.jButtonAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonAceptar.setText("GUARDAR");
		this.jButtonAceptar.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ConfigurationWindow.this.jButtonAceptarActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 120, 38));

		this.jLabel1.setBackground(new java.awt.Color(255, 253, 238));
		this.jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabel1.setForeground(new java.awt.Color(2, 78, 0));
		this.jLabel1.setText(
				"EJEMPLO: mongodb+srv://<user>:<userpassword>@<clustername>.seaqmmw.mongodb.net/?retryWrites=true&w=majority ");
		this.jLabel1.setOpaque(true);
		this.getContentPane().add(this.jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

		this.jLabelJandulaLogo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.getContentPane().add(this.jLabelJandulaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 390, 90));
		this.getContentPane().add(this.jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 390));

		this.pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Method jButtonSalirActionPerformed
	 *
	 * @param evt
	 */
	private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonSalirActionPerformed
		this.menuHuelga.setVisible(true);
		this.menuHuelga.setLocationRelativeTo(null);
		this.dispose();
	}// GEN-LAST:event_jButtonSalirActionPerformed

	/**
	 * Method jButtonAceptarActionPerformed
	 *
	 * @param evt
	 */
	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonAceptarActionPerformed
		ApplicationHuelgas application = new ApplicationHuelgas();
		try
		{
			application.storeNewConexion(this.jEditorPaneNewConexion.getText().trim());
		}
		catch (IESJandulaException exception)
		{
			String error = "IESJandulaException conexion.cfg storeNewConexion ConfigurationWindow";
			JOptionPane.showMessageDialog(null,error);
			logger.error(error,exception);
		}
	}// GEN-LAST:event_jButtonAceptarActionPerformed

	/**
	 * Method jButtonPreCargarActionPerformed
	 *
	 * @param evt
	 */
	private void jButtonPreCargarActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonPreCargarActionPerformed
		this.jLabelConexionActual.setText(this.jEditorPaneNewConexion.getText().trim());
	}// GEN-LAST:event_jButtonPreCargarActionPerformed

}