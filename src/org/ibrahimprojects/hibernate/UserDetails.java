package org.ibrahimprojects.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name= "usergab11")
public class UserDetails {
  @Id  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId ;
 // @Transient//cancell cloumn
  private String userName;
  @Temporal(TemporalType.DATE)
//  private Date joinDate;
  @Embedded
  private Adress officeAddress ;
  @Embedded
  @AttributeOverrides({
	  @AttributeOverride(name="Street", column= @Column(name= "HOME_STREET")),
	  @AttributeOverride(name= "City", column = @Column(name= "HOME_CITY")),
	  @AttributeOverride(name= "State", column = @Column(name= "HOME_STATE")),
	  @AttributeOverride(name= "Pincode", column = @Column(name= "HOME_PINCODE"))})
  private Adress homeAddrees;
  @ElementCollection
  @JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
  @GenericGenerator(name = "hilo-gen", strategy = "hilo")
  @CollectionId(columns = { @Column (name ="ADDRESS_ID")}, generator = "hilo-gen", type = @Type(type ="long"))
  private Collection<Adress> listofaddreess = new ArrayList<Adress>();
  
  
  
  
  
  
 // @Lob// text length
//  private String description ; 
  
//public Date getJoinDate() {
//	return joinDate;
//}
//public void setJoinDate(Date joinDate) {
//	this.joinDate = joinDate;
//}


public Collection<Adress> getListofaddreess() {
	return listofaddreess;
}
public void setListofaddreess(Collection<Adress> listofaddreess) {
	this.listofaddreess = listofaddreess;
}



public Adress getOfficeAddress() {
	return officeAddress;
}
public void setOfficeAddress(Adress officeAddress) {
	this.officeAddress = officeAddress;
}
public Adress getHomeAddrees() {
	return homeAddrees;
}
public void setHomeAddrees(Adress homeAddrees) {
	this.homeAddrees = homeAddrees;
}
//public String getDescription() {
//	return description;
//}
//public void setDescription(String description) {
//	this.description = description;
//}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
	
	
	
	
}
