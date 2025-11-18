package com.rs.fer.bean;

public class Expense {
	
	private int id;
	private String Type;
	private String Date;
	private float Price;
	private int Numberofitems;
	private float Total;
	private String Bywhom;
	private int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getNumberofitems() {
		return Numberofitems;
	}
	public void setNumberofitems(int numberofitems) {
		Numberofitems = numberofitems;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	public String getBywhom() {
		return Bywhom;
	}
	public void setBywhom(String bywhom) {
		Bywhom = bywhom;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	} 
	
}