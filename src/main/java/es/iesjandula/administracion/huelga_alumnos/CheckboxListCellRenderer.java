/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesjandula.administracion.huelga_alumnos;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


/**
 * @author David Martinez
 *
 */
public class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer
{

	/**
	 * Method getListCellRendererComponent
	 * @param list
	 * @param value
	 * @param index
	 * @param isSelected
	 * @param cellHasFocus
	 * @return
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus)
	{

		this.setComponentOrientation(list.getComponentOrientation());
		this.setFont(list.getFont());
		this.setBackground(list.getBackground());
		this.setForeground(list.getForeground());
		this.setSelected(isSelected);
		this.setEnabled(list.isEnabled());

		this.setText(value == null ? "" : value.toString());

		return this;
	}
}