
package org.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Asteroides extends Activity {

	/*CON EL MODIFICADOR STATIC ESTA VARIABLES SE CREARA UNA VEZ Y SERA CONSULTADA
	POR TODAS LAS ISNTANCIAS QUE SE CREEN DE ESTA CLASE ASTEROIDE*/
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.asteroide);

		Button bAcercaDe = (Button) findViewById(R.id.button3);
		Button bCerrar = (Button) findViewById(R.id.button4);
		Button bConfig = (Button) findViewById(R.id.button2);
		Button bjugar = (Button) findViewById(R.id.button1);
		Button bPuntuaciones = (Button) findViewById(R.id.button5);
		
		bPuntuaciones.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				lanzarPuntuaciones(null);
			}
		});

		bjugar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mostrarPreferencias(null);

			}
		});
		bConfig.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				lanzarConfiguracion(null);
			}
		});

		bCerrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cerrar(null);
			}
		});
		bAcercaDe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				lanzarAcercaDe(null);
			}
		});

	}

	public void mostrarPreferencias(View view) {

		SharedPreferences pref = getSharedPreferences(
				"org.example.asteroides_preferences", MODE_PRIVATE);

		String s = "música: " + pref.getBoolean("musica", true)
				+ ", gráficos: " + pref.getString("graficos", "?")
				+ ", fragmentos: " + pref.getString("fragmentos", "3")
				+ ", multijugador: " + pref.getBoolean("multijugador", true)
				+ ", maxjugadores: " + pref.getString("maxjugadores", "5")
				+ ", conexion: " + pref.getString("conexion", "?");

		Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
	}

	public void lanzarAcercaDe(View view) {
		Intent i = new Intent(this, AcercaDe.class);
		startActivity(i);
	}

	public void cerrar(View view) {
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menuprincipal, menu);
		return true;
		/** EL MENU YA ESTA VISIBLE **/
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.acercaDe:
			lanzarAcercaDe(null);
			break;
		case R.id.confg:
			Intent i = new Intent(this, Preferencias.class);
			startActivity(i);
			break;
		}
		return true;
	}

	public void lanzarConfiguracion(View view) {

		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	}

    public void lanzarPuntuaciones(View view) {
		
    	Intent i = new Intent(this, Puntuaciones.class);
    	startActivity(i);
	}
}

