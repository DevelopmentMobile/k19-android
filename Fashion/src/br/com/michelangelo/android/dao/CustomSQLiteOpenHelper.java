/**
 * 
 */
package br.com.michelangelo.android.dao;

import br.com.michelangelo.android.util.CustomSQLCreate;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Glaydston Veloso
 * @email glaydston.oliveira@gmail.com
 * @since 2013
 * @version 1.0
 */
public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {

	// Database name and version
	private final static String DATABASE_NAME = "fashion.db";
	private final static Integer DATABASE_VERSION = 1;

	// Database creation sql statement
	private final static String DATABASE_CREATE = CustomSQLCreate.create();

	// Database upgrade sql statement
	private final static String DATABASE_UPGRADE = CustomSQLCreate.upgrade();

	/**
	 * @description Metodo construtor que recebe o contexto atual e informa a
	 *              superclasse o nome do banco e a versao
	 * @param context
	 */
	public CustomSQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite
	 * .SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite
	 * .SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DATABASE_UPGRADE);
		onCreate(db);
	}

}
