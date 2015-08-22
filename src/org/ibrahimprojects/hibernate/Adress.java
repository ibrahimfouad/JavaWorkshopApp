package org.ibrahimprojects.hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
  private String Street;
  private String City;
  private String State;
  private String Pincode;
  
public String getStreet() {
	return Street;
}
public void setStreet(String street) {
	Street = street;
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
  
}
