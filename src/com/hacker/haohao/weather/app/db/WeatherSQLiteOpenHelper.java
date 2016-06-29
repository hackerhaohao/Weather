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
	 * province建表语句
	 */
	private static final String CREATE_PROVINCE = " create table t_province ( " +
			"id integer primary key autoincrement, " +
			"province_name text, " +
			"province_code text)";
	
	
	/**
	 * city建表语句
	 */
	private static final String CREATE_CITY = " create table t_city( " +
			"id integer primary key autoincrement, " +
			"city_name text, " +
			"city_code text, " +
			"province_id integer )";
	/**
	 * county建表语句
	 */
	private static final String CREATE_COUNTY = " create table t_county( " +
			"id integer primary key autoincrement, " +
			"county_name text, " +
			"county_code text, " +
			"city_id integer )";
	
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
		//创建province表
		db.execSQL(CREATE_PROVINCE);
		//创建city表
		db.execSQL(CREATE_CITY);
		//创建county表
		db.execSQL(CREATE_COUNTY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
