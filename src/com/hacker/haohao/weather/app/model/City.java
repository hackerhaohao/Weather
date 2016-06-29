package com.hacker.haohao.weather.app.model;

import java.io.Serializable;

/**
 * City 实体
 * 
 * @author ZhangHao
 * 
 */
public class City implements Serializable {

	private static final long serialVersionUID = 2182700274724803802L;

	private int id;

	private String cityName;

	private String cityCode;

	private int provinceId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

}
