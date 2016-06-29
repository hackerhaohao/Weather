package com.hacker.haohao.weather.app.db;

import java.util.ArrayList;
import java.util.List;

import com.hacker.haohao.weather.app.model.City;
import com.hacker.haohao.weather.app.model.County;
import com.hacker.haohao.weather.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
	 * 保存province
	 */
	public void saveProvince(Province province){
		if(null != province){
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.beginTransaction();
			db.insert("t_province", null, values);
			db.endTransaction();
		}
	}
	
	/**
	 * 读取province
	 */
	public List<Province> loadProvinces(){
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("t_province", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				list.add(province);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 * 保存city
	 */
	public void saveCity(City city){
		if(null != city){
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			db.beginTransaction();
			db.insert("t_city", null, values );
			db.endTransaction();
		}
	}
	
	/**
	 * 从数据库读取某省下所有城市
	 */
	public List<City> loadCities(int provinceId){
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("t_city", null, "province_id = ?", new String[]{String.valueOf(provinceId)},null, null, null);
		if(cursor.moveToFirst()){
			do{
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setProvinceId(provinceId);
				list.add(city);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 * 保存County
	 */
	public void saveCounty(County county){
		if(null != county){
			ContentValues values = new ContentValues();
			values.put("county_name", county.getCountyName());
			values.put("county_code", county.getCountyCode());
			values.put("city_id", county.getCityId());
			db.beginTransaction();
			db.insert("t_county", null, values );
			db.endTransaction();
		}
	}
	
	/**
	 * 从数据库读取某省下所有城市
	 */
	public List<County> loadCounties(int cityId){
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query("t_county", null, "city_id = ?", new String[]{String.valueOf(cityId)},null, null, null);
		if(cursor.moveToFirst()){
			do{
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
				county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
				county.setCityId(cityId);
				list.add(county);
			}while(cursor.moveToNext());
		}
		return list;
	}
}
