package es.iesjandula.administracion.huelga_alumnos.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author David Martinez
 *
 */
@Data
@AllArgsConstructor
public class Alumn
{
	private String name;

	private String dni;

	private String course;

	@Override
	public String toString()
	{
		return this.name;
	}
}
