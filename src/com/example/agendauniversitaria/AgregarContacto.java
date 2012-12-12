package com.example.agendauniversitaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregarContacto extends Activity implements OnClickListener{
	
	LinearLayout menu;
	EditText nombre, usuario, telefono, correo;
	 Spinner spinner;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_contacto);
        
        spinner = (Spinner) findViewById(R.id.tipo);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	             R.array.tipo_contacto, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    
	    menu = (LinearLayout)findViewById(R.id.menu);
	    
	    nombre = (EditText)findViewById(R.id.nombre);
	    usuario = (EditText)findViewById(R.id.usuario);
	    telefono = (EditText)findViewById(R.id.numero);
	    correo = (EditText)findViewById(R.id.correo);

	    menu.setOnClickListener(this);
	    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_agenda_universitaria, menu);
        return true;
    }

	public void onClick(View v) {

		switch(v.getId())
		{
		case R.id.menu:
			
			String us = usuario.getText().toString(), 
				nom = nombre.getText().toString(), 
				tel = telefono.getText().toString(), 
				cor = correo.getText().toString(), 
				tipo_usuario = spinner.getSelectedItem().toString();
			
			usuario.setText("");
			correo.setText("");
			nombre.setText("");
			telefono.setText("");
			
			Telefonos insertar = new Telefonos(AgregarContacto.this);
			insertar.abrir();
			insertar.guardarRegistro(us, nom, tel, cor, tipo_usuario);
			insertar.cerrar();
			
			Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_LONG).show();
			break;
		
		}
		
		
	}
}
