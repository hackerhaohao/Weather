package com.hacker.haohao.weather.app.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hacker.haohao.weather.app.model.City;
import com.hacker.haohao.weather.app.model.Scenic;

/**
 * 数据库操作的类
 * @author ZhangHao
 *
 */
public class WeatherDatabase{
	
	/**
	 * 数据库名字 
	 */
	public static final String DB_NAME = "weather";
	
	/**
	 * 数据库版本
	 */
	public static final int VERSION = 1;
	
	private static WeatherDatabase weatherDatabase;
	
	private SQLiteDatabase db;
	
	/**
	 * 私有的构造方法
	 */
	private WeatherDatabase(Context context){
		WeatherSQLiteOpenHelper dbHelper = new WeatherSQLiteOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	/**
	 * 获取数据库操作实例
	 */
	public synchronized static WeatherDatabase getInstance(Context context){
		if(weatherDatabase == null){
			weatherDatabase = new WeatherDatabase(context);
		}
		return weatherDatabase;
	}
	
	
	/**
	 * 保存全国city
	 */
	public void saveCity(City city){
		if(null != city){
			ContentValues values = new ContentValues();
			values.put("id", city.getId());
			values.put("city", city.getCity());
			values.put("lat", city.getLat());
			values.put("lon", city.getLon());
			values.put("prov", city.getProv());
			values.put("cnty", city.getCnty());
			db.beginTransaction();
			db.insert("city_info", null, values );
			db.endTransaction();
		}
	}
	
	/**
	 * 从数据库读取某省下所有城市
	 */
	public List<City> loadCities(){
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("city_info", null, null, null,null, null, null);
		if(cursor.moveToFirst()){
			do{
				City city = new City();
				city.setId(cursor.getString(cursor.getColumnIndex("id")));
				city.setCity(cursor.getString(cursor.getColumnIndex("city")));
				city.setLat(cursor.getString(cursor.getColumnIndex("lat")));
				city.setLon(cursor.getString(cursor.getColumnIndex("lon")));
				city.setProv(cursor.getString(cursor.getColumnIndex("prov")));
				city.setCnty(cursor.getString(cursor.getColumnIndex("cnty")));
				list.add(city);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 * 保存County
	 */
	public void saveScenic(Scenic scenic){
		if(null != scenic){
			ContentValues values = new ContentValues();
			values.put("id", scenic.getId());
			values.put("city", scenic.getCity());
			values.put("cnty", scenic.getCnty());
			values.put("lat", scenic.getLat());
			values.put("lon", scenic.getLon());
			db.beginTransaction();
			db.insert("scenic_info", null, values );
			db.endTransaction();
		}
	}
	
	/**
	 * 从数据库读取某省下所有城市
	 */
	public List<Scenic> loadScenics(){
		List<Scenic> list = new ArrayList<Scenic>();
		Cursor cursor = db.query("scenic_info", null, null, null,null, null, null);
		if(cursor.moveToFirst()){
			do{
				Scenic scenic = new Scenic();
				scenic.setId(cursor.getString(cursor.getColumnIndex("id")));
				scenic.setCity(cursor.getString(cursor.getColumnIndex("city")));
				scenic.setCnty(cursor.getString(cursor.getColumnIndex("cnty")));
				scenic.setLat(cursor.getString(cursor.getColumnIndex("lat")));
				scenic.setLon(cursor.getString(cursor.getColumnIndex("lon")));
				list.add(scenic);
			}while(cursor.moveToNext());
		}
		return list;
	}
}
