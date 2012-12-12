package com.example.agendauniversitaria;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Marcacion extends Activity implements OnClickListener
{
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bas, bgato, marcar;
	String cadena;
	EditText tel;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcacion);
        cadena = "";
        b0 = (Button)findViewById(R.id.button1);
        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);
        b3 = (Button)findViewById(R.id.button4);
        b4 = (Button)findViewById(R.id.button5);
        b5 = (Button)findViewById(R.id.button6);
        b6 = (Button)findViewById(R.id.button7);
        b7 = (Button)findViewById(R.id.button8);
        b8 = (Button)findViewById(R.id.button9);
        b9 = (Button)findViewById(R.id.button10);
        bas = (Button)findViewById(R.id.button11);
        bgato = (Button)findViewById(R.id.button12);
        marcar = (Button)findViewById(R.id.button13);
        
        tel = (EditText)findViewById(R.id.tel);
        
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bas.setOnClickListener(this);
        bgato.setOnClickListener(this);
        marcar.setOnClickListener(this);
        
    }
    
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.button1: cadena += "1"; tel.setText(cadena);break;
			case R.id.button2: cadena += "2";tel.setText(cadena);break;
			case R.id.button3: cadena += "3";tel.setText(cadena);break;
			case R.id.button4: cadena += "4";tel.setText(cadena);break;
			case R.id.button5: cadena += "5";tel.setText(cadena);break;
			case R.id.button6: cadena += "6";tel.setText(cadena);break;
			case R.id.button7: cadena += "7";tel.setText(cadena);break;
			case R.id.button8: cadena += "8";tel.setText(cadena);break;
			case R.id.button9: cadena += "9";tel.setText(cadena);break;
			case R.id.button10: cadena += "#";tel.setText(cadena);break;
			case R.id.button11: cadena += "0";tel.setText(cadena);break;
			case R.id.button12: cadena += "*";tel.setText(cadena);break;
			case R.id.button13: 
				Intent i = new Intent(Intent.ACTION_CALL);
				i.setData(Uri.parse("tel:" + cadena));
				startActivity(i); 
			break;
		}
		
	}
}