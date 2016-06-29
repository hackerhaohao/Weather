package com.hacker.haohao.weather.app.model;

import java.io.Serializable;

/**
 * Province 实体
 * 
 * @author ZhangHao
 * 
 */
public class Province implements Serializable{
	
	private static final long serialVersionUID = -6025863455536725842L;
	
	private int id;
	
	private String provinceName;

	private String provinceCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

}
