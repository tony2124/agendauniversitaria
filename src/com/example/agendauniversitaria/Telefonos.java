package com.example.agendauniversitaria;
/********************************************************************
 * 
 * Autor: Alfonso Calderón Chávez
 * Versión: 1.0
 * Descripción de la clase: Contiene las diferentes operaciones 
 * 		para realizar con la base de datos de la agenda electrónica
 * Creado para la materia de Programación Móvil 2. 
 * 
 *******************************************************************/

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Telefonos{
	
	private static final String NOMBRE_BD="telefonos";
	private static final int VERSION_BD=1;
	
	private BDHelper nHelper;
	private final Context nContext;
	private SQLiteDatabase nBD;
	
	public class BDHelper extends SQLiteOpenHelper{

		public BDHelper(Context context) {
			super(context, NOMBRE_BD, null, VERSION_BD);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE contactos ( id INTEGER AUTO_INCREMENT PRIMARY KEY, usuario TEXT NOT NULL , nombre_persona TEXT NOT NULL, numero_telefono TEXT NOT NULL, correo_electronico TEXT NOT NULL, tipo_usuario TEXT NOT NULL)" );
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS contactos");
			onCreate(db);
		}
		
		
	}
	
	public Telefonos(Context c)
	{
		nContext = c;
	}
	
	public Telefonos abrir(){
		nHelper = new BDHelper(nContext);
		nBD = nHelper.getWritableDatabase();
		return this;
	}
	
	public void cerrar(){
		nHelper.close();
	}

	public long guardarRegistro(String usuario, String nombre, String telefono, String correo_electronico, String tipo_usuario) {
		ContentValues cv=new ContentValues();
		cv.put("usuario", usuario);
		cv.put("nombre_persona", nombre);
		cv.put("numero_telefono", telefono);
		cv.put("correo_electronico", correo_electronico);
		cv.put("tipo_usuario", tipo_usuario);
		return nBD.insert("contactos", null, cv);
	}
	
	public String[][] listar() 
	{
		String columnas[] = {"id", "usuario", "nombre_persona","numero_telefono","correo_electronico","tipo_usuario"};
		
		Cursor c = nBD.query("contactos", columnas, null, null, null, null, null);

		String resultado [][] = new String[c.getCount()][columnas.length];
		
		int iIdFila = c.getColumnIndex("id");
		int iNomPersona = c.getColumnIndex("nombre_persona");
		int iNumTelefono = c.getColumnIndex("numero_telefono");
		int iUsuario = c.getColumnIndex("usuario");
		int iCorreoElectronico = c.getColumnIndex("correo_electronico");
		int iTipoUsuario = c.getColumnIndex("tipo_usuario");
		
		int i = 0;
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext(), i++)
		{
			resultado [i][iIdFila]= c.getString(iIdFila);
			resultado [i][iUsuario]= c.getString(iUsuario);
			resultado [i][iNomPersona]= c.getString(iNomPersona);
			resultado [i][iNumTelefono]= c.getString(iNumTelefono);
			resultado [i][iCorreoElectronico]= c.getString(iCorreoElectronico);
			resultado [i][iTipoUsuario]= c.getString(iTipoUsuario); 
		}
		return resultado;
	}

	public void eliminar(String id)
	{
		Cursor c = nBD.rawQuery("DELETE FROM contactos WHERE id = " + id, null);
		c.moveToFirst();
	}

	public void editar(String id, String usuario, String nombre, String telefono, String correo_electronico, String tipo_usuario) 
	{
		
		ContentValues cv = new ContentValues();

		cv.put("usuario", usuario);
		cv.put("nombre_persona", nombre);
		cv.put("numero_telefono", telefono);
		cv.put("correo_electronico", correo_electronico);
		cv.put("tipo_usuario", tipo_usuario);
		
		nBD.update("contactos", cv, " id = "+id, null);
		
	}

	public String[] obtenerRegistro(String id) 
	{
		
		String columnas[] = {"id", "usuario", "nombre_persona","numero_telefono","correo_electronico","tipo_usuario"};
		
		Cursor c = nBD.query("contactos", columnas, "id = "+id, null, null, null, null);

		String resultado [] = new String[columnas.length];
		
		int iIdFila = c.getColumnIndex("id");
		int iNomPersona = c.getColumnIndex("nombre_persona");
		int iNumTelefono = c.getColumnIndex("numero_telefono");
		int iUsuario = c.getColumnIndex("usuario");
		int iCorreoElectronico = c.getColumnIndex("correo_electronico");
		int iTipoUsuario = c.getColumnIndex("tipo_usuario");
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
		{
			resultado [iIdFila]= c.getString(iIdFila);
			resultado [iUsuario]= c.getString(iUsuario);
			resultado [iNomPersona]= c.getString(iNomPersona);
			resultado [iNumTelefono]= c.getString(iNumTelefono);
			resultado [iCorreoElectronico]= c.getString(iCorreoElectronico);
			resultado [iTipoUsuario]= c.getString(iTipoUsuario); 
		}
		return resultado;
		
	}


}
