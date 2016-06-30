package com.hacker.haohao.weather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库类
 * @author ZhangHao
 *
 */
public class WeatherSQLiteOpenHelper extends SQLiteOpenHelper{
	/**
	 * 国内城市建表语句
	 */
	private static final String CREATE_CITY = " create table city_info ( " +
			"id text primary key , " +
			"city text, " +
			"lat text, " +
			"lon text, " +
			"prov text, " +
			"cnty text)";
	
	
	/**
	 * 景点建表语句
	 */
	private static final String CREATE_SCENIC = " create table scenic_info( " +
			"id text primary key, " +
			"city text, " +
			"cnty text, " +
			"lat text, " +
			"lon text )";
	
	/**
	 * 构造方法
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public WeatherSQLiteOpenHelper(Context context, String name,CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_SCENIC);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
