package org.example.asteroides;

import java.util.Vector;

//INTERFACE ES UNA CLASE ABSTRACTA PURA DONDE PUEDO DEFINIR LA FRIMA DE UN METODO PERO NO LO IMPLEMENTO
public interface AlmacenPuntuaciones {

	public void guardarPuntuacion(int puntos, String nombre, long fecha);
	public Vector<String> listaPuntuaciones(int cantaidad);
}
