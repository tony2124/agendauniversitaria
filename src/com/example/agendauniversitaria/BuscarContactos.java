package com.example.agendauniversitaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BuscarContactos extends Activity implements OnClickListener{
	
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_contacto);
        
        ListView listView = (ListView) findViewById(R.id.lista);
        
        Telefonos insertar = new Telefonos(BuscarContactos.this);
		insertar.abrir();
		String datos [][] = insertar.listar();
		insertar.cerrar();
        
		String registros [] = new String [datos.length];
		
		for(int i = 0; i < datos.length; i++)
		   registros [i] = datos[i][1];
		
		
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, registros);

        listView.setAdapter(adapter); 
	    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_agenda_universitaria, menu);
        return true;
    }

	public void onClick(View v) {

		switch(v.getId())
		{
		
		
		}
		
		
	}
}
