/**
 * 
 */
package br.com.michelangelo.android.util;

/**
 * @author Glaydston Veloso
 * @email glaydston.oliveira@gmail.com
 * @since 2013
 * @version 1.0
 */
public class CustomSQLCreate {
	private static StringBuilder builder;

	// Database creation sql Clothes statement
	public final static String TABLES_CLOTHES = "clothes";
	public final static String CLOTHES_COLUNM_ID = "_id";
	public final static String CLOTHES_COLUNM_DESCRIPTION = "description";
	public final static String CLOTHES_COLUNM_IMAGE = "image";
	public final static String CLOTHES_COLUNM_RATING = "rating";
	public final static String CLOTHES_COLUNM_CATEGORY = "category";

	// Database creation sql Category statement
	public final static String TABLES_CATEGORY = "category";
	public final static String CATEGORY_COLUNM_ID = "_id";
	public final static String CATEGORY_COLUNM_DESCRIPTION = "description";

	// Database creation sql Type statement
	public final static String TABLES_TYPE = "type";
	public final static String TYPE_COLUNM_CLOTHES = "_" + TABLES_CLOTHES;
	public final static String TYPE_COLUNM_CATEGORY = "_" + TABLES_CATEGORY;

	/**
	 * Este metodo cria os sqls de upgrade de tabelas
	 * 
	 * @return string
	 */
	public static String upgrade() {
		builder = new StringBuilder();
		builder.append("DROP TABLE IF EXISTS " + TABLES_TYPE + ";");
		builder.append("DROP TABLE IF EXISTS " + TABLES_CATEGORY + ";");
		builder.append("DROP TABLE IF EXISTS " + TABLES_CLOTHES + ";");
		return builder.toString();
	}

	/**
	 * Este metodo cria os sqls de criacao de tabelas
	 * 
	 * @return string
	 */
	public static String create() {
		builder = new StringBuilder();

		builder.append("CREATE TABLE " + TABLES_CLOTHES + "(");
		builder.append(CLOTHES_COLUNM_ID + " INTEGER AUTO_INCREMENT,");
		builder.append(CLOTHES_COLUNM_DESCRIPTION + " TEXT NOT NULL,");
		builder.append(CLOTHES_COLUNM_IMAGE + " BLOB,");
		builder.append(CLOTHES_COLUNM_RATING + " DOUBLE,");
		builder.append(" CONSTRAINT PK_" + TABLES_CLOTHES + " PRIMARY KEY("
				+ CLOTHES_COLUNM_ID + ");");
		
		builder.append("\n");

		builder.append("CREATE TABLE " + TABLES_CATEGORY + "(");
		builder.append(CATEGORY_COLUNM_ID + " INTEGER AUTO_INCREMENT,");
		builder.append(CATEGORY_COLUNM_DESCRIPTION + " TEXT NOT NULL,");
		builder.append("CONSTRAINT PK_" + TABLES_CATEGORY + " PRIMARY KEY("
				+ CATEGORY_COLUNM_ID + "));");
		
		builder.append("\n");

		builder.append("CREATE TABLE " + TABLES_TYPE + "(");
		builder.append(TABLES_CLOTHES + " INTEGER,");
		builder.append(TABLES_CATEGORY + " INTEGER,");
		builder.append("CONSTRAINT PK_" + TABLES_TYPE
				+ " PRIMARY KEY(clothes, category),");
		builder.append("CONSTRAINT FK_" + TABLES_TYPE + "_" + TABLES_CLOTHES
				+ " FOREIGN KEY(" + TABLES_CLOTHES + ") REFERENCES clothes("
				+ CLOTHES_COLUNM_ID + "),");
		builder.append("CONSTRAINT FK_" + TABLES_TYPE + "_" + TABLES_CATEGORY
				+ " FOREIGN KEY(" + TABLES_CATEGORY + ") REFERENCES category("
				+ CATEGORY_COLUNM_ID + "));");

		return builder.toString();
	}
}
