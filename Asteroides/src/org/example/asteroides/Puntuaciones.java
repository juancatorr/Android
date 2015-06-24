package org.example.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Puntuaciones extends ListActivity {

	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);
		
		//1° EJEMPLO DE ARRAYADAPTER
		/*ARRAYADAPTER ACTUA COMO PUENTE ENTRE UN LISTVIEW Y EL SUMINISTRADOR DE INFORMACION
		*EN ESTE CASO CADE ELEMENTO DE LA LISTA ES UN STRING
		*SUS PARAMENTROS : EL PRIMERO EL CONTEXTO
		*EL SGUNDO, ES UN LAYOUT QUE SE UTILIZA PARA REPRESTAR CADA ELEMENTO DE LA LISTA
		*EN ESTE CASO NO DEFINIMOS UNO NUEVO SINO Q USAMOS UNA YA DEFINIDO EN EL SISTEMA
		*EL TERCERO, ARRAY CON LOS STRING QUE MOSTRAR*/
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_dropdown_item_1line,
				Asteroides.almacen.listaPuntuaciones(10));
		
		//2° EJEMPLO DE ARRAY ADAPTER
		ArrayAdapter<String> adaptadorDos = new ArrayAdapter<String>(this, R.layout.elemento_lista, R.id.titulo, Asteroides.almacen.listaPuntuaciones(10));
		

		//3° EJEMPLO DE ADAPTADOR
		MiAdaptador adaptadorTres= new MiAdaptador(this, Asteroides.almacen.listaPuntuaciones(10));
		
		setListAdapter(adaptadorTres);
		
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	
		super.onListItemClick(l, v, position, id);
		Object o = getListAdapter().getItem(position);
		Object o2 = getListAdapter().getItemId(position);
		
		Toast.makeText(this, "seleccion: " + Integer.toString(position) + " - " + o.toString() + " - " + o2.toString(), Toast.LENGTH_LONG).show();
	}
}
