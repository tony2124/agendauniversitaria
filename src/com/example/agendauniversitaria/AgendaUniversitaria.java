package com.example.agendauniversitaria;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AgendaUniversitaria extends Activity implements OnClickListener{
	Button botonLlamar, botonSMS, botonWeb;
	Button botonMarcar, botonLlamarTel;
	Button enviarSMS, visitar;
	Button agregarContacto, buscarContacto;
	
	EditText tel, numeroSMS, mensajeSMS, url;
	ImageView twitter, facebook, hotmail, gmail, itsa;
	LinearLayout opcion0, opcion1, opcion2, opcion3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_universitaria);
        
        botonLlamar = (Button)findViewById(R.id.botonLlamar);
        botonSMS = (Button)findViewById(R.id.botonSMS);
        botonWeb = (Button)findViewById(R.id.botonWeb);
        
        botonMarcar = (Button)findViewById(R.id.marcar);
        botonLlamarTel = (Button)findViewById(R.id.llamar);
        enviarSMS = (Button)findViewById(R.id.enviarSMS);
        visitar = (Button)findViewById(R.id.visitar);
        
        agregarContacto = (Button)findViewById(R.id.agregarContacto);
        buscarContacto = (Button)findViewById(R.id.buscarContacto);
        
        tel = (EditText) findViewById(R.id.tel);
        numeroSMS = (EditText) findViewById(R.id.numeroSMS);
        mensajeSMS = (EditText) findViewById(R.id.mensajeSMS);
        url = (EditText) findViewById(R.id.url);
        
        facebook = (ImageView)findViewById(R.id.facebook);
        twitter = (ImageView)findViewById(R.id.twitter);
        gmail = (ImageView)findViewById(R.id.gmail);
        hotmail = (ImageView)findViewById(R.id.hotmail);
        itsa = (ImageView)findViewById(R.id.itsa);
        
        opcion0  = (LinearLayout)findViewById(R.id.opcion0);
        opcion1  = (LinearLayout)findViewById(R.id.opcion1);
        opcion2  = (LinearLayout)findViewById(R.id.opcion2);
        opcion3  = (LinearLayout)findViewById(R.id.opcion3);
        
        opcion0.setVisibility(View.VISIBLE);
        opcion1.setVisibility(View.GONE);
        opcion2.setVisibility(View.GONE);
        opcion3.setVisibility(View.GONE);

        botonLlamar.setOnClickListener(this);
        botonSMS.setOnClickListener(this);
        botonWeb.setOnClickListener(this);

        botonMarcar.setOnClickListener(this);
        botonLlamarTel.setOnClickListener(this);

        enviarSMS.setOnClickListener(this);
        visitar.setOnClickListener(this);

        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        gmail.setOnClickListener(this);
        hotmail.setOnClickListener(this);
        itsa.setOnClickListener(this);
        
        agregarContacto.setOnClickListener(this);
        buscarContacto.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_agenda_universitaria, menu);
        return true;
    }

	public void onClick(View v) {
		Intent intento;
		switch(v.getId())
		{
			case R.id.botonLlamar:
				opcion0.setVisibility(View.GONE);
		        opcion1.setVisibility(View.VISIBLE);
		        opcion2.setVisibility(View.GONE);
		        opcion3.setVisibility(View.GONE);
				
				break;
				
			case R.id.botonSMS:
				opcion0.setVisibility(View.GONE);
		        opcion1.setVisibility(View.GONE);
		        opcion2.setVisibility(View.VISIBLE);
		        opcion3.setVisibility(View.GONE);
				
				break;
				
			case R.id.botonWeb:
				opcion0.setVisibility(View.GONE);
		        opcion1.setVisibility(View.GONE);
		        opcion2.setVisibility(View.GONE);
		        opcion3.setVisibility(View.VISIBLE);
				
				break;
				
			case R.id.marcar:
				Intent i = new Intent(this, Marcacion.class);
				startActivity(i);
				break;
			
			case R.id.llamar:
				
				String nt = tel.getText().toString();
				if(nt.compareTo("") == 0)
				{
					Toast.makeText(this, "Introduzca un número de teléfono válido", Toast.LENGTH_LONG).show();
					return;
				}
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + nt ));
				startActivity(intent); 
				break;
			
			case R.id.enviarSMS:
				
				String mensaje = mensajeSMS.getText().toString();
				String num = numeroSMS.getText().toString();
				
				if(mensaje.compareTo("") == 0 || num.compareTo("") == 0)
				{
					Toast.makeText(this, "Introduzca un número de teléfono y el mensaje", Toast.LENGTH_LONG).show();
					return;
				}
				SmsManager sms = SmsManager.getDefault();
				sms.sendTextMessage(num, null, mensaje, null, null);
				Toast.makeText(this, "Mensaje enviado", Toast.LENGTH_LONG).show();
				
				break;
				
			case R.id.visitar:
				String url_name = url.getText().toString();
				if(url_name.compareTo("") == 0)
				{
					Toast.makeText(this, "Introduzca una URL válida", Toast.LENGTH_LONG).show();
					return;
				}
				
				intento= new Intent("android.intent.action.VIEW", Uri.parse("http://"+url_name) );
			    startActivity(intento);				
				break;
			
			case R.id.twitter:
				intento = new Intent("android.intent.action.VIEW", Uri.parse("http://twitter.com") );
			    startActivity(intento);				
				break;
				
			case R.id.facebook:
				intento = new Intent("android.intent.action.VIEW", Uri.parse("http://facebook.com") );
			    startActivity(intento);				
				break;
				
			case R.id.gmail:
				intento = new Intent("android.intent.action.VIEW", Uri.parse("http://gmail.com") );
			    startActivity(intento);				
				break;
				
			case R.id.hotmail:
				intento = new Intent("android.intent.action.VIEW", Uri.parse("http://hotmail.com") );
			    startActivity(intento);				
				break;
				
			case R.id.itsa:
				intento = new Intent("android.intent.action.VIEW", Uri.parse("http://itsa.edu.mx") );
			    startActivity(intento);				
				break;
				
			case R.id.agregarContacto:
				intento = new Intent(this, AgregarContacto.class );
			    startActivity(intento);				
				break;
				
			case R.id.buscarContacto:
				intento = new Intent(this, BuscarContactos.class );
			    startActivity(intento);				
				break;
			
				
		
		}
		
		
	}
}
