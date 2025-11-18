package com.rs.fer.bean;

public class Address {

	   private int id;
	   private String Line1;
	   private String Line2;
	   private String City;
	   private String State;
	   private String Pincode;
	   private String Country;
	   private int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLine1() {
		return Line1;
	}
	public void setLine1(String line1) {
		Line1 = line1;
	}
	public String getLine2() {
		return Line2;
	}
	public void setLine2(String line2) {
		Line2 = line2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
