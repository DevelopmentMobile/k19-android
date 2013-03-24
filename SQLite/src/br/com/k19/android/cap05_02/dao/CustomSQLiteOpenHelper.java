package br.com.k19.android.cap05_02.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
	public final static String TABLE_NOTES = "notes";
	public final static String COLUMN_ID = "_id";
	public final static String COLUMN_NOTES = "note";

	private final static String DATABASE_NAME = "notes.db";
	private final static Integer DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NOTES
			+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COLUMN_NOTES + " TEXT NOT NULL);";

	// Database upgrade sql statement
	private static final String DATABASE_UPGRADE = "DROP TABLE IF EXISTS "
			+ TABLE_NOTES;

	public CustomSQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DATABASE_UPGRADE);
		onCreate(db);
	}

}
