package org.example.asteroides;

import java.lang.annotation.Retention;
import java.util.Vector;

import org.w3c.dom.Text;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MiAdaptador extends BaseAdapter{
	
	private final Activity actividad;
	private final Vector<String> lista;

	public MiAdaptador( Activity a, Vector<String> lista) {
	
		super();
		actividad=a;
		this.lista = lista;
	}
	@Override
	public int getCount() {

		return lista.size();
	}

	@Override
	public Object getItem(int arg0) {

		return lista.elementAt(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	/*Este metodo nos va a devolver la vista que se agregara en la lista
	 * en la posicion position. Podemos partir de una Vista previa convertView
	 * para crear la vista a devolver mas rapido. Y por ultimo
	 * parent es el padre al que la vista pertenece	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflanter = actividad.getLayoutInflater();
		View view = inflanter.inflate(R.layout.elemento_lista, null, true);
		
		TextView textView = (TextView) view.findViewById(R.id.titulo);
		TextView textViewDos = (TextView) view.findViewById(R.id.subtitulo);
		
		textView.setText(lista.elementAt(position));
		
		ImageView imagenView = (ImageView) view.findViewById(R.id.icono);
		
		switch (Math.round((float)Math.random()*3)) {
		case 0:
			
			imagenView.setImageResource(R.drawable.asteroide1);
			textViewDos.setText("Asteroide Uno");
			break;
		case 1:
			
			imagenView.setImageResource(R.drawable.asteroide2);
			textViewDos.setText("Asteroide Dos");
			break;
		default:
			imagenView.setImageResource(R.drawable.asteroide3);
			textViewDos.setText("Asteroide Tres");
			break;
		}
		return view;
	}

}
