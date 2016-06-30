package com.hacker.haohao.weather.app.model;

import java.io.Serializable;

public class Scenic implements Serializable {

	private static final long serialVersionUID = -6255211634774767828L;

	private String id;
	private String city;
	private String cnty;
	private String lat;
	private String lon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCnty() {
		return cnty;
	}

	public void setCnty(String cnty) {
		this.cnty = cnty;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

}
