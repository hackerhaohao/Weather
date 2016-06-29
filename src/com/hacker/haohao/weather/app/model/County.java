package com.hacker.haohao.weather.app.model;

import java.io.Serializable;

/**
 * County 实体
 * @author ZhangHao
 *
 */
public class County implements Serializable {

	private static final long serialVersionUID = 2311476887141561392L;

	private int id;
	
	private String countyName;
	
	private String countyCode;
	
	private int cityId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
}
