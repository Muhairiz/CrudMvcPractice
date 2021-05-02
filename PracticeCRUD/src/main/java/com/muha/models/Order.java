package com.muha.models;

public class Order {
 private int id;
 private String Ordername;
 private int cust;
 private int item;
 
 public Order() {
	 
 }
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrdername() {
	return Ordername;
}
public void setOrdername(String ordername) {
	Ordername = ordername;
}
public int getCust() {
	return cust;
}
public void setCust(int cust) {
	this.cust = cust;
}
public int getItem() {
	return item;
}
public void setItem(int item) {
	this.item = item;
}
}
